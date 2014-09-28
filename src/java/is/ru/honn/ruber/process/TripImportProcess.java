package is.ru.honn.ruber.process;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripStatus;
import is.ru.honn.ruber.service.RuberService;
import is.ru.honn.ruber.service.UserNotFoundException;
import is.ru.honn.ruber.service.UsernameExistsException;
import is.ruframework.http.SimpleHttpRequest;
import is.ruframework.process.RuAbstractProcess;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Locale;
import java.util.logging.Logger;

public class TripImportProcess extends RuAbstractProcess {
    Logger log = Logger.getLogger(this.getClass().getName());
    RuberService ruberService;
    MessageSource msg;
    String history;
    Locale loc = new Locale("EN");

    public void beforeProcess()
    {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("app.xml");
        ruberService = (RuberService) ctx.getBean("RuberService");

        msg = (MessageSource) ctx.getBean("messageSource");
        log.info(msg.getMessage("processbefore", new Object[]{getProcessContext().getProcessName()}, loc));
    }

    public void startProcess()
    {
        log.info(msg.getMessage("processstart", new Object[]{getProcessContext().getProcessName()}, loc));
        try
        {
            history = (SimpleHttpRequest.sendGetRequest(getProcessContext().getImportURL()));

        }catch (Exception e)
        {
            log.info(msg.getMessage("processreaderror", new Object[]{getProcessContext().getImportURL()}, loc));
        }

        Object obj= JSONValue.parse(history);
        JSONObject jsonObj = (JSONObject)obj;
        JSONArray array = (JSONArray)jsonObj.get("history");
        Iterator i = array.iterator();

        while (i.hasNext())
        {
            JSONObject next = (JSONObject)i.next();
            Trip ImportTrip = new Trip();

            float distance = Float.parseFloat(next.get("distance").toString());
            int startTime = Integer.valueOf(next.get("start_time").toString());
            int endTime = Integer.valueOf(next.get("end_time").toString());
            int requestTime = Integer.valueOf(next.get("request_time").toString());
            TripStatus status = TripStatus.COMPLETED;

            ImportTrip.setDistance(distance);
            ImportTrip.setStartTime(startTime);
            ImportTrip.setEndTime(endTime);
            ImportTrip.setRequestTime(requestTime);
            ImportTrip.setProductId((String)next.get("product_id"));
            ImportTrip.setUuid((String)next.get("uuid"));
            ImportTrip.setStatus(status);

            try
            {
                ruberService.addTrips(ImportTrip.getUuid(), ImportTrip);
            }
            catch (UserNotFoundException e)
            {
                log.info(msg.getMessage("nosuchusername", new Object[]{ImportTrip.getUuid()}, loc));
            }
        }

        log.info(msg.getMessage("processstartdone", new Object[]{getProcessContext().getProcessName()}, loc));
    }

    public void afterProcess()
    {
        if(history != null)
        {
            System.out.println(history);
        }
    }
}

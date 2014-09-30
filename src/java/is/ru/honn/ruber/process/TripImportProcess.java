package is.ru.honn.ruber.process;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripStatus;
import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.parser.JsonParse;
import is.ru.honn.ruber.service.RuberService;
import is.ru.honn.ruber.service.UserNotFoundException;
import is.ruframework.http.SimpleHttpRequest;
import is.ruframework.process.RuAbstractProcess;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Iterator;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * Process run by the ru-framework process runner, Reads from website and adds the trip info to the service.
 */
public class TripImportProcess extends RuAbstractProcess {
    Logger log = Logger.getLogger(this.getClass().getName());
    RuberService ruberService;
    MessageSource msg;
    String history;
    Locale loc = Locale.getDefault();
    JSONObject jsonObj;

    /**
     * setting up the application with app.xml
     */
    public void beforeProcess()
    {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("app.xml");
        ruberService = (RuberService) ctx.getBean("RuberService");

        //Stubbing our service
        ruberService.signup("Trudy666", "Trudy", "Fatale", "trudy@maliciousURL.net",
                            "DropTableStudents1", "trudy.gif", "trudy");
        User trudy = ruberService.getUser("Trudy666");
        trudy.setId("7354db54-cc9b-4961-81f2-0094b8e2d215");

        msg = (MessageSource) ctx.getBean("messageSource");
        log.info(msg.getMessage("processbefore", new Object[]{getProcessContext().getProcessName()}, loc));
    }

    /**
     * reads from site, parses to json and adds to trips
     */
    public void startProcess()
    {
        log.info(msg.getMessage("processstart", new Object[]{getProcessContext().getProcessName()}, loc));

        try
        {
            history = (SimpleHttpRequest.sendGetRequest(getProcessContext().getImportURL()));

        }
        catch (Exception e)
        {
            log.info(msg.getMessage("processreaderror", new Object[]{getProcessContext().getImportURL()}, loc));
        }

        Object obj= JSONValue.parse(history);
        jsonObj = (JSONObject)obj;
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
                ruberService.addTrip(ImportTrip.getUuid(), ImportTrip);
            }
            catch (UserNotFoundException e)
            {
                log.info(msg.getMessage("nosuchusername", new Object[]{ImportTrip.getUuid()}, loc));
            }
        }

        log.info(msg.getMessage("processstartdone", new Object[]{getProcessContext().getProcessName()}, loc));
    }

    /**
     * prints out the get-response from website with a little bit of formatting
     */
    public void afterProcess()
    {
        if(history != null)
        {
            System.out.println(JsonParse.PurdyJson(jsonObj).toString());

            /*
            User trudy = ruberService.getUser("Trudy666");
            System.out.println(trudy);
            System.out.println(ruberService.getHistory(trudy.getId()));
            */
        }
    }
}

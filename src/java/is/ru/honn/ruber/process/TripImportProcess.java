package is.ru.honn.ruber.process;

import is.ru.honn.ruber.service.RuberService;
import is.ruframework.http.SimpleHttpRequest;
import is.ruframework.process.RuAbstractProcess;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.FileSystemXmlApplicationContext;
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
            history = SimpleHttpRequest.sendGetRequest(getProcessContext().getImportURL());

        }catch (Exception e)
        {
            log.info(msg.getMessage("processreaderror", new Object[]{getProcessContext().getImportURL()}, loc));
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

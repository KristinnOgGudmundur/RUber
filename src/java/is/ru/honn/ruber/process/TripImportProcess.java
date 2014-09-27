package is.ru.honn.ruber.process;

import is.ru.honn.ruber.service.RuberService;
import is.ruframework.process.RuAbstractProcess;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by Kristinn on 27.9.2014.
 */
public class TripImportProcess extends RuAbstractProcess {
    Logger log = Logger.getLogger(this.getClass().getName());
    RuberService ruberService;
    MessageSource msg;
    Locale loc = new Locale("IS");

    public void beforeProcess()
    {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("app.xml");
        ruberService = (RuberService) ctx.getBean("RuberService");

        msg = (MessageSource) ctx.getBean("messageSource");
        getProcessContext().setProcessName(this.getClass().getSimpleName());
        log.info(msg.getMessage("processbefore", new Object[]{getProcessContext().getProcessName()},loc));
    }

    public void startProcess()
    {
        log.info("start");
    }

    public void afterProcess()
    {
        log.info("after");
    }
}

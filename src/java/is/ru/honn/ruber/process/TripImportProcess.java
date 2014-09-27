package is.ru.honn.ruber.process;

import is.ruframework.process.RuAbstractProcess;

/**
 * Created by Kristinn on 27.9.2014.
 */
public class TripImportProcess extends RuAbstractProcess {

    public void beforeProcess()
    {
        System.out.println("before");
    }

    public void startProcess()
    {
        System.out.println("start");
    }

    public void afterProcess()
    {
        System.out.println("after");
    }
}

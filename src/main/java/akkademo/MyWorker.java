package akkademo;

import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MyWorker extends UntypedAbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    @Override
    public void preStart() throws Exception {
        System.out.println("MyWorker is starting");
    }

    @Override
    public void onReceive(Object message) throws Throwable {

    }
}

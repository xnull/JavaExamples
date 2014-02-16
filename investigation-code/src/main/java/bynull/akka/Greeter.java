package bynull.akka;

import akka.actor.UntypedActor;

/**
 * Created by null on 2/17/14.
 */
public class Greeter extends UntypedActor {

    public static enum Msg {
        GREET, DONE;
    }

    @Override
    public void onReceive(Object msg) {
        System.out.println("Hello, I am Creeter actor, my path is: " + getSelf().path());
        if (msg == Msg.GREET) {
            System.out.println("Hello World from greeter!");
            getSender().tell(Msg.DONE, getSelf());
        } else unhandled(msg);
    }
}


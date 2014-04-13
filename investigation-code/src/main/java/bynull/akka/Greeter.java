package bynull.akka;

import akka.actor.UntypedActor;
import bynull.Utils.Utils;

/**
 * Created by null on 2/17/14.
 */
public class Greeter extends UntypedActor {

    public static enum Msg {
        GREET, DONE;
    }

    @Override
    public void onReceive(Object msg) {
        Utils.print("Greeter thread: " + Thread.currentThread().getName());
        Utils.print("Hello, I am Creeter actor, my path is: " + getSelf().path());
        if (msg == Msg.GREET) {
            Utils.print("Hello World from greeter!");
            getSender().tell(Msg.DONE, getSelf());
        } else unhandled(msg);
    }
}


package bynull.akka;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.japi.Creator;
import bynull.Utils.Utils;

/**
 * Created by null on 2/17/14.
 */
public class HelloWorldActor extends UntypedActor {

    private static class GreeterCreator implements Creator<Greeter> {
        @Override
        public Greeter create() throws Exception {
            Utils.print("Build greeter in thread: " + Thread.currentThread().getName());
            return new Greeter();
        }
    }

    @Override
    public void preStart() {
        Utils.print("Hello world actor thread: " + Thread.currentThread().getName());

        Utils.print("Hello, I am HelloWorld actor, my path is: " + getSelf().path());
        // create the greeter actor
        final ActorRef greeter =
                getContext().actorOf(Props.create(new GreeterCreator()));
        // tell it to perform the greeting
        greeter.tell(Greeter.Msg.GREET, getSelf());
    }

    @Override
    public void onReceive(Object msg) {
        if (msg == Greeter.Msg.DONE) {
            // when the greeter is done, stop this actor and with it the application
            Utils.print("Goodby greeter in thread: " + Thread.currentThread().getName());
            getContext().stop(getSelf());
            Utils.print("Hello world actor stoped : " + Thread.currentThread().getName());
        } else unhandled(msg);
    }

}

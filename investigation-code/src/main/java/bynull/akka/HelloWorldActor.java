package bynull.akka;

import akka.actor.Actor;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.actor.ActorRef;
import akka.japi.Creator;

/**
 * Created by null on 2/17/14.
 */
public class HelloWorldActor extends UntypedActor {

    private static class GreeterCreator implements Creator<Greeter> {
        @Override
        public Greeter create() throws Exception {
            System.out.println("Build greeter in thread: " + Thread.currentThread().getName());
            return new Greeter();
        }
    }

    @Override
    public void preStart() {
        System.out.println("Hello world actor thread: " + Thread.currentThread().getName());

        System.out.println("Hello, I am HelloWorld actor, my path is: " + getSelf().path());
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
            System.out.println("Goodby greeter in thread: " + Thread.currentThread().getName());
            getContext().stop(getSelf());
            System.out.println("Hello world actor stoped : " + Thread.currentThread().getName());
        } else unhandled(msg);
    }

}

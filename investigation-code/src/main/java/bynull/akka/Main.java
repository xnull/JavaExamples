package bynull.akka;

import akka.actor.*;

/**
 * Created by null on 2/17/14.
 */
public class Main {

    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("MySystem");
        system.actorOf(Props.create(HelloWorldActor.class));
    }
}

package bynull.akka;

import akka.actor.Props;
import akka.japi.Creator;
import bynull.Utils.Utils;

import java.util.concurrent.TimeUnit;

/**
 * Created by null on 2/17/14.
 */
public class Main {
    private static class HelloWorldCreator implements Creator<HelloWorldActor> {
        @Override
        public HelloWorldActor create() throws Exception {
            Utils.print("Build hello world actor in thread: " + Thread.currentThread().getName());
            return new HelloWorldActor();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Utils.print("Main thread: " + Thread.currentThread().getName());

        HelloWorldCreator hwCreator = new HelloWorldCreator();
        //TYPED_ACTOR_EXTENSION.typedActorOf(new TypedProps())
        AkkaManager.SYSTEM.actorOf(Props.create(hwCreator));
        AkkaManager.SYSTEM.actorOf(Props.create(hwCreator));

        TimeUnit.SECONDS.sleep(3);
        AkkaManager.SYSTEM.shutdown();
    }
}

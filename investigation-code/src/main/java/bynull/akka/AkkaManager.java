package bynull.akka;

import akka.actor.ActorSystem;
import akka.actor.TypedActor;
import akka.actor.TypedActorExtension;

/**
 * Created by null on 3/6/14.
 */
public class AkkaManager {

    public static final ActorSystem SYSTEM = ActorSystem.create("system");
    public static final TypedActorExtension TYPED_ACTOR_EXTENSION = TypedActor.get(SYSTEM);

}

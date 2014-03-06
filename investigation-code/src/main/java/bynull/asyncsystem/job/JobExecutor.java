package bynull.asyncsystem.job;

import akka.actor.ActorSystem;
import akka.actor.TypedActor;
import akka.actor.TypedActorExtension;
import bynull.asyncsystem.Workform;
import bynull.asyncsystem.repo.WorkformRepository;
import bynull.asyncsystem.task.Task;
import bynull.asyncsystem.task.TaskExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by null on 3/5/14.
 */
public class JobExecutor {

    private WorkformRepository wfRepo;
    private TaskExecutor taskExecutor;

    public static final ActorSystem AKKA = ActorSystem.create("MySystem");
    public static final TypedActorExtension TYPED_ACTOR_EXTENSION = TypedActor.get(AKKA);


    public void execute(Workform wf){

        /**
         * - load workform from db
         * - load metadata
         * - execute task in task executor
         *
         * start task
         */

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task());

        for (Task task : tasks) {
            taskExecutor.execute(task);
        }
    }
}

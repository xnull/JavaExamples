package bynull.asyncsystem.task;

import akka.actor.UntypedActor;

/**
 * Created by null on 3/5/14.
 */
public class TaskExecutor extends UntypedActor {

    private boolean loked = true;
    private TaskHandler taskHandler;

    public synchronized void execute(Task task) {
        //execute task, how? async sync?

        //pass task to the task handler and wait answer

        //send it asynchroniously
        TypedActor.get
        taskHandler.execute(task);
    }

    @Override
    public void onReceive(Object o) throws Exception {

    }
}

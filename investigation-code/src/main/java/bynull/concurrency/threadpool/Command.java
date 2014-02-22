package bynull.concurrency.threadpool;

/**
 * Created by null on 2/21/14.
 */
public interface Command {
    void execute(Worker worker, CommandResult resulter) throws Exception;

    String getResult();
}

package bynull.concurrency.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by null on 2/21/14.
 */
public class ThreadPool {

    private ExecutorService pool;
    private WorkQueue workQueue = new WorkQueue();

    public ThreadPool(int threadCount, CommandResult resulter) {
        pool = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            Worker worker = new Worker(workQueue, "Worker-" + i, resulter);
            pool.execute(worker);
        }
    }

    public void execute(Command command) {
        workQueue.add(command);
    }

    public void shutdown() {
        pool.shutdownNow();
    }
}

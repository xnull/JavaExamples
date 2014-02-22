package bynull.concurrency.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by null on 2/21/14.
 */
public class Worker implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Worker.class);

    private WorkQueue queue;
    private String workerName;

    public Worker(WorkQueue queue, String workerName) {
        this.queue = queue;
        this.workerName = workerName;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.get().execute(this);
            } catch (WorkQueueException e) {
                break;
            } catch (Exception e) {
                logger.error("Error execute Action");
            }
        }

        logger.error("Stop worker because of interrupted exception");
    }

    public String getWorkerName() {
        return workerName;
    }
}

package bynull.concurrency.threadpool;

/**
 * Created by null on 2/22/14.
 */
public class WorkQueueException extends Exception {
    public WorkQueueException() {
    }

    public WorkQueueException(String message) {
        super(message);
    }

    public WorkQueueException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkQueueException(Throwable cause) {
        super(cause);
    }

    public WorkQueueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

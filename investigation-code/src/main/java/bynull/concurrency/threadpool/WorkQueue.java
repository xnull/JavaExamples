package bynull.concurrency.threadpool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by null on 2/21/14.
 */
public class WorkQueue {

    private Queue<Command> queue = new LinkedList<>();

    public void add(Command element) {
        synchronized (queue) {
            queue.offer(element);
            queue.notifyAll();
        }
    }

    public Command get() throws WorkQueueException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException ex) {
                    throw new WorkQueueException();
                }
            }
            return queue.poll();
        }
    }
}

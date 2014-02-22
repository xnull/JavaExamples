package bynull.concurrency.reentrantlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by null on 2/22/14.
 */
public class SharedObject {

    private ReentrantLock lock = new ReentrantLock();
    private List<Integer> list = new ArrayList<>();

    public void addElement(Integer element) {
        lock.lock();
        if (lock.getQueueLength() > 1){
            System.out.println("Holded threads: " + lock.getQueueLength() + ". List size: " + list.size());
        }

        try {
            list.add(element);
        } finally {
            lock.unlock();
        }
    }
}

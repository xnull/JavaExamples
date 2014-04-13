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
        System.out.println("Accuire lock. Thread: " + getThreadName());
        lock.lock();
        System.out.println("Lock is acuired. Thread: " + getThreadName());

        if (lock.getQueueLength() > 1){
            System.out.println("Holded threads: " + lock.getQueueLength() + ". List size: " + list.size());
        }

        try {
            System.out.println("Add element to list. In thread: " + getThreadName());
            list.add(element);
        } finally {
            System.out.println("Unlock. In thread: " + getThreadName());
            lock.unlock();
        }
    }

    private String getThreadName() {
        return Thread.currentThread().getName();
    }
}

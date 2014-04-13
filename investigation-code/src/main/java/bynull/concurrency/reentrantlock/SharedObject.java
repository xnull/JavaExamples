package bynull.concurrency.reentrantlock;

import bynull.Utils.Utils;

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
        Utils.print("Accuire lock. Thread: " + getThreadName());
        lock.lock();
        Utils.print("Lock is acuired. Thread: " + getThreadName());

        if (lock.getQueueLength() > 1) {
            Utils.print("Holded threads: " + lock.getQueueLength() + ". List size: " + list.size());
        }

        try {
            Utils.print("Add element to list. In thread: " + getThreadName());
            list.add(element);
        } finally {
            Utils.print("Unlock. In thread: " + getThreadName());
            lock.unlock();
        }
    }

    private String getThreadName() {
        return Thread.currentThread().getName();
    }
}

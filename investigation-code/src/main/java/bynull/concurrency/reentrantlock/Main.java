package bynull.concurrency.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by null on 2/22/14.
 */
public class Main {

    public static void main(String[] args) {
        SharedObject shared = new SharedObject();

        for (int i = 0; i < 1000; i++) {
            startNewThread(shared);
        }
    }

    private static void startNewThread(final SharedObject shared) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    shared.addElement(1);
                }
            }
        });

        t.start();
    }
}

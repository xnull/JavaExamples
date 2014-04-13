package bynull.concurrency.nonblockingalgorithms;

import bynull.Utils.Utils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by null on 2/7/14.
 */
public class Counter {

    private static final int TIMEOUT = 100;
    private static final int THEADS = 1000;

    private AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        Utils.print("Start program");
        final Counter counter = new Counter();
        for (int i = 0; i < THEADS; i++) {
            startThread(counter);
        }
    }

    private static void startThread(final Counter counter) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    counter.incrment();
                    try {
                        Thread.sleep(TIMEOUT);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }

    private void incrment() {
        while (true) {
            int currentValue = counter.get();
            boolean result = counter.compareAndSet(currentValue, currentValue + 1);

            if (result) {
                break;
            } else {
                Utils.print("Fail. Current value: " + currentValue);
            }
        }
    }
}

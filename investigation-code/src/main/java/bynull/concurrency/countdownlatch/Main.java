package bynull.concurrency.countdownlatch;

import bynull.Utils.Utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by null on 4/13/14.
 */
public class Main {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Utils.print("Wait count down. Thread: " + Thread.currentThread().getName());
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Utils.print("Hey hello niga");
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        Utils.print("Count down. Main thread");
        countDownLatch.countDown();

        TimeUnit.SECONDS.sleep(1);
        Utils.print("End the program");
    }
}

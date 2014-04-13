package bynull.concurrency.executors;

import bynull.Utils.Utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by null on 4/13/14.
 */
public class SingleThreadExecutor {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService ex = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int x = i;
            Utils.print("Execute command asynchronously. x = " + x);
            ex.execute(new Runnable() {
                @Override
                public void run() {
                    Utils.print("Start operation in thread: " + Thread.currentThread().getName());
                    Utils.print("x = " + x);
                    Utils.print("End operation in thread: " + Thread.currentThread().getName());
                }
            });
        }

        Utils.print("Sleep for 1 second in main thread");
        TimeUnit.SECONDS.sleep(1);

        Utils.print("Stop the pool");
        ex.shutdownNow();

        Utils.print("The end of the main thread");
    }
}

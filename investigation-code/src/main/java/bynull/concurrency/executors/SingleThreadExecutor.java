package bynull.concurrency.executors;

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
            System.out.println("Execute command asynchronously. x = " + x);
            ex.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Start operation in thread: " + Thread.currentThread().getName());
                    System.out.println("x = " + x);
                    System.out.println("End operation in thread: " + Thread.currentThread().getName());
                }
            });
        }

        System.out.println("Sleep for 1 second in main thread");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("Stop the pool");
        ex.shutdownNow();

        System.out.println("The end of the main thread");
    }
}

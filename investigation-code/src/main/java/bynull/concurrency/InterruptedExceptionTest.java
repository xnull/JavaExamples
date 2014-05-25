package bynull.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by null on 25.05.14.
 */
public class InterruptedExceptionTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new MyWorker());
        t.start();

        TimeUnit.SECONDS.sleep(3);

        System.out.println("Let's interrupt this shit");
        t.interrupt();
        System.out.println("Done");
    }

    private static class MyWorker implements Runnable {

        @Override
        public void run() {
            while (true) {
                Thread.yield();
            }
        }
    }
}

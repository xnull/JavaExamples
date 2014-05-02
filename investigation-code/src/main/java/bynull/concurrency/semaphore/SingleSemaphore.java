package bynull.concurrency.semaphore;

import bynull.Utils.Utils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by null on 4/13/14.
 */
public class SingleSemaphore {

    public static void main(String[] args) throws InterruptedException {
        final Semaphore sema = new Semaphore(1);
        Utils.print("aquire sema");
        sema.acquire();

        new Thread() {
            @Override
            public void run() {
                try {
                    Utils.print("aquire sema");
                    sema.acquire();
                    Utils.print("doing actions");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Utils.print("Release sema");
                    sema.release();
                }
            }
        }.start();

        TimeUnit.SECONDS.sleep(1);
        Utils.print("release sema in a second");
        TimeUnit.SECONDS.sleep(1);
        sema.release();
    }
}

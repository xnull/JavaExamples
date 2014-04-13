package bynull.concurrency;

import bynull.Utils.Utils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author: null
 * Date: 04.01.14
 * Time: 17:34
 */
public class ForkJoinMain {

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.execute(new ForkJoinTask<String>() {
            @Override
            public String getRawResult() {
                Utils.print("get raw result");
                return null;
            }

            @Override
            protected void setRawResult(String value) {
                Utils.print("set raw result");
            }

            @Override
            protected boolean exec() {
                Utils.print("exec");
                return false;
            }
        });

        Thread.sleep(3000L);
        forkJoinPool.shutdown();
    }
}

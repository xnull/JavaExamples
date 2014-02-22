package bynull.concurrency.threadpool;

import java.util.concurrent.TimeUnit;

/**
 * Created by null on 2/21/14.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            threadPool.execute(new Command() {
                @Override
                public void execute(Worker worker) throws Exception {
                    System.out.println("Hey hello. Worker: " + worker.getWorkerName());
                }
            });
        }

        TimeUnit.SECONDS.sleep(1);
        threadPool.shutdown();
    }
}

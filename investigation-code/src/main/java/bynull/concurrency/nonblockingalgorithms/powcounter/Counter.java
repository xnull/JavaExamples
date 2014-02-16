package bynull.concurrency.nonblockingalgorithms.powcounter;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by null on 2/15/14.
 */
public class Counter {

    public static class Rsulter {
        private boolean resultIsPrinted = false;

        public void printResult(BigInteger result, AtomicInteger fails) {
            //System.out.println("Length Kbytes: " + result.bitCount() / 1024 / 1024);
            //System.out.println(getResultValue(result) + ". Fails: " + fails.get());
            System.out.println(". Fails: " + fails.get());
            resultIsPrinted = true;
        }

        private String getResultValue(BigInteger result) {
            return "Result: " + result.toString().length();
        }

        public boolean alreadyPrinted(){
            return resultIsPrinted;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Powerator powerator = new Powerator(200000);
        final Rsulter resulter = new Rsulter();

        int processors = Runtime.getRuntime().availableProcessors();

        final ExecutorService tPool = Executors.newFixedThreadPool(processors);

        for (int i = 0; i < processors; i++) {
            tPool.submit(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        boolean finishIt = powerator.pow(tPool, resulter);
                        if (finishIt){
                            break;
                        }
                    }
                }
            });
        }

        while (true){
            TimeUnit.SECONDS.sleep(60);
        }
    }
}

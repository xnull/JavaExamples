package bynull.concurrency.nonblockingalgorithms.powcounter;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by null on 2/15/14.
 */
public class Powerator {
    private static final BigInteger multiplier = BigInteger.valueOf(2);
    private static Integer finish;

    private static class PowResult {

        private BigInteger currentResult;
        private int counter = 0;

        public PowResult() {
            this.currentResult = new BigInteger("1");
        }

        public PowResult(PowResult oldValue) {
            currentResult = oldValue.currentResult;
            counter = oldValue.counter;
        }

        public void nextValue() {
            counter++;
            currentResult = currentResult.multiply(multiplier);
        }

        public boolean thisIsTheEnd() {
            return counter == Powerator.finish;
        }
    }

    private AtomicReference<PowResult> currentResult = new AtomicReference<>(new PowResult());
    private Object resultSynchronizer = new Object();
    private AtomicInteger fails = new AtomicInteger(0);

    public Powerator(int finish) {
        Powerator.finish = finish;
    }

    public boolean pow(ExecutorService tPool, Counter.Rsulter resulter) {
        while (true) {
            PowResult oldValue = currentResult.get();
            if (oldValue.thisIsTheEnd()) {
                synchronized (resultSynchronizer) {
                    if (!resulter.alreadyPrinted()) {
                        resulter.printResult(getResult(), fails);
                    }
                    return true;
                }
            }

            PowResult newValue = new PowResult(oldValue);
            newValue.nextValue();

            boolean success = currentResult.compareAndSet(oldValue, newValue);

            if (success) {
                return false;
            } else {
                fails.getAndIncrement();
            }
        }
    }

    public BigInteger getResult() {
        return currentResult.get().currentResult;
    }
}

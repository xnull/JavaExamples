package bynull.concurrency.safepublication.unsafe;

import bynull.Utils.Utils;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by null on 2/8/14.
 */
public class MainUnsafe {

    private static AtomicLong counter = new AtomicLong(1);
    private static UnsafeObject obj;

    public static void main(String[] args) {
        while (true) {
            tryToGetUnsafePublication();

            long currCounter = counter.get();
            if (currCounter % 5000 == 0) {
                Utils.print("Counter: " + counter.get());
            }
        }
    }

    private static void tryToGetUnsafePublication() {
        obj = null;
        startNewThread(unsafePublication());
    }

    private static Runnable unsafePublication() {
        return new Runnable() {
            @Override
            public void run() {
                obj = new UnsafeObject(10, UUID.randomUUID().toString());
                startNewThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Integer age = obj.getAge();
                            String name = obj.getName();
                            if (name == null || age == null) {
                                long currCounter = counter.get();
                                Utils.print("Unsafe publication. Iteration: " + currCounter + "\n Object, name: " + name + ", age: " + age);
                                System.exit(0);
                            }
                        } catch (Exception e) {
                            //
                        }
                        counter.getAndIncrement();
                    }
                });
            }
        };
    }

    private static void startNewThread(Runnable r) {
        new Thread(r).start();
    }
}

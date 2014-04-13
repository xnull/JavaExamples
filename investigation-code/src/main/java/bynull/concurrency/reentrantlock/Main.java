package bynull.concurrency.reentrantlock;

/**
 * Created by null on 2/22/14.
 */
public class Main {

    public static void main(String[] args) {
        SharedObject shared = new SharedObject();

        for (int i = 0; i < 5; i++) {
            startNewThread(shared);
        }
    }

    private static void startNewThread(final SharedObject shared) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    shared.addElement(1);
                }
            }
        });

        t.start();
    }
}

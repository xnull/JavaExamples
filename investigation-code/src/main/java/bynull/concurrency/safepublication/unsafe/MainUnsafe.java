package bynull.concurrency.safepublication.unsafe;

import java.util.UUID;

/**
 * Created by null on 2/8/14.
 */
public class MainUnsafe {

    private static UnsafeObject obj;

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            tredo();
        }
    }

    private static void tredo() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (obj == null) {
                        obj = new UnsafeObject(1, "Fedya");
                    }
                    try {
                        if (obj.getAge() == null || obj.getName() == null) {
                            System.out.println("AXTUUUUNG!!!");
                        }
                    } catch (Exception e) {

                    }

                    obj = null;
                }
            }
        });
        t.setName(UUID.randomUUID().toString());
        t.start();
    }
}

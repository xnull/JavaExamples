package bynull.concurrency.safepublication.unsafe;

/**
 * Created by null on 2/8/14.
 */
public class MainUnsafe {

    private static UnsafeObject obj;

    public static void main(String[] args) {

        while (true) {
            tredo();
        }
    }

    private static void tredo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (obj == null) {
                    obj = new UnsafeObject(1, "Fedya");
                }
                if (obj != null && obj.getAge() == null ||obj != null && obj.getName() == null) {
                    System.out.println("AXTUUUUNG!!!");
                }

                obj = null;
            }
        }).start();
    }
}

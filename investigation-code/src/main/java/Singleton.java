import bynull.Utils.Utils;

/**
 * @author: null
 * Date: 02.02.14
 * Time: 23:12
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
        Utils.print("Singleton constructor");
    }

    public static Singleton getInstance() {
        Utils.print("Singleton get instance");
        return InnerInitializer.INSTANCE;
    }

    private static class InnerInitializer {
        private static final Singleton INSTANCE = getSingleton();

        private static Singleton getSingleton() {
            Utils.print("Instatiate singleton");
            return new Singleton();
        }
    }
}

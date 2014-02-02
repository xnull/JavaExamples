/**
 * @author: null
 * Date: 02.02.14
 * Time: 23:12
 */
public class Singleton {

    private static Singleton instance;

    private Singleton(){
        System.out.println("Singleton constructor");
    }

    public static Singleton getInstance(){
        System.out.println("Singleton get instance");
        return InnerInitializer.INSTANCE;
    }

    private static class InnerInitializer{
        private static final Singleton INSTANCE = getSingleton();

        private static Singleton getSingleton() {
            System.out.println("Instatiate singleton");
            return new Singleton();
        }
    }
}

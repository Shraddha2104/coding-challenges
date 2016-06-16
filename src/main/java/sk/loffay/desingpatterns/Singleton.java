package sk.loffay.desingpatterns;

/**
 * @author Pavol Loffay
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    /**
     * Note that it can produce two instances in concurrent environment.
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    /**
     * Better way but affects performance
     */
    public synchronized static Singleton getInstanceSynchronized() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    /**
     * The best way, double-checked locking
     */
    private static Object lock = new Object();
    public static Singleton getInstanceSynchronizedBetterPerformance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}

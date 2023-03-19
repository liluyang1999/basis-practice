package pattern;

public class Singleton {

    private volatile static Singleton instance = new Singleton();

    private Singleton() { }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}

class Singleton2 {

    private Singleton2() { }

    private static class InstanceHolder {
        private static final Singleton2 instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return InstanceHolder.instance;
    }

}






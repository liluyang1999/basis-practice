package grammar.nowcoder;

public class Java28 {

    public static void main(String[] args) {
        Java28Singleton s1 = Java28Singleton.getInstance();
        Java28Singleton s2 = Java28Singleton.getInstance();
        System.out.println(s1 == s2);
    }

}

class Java28Singleton {

    private static volatile Java28Singleton instance;

    private Java28Singleton() { }

    //write your code here......
    public static Java28Singleton getInstance() {
        if (instance == null) {
            synchronized (Java28Singleton.class) {
                if (instance == null) {
                    instance = new Java28Singleton();
                }
            }
        }

        return instance;
    }

}

package pattern;

import java.util.ArrayList;

public abstract class Prototype implements Cloneable {

    public static void main(String[] args) {
        Prototype prototype = new ShallowClone();
        Prototype prototype2 = prototype.clone();
        System.out.println(prototype.list == prototype2.list);

        Prototype prototype3 = new DeepClone();
        Prototype prototype4 = prototype3.clone();
        System.out.println(prototype3.list == prototype4.list);
    }

    protected ArrayList<String> list = new ArrayList<>();

    public Prototype() {
        System.out.println("执行了父类构造方法！");
    }

    @Override
    public Prototype clone() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}

class ShallowClone extends Prototype {

    public ShallowClone() {
        super();
        System.out.println("执行了浅克隆类构造方法！");
    }

    @Override
    public ShallowClone clone() {
        System.out.println("执行了浅克隆！");
        return (ShallowClone) super.clone();
    }
}

class DeepClone extends Prototype {

    public DeepClone() {
        super();
        System.out.println("执行了深克隆类构造方法！");
    }

    @Override
    public DeepClone clone() {
        System.out.println("执行了深克隆！");
        DeepClone deepClone = (DeepClone) super.clone();
        deepClone.list = (ArrayList<String>)(this.list).clone();
        return deepClone;
    }

}

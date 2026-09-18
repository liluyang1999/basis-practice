package pattern.creational_pattern;

public abstract class Builder {

    public static void main(String[] args) {
        Product product = Director.construct(new BuilderA());
        System.out.println(product);
    }

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    public abstract Product getProduct();

}

class Director {

    private static Builder builder;

    public static void setBuilder(Builder builder) {
        Director.builder = java.util.Objects.requireNonNull(builder);
    }

    public static Product construct() {
        if (builder == null) throw new IllegalStateException("set a builder first");
        return construct(builder);
    }

    public static Product construct(Builder builder) {
        java.util.Objects.requireNonNull(builder);
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getProduct();
    }

}

class BuilderA extends Builder {

    private final Product product = new Product();

    @Override
    public void buildPartA() {
        System.out.println("Build part A......");
        product.setPartA("Part A");
    }

    @Override
    public void buildPartB() {
        System.out.println("Build part B......");
        product.setPartB("Part B");
    }

    @Override
    public void buildPartC() {
        System.out.println("Build part C......");
        product.setPartC("Part C");
    }

    public Product getProduct() {
        Product snapshot = new Product();
        snapshot.setPartA(product.getPartA());
        snapshot.setPartB(product.getPartB());
        snapshot.setPartC(product.getPartC());
        return snapshot;
    }

}

class Product {

    private String partA;

    private String partB;

    private String partC;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    @Override
    public String toString() {
        return "Product{" +
                "partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                '}';
    }

}

package pattern;

public abstract class Builder {

    public static void main(String[] args) {
        Director.setBuilder(new BuilderA());
        Product product = Director.construct();
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
        Director.builder = builder;
    }

    public static Product construct() {
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
        return product;
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

package builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者模式
 *
 * 2020.12.16
 */
class Product {

    private List<String> parts = new ArrayList<>();

    public Product() {
    }

    public void add(String part) {
        this.parts.add(part);
    }

    public void show() {
        System.out.println("产品 创建---");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}

abstract class Builder {

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract Product getResult();
}

class ConcreteBuilderA extends Builder {

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("部件A");
    }

    @Override
    public void buildPartB() {
        product.add("部件B");
    }

    @Override
    public Product getResult() {
        return this.product;
    }
}

class ConcreteBuilderB extends Builder {

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("部件X");
    }

    @Override
    public void buildPartB() {
        product.add("部件Y");
    }

    @Override
    public Product getResult() {
        return this.product;
    }
}

class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPartA();
        builder.buildPartB();
    }
}

public class BuilderExampleClass {

    public static void main(String[] args) {
        Builder b1 = new ConcreteBuilderA();
        Director director1 = new Director(b1);
        director1.construct();
        Product p1 = b1.getResult();
        p1.show();

        Builder b2 = new ConcreteBuilderB();
        Director director2 = new Director(b2);
        director2.construct();
        Product p2 = b2.getResult();
        p2.show();
    }
}

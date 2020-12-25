package factory.abstractfactory;

/**
 * 抽象工厂方法
 *
 * 2020.12.17
 */
abstract class AbstractProductA {

    public abstract void method();
}

class ProductA1 extends AbstractProductA {

    @Override
    public void method() {
        System.out.println("ProductA1");
    }
}

class ProductA2 extends AbstractProductA {

    @Override
    public void method() {
        System.out.println("ProductA2");
    }
}

abstract class AbstractProductB {

    public abstract void method();
}

class ProductB1 extends AbstractProductB {

    @Override
    public void method() {
        System.out.println("ProductB1");
    }
}

class ProductB2 extends AbstractProductB {

    @Override
    public void method() {
        System.out.println("ProductB2");
    }
}

// 抽象工厂接口
interface AbstractFactory {

    public abstract AbstractProductA createProductA();

    public abstract AbstractProductB createProductB();
}

class ConcreteFactory1 implements AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}

class ConcreteFactory2 implements AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}

public class AbstractFactoryExampleClass {

    public static void main(String[] args) {
        AbstractFactory concreteFactory1 = new ConcreteFactory1();
        AbstractProductA productA1 = concreteFactory1.createProductA();
        productA1.method();
        AbstractProductB productB1 = concreteFactory1.createProductB();
        productB1.method();

        AbstractFactory concreteFactory2 = new ConcreteFactory2();
        AbstractProductA productA2 = concreteFactory2.createProductA();
        productA2.method();
        AbstractProductB productB2 = concreteFactory2.createProductB();
        productB2.method();
    }
}

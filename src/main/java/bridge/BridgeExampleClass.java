package bridge;

/**
 * 桥接模式
 *
 * 2020.12.22
 */
abstract class Implementor {
    public abstract void operation();
}

class ConcreteImplementorA extends Implementor {

    @Override
    public void operation() {
        System.out.println("具体实现A的方法执行");
    }
}

class ConcreteImplementorB extends Implementor {

    @Override
    public void operation() {
        System.out.println("具体实现B的方法执行");
    }
}

abstract class Abstraction {

    protected Implementor implementor;

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operation();
}

class RefinedAbstraction extends Abstraction {

    @Override
    public void operation() {
        this.implementor.operation();
    }
}

public class BridgeExampleClass {

    public static void main(String[] args) {
        Abstraction abstraction = new RefinedAbstraction();

        abstraction.setImplementor(new ConcreteImplementorA());
        abstraction.operation();

        abstraction.setImplementor(new ConcreteImplementorB());
        abstraction.operation();
    }
}

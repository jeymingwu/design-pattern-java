package templatemethod;

/**
 * 模版方法模式
 *
 * 2020.12.15
 */

// 抽象模版
abstract class AbstractClass {
    public abstract void primitiveOperation1();
    public abstract void primitiveOperation2();

    // 模版方法，逻辑的骨架；逻辑的组成是一些相应的抽象操作；
    public void templateMethod() {
        this.primitiveOperation1();
        this.primitiveOperation2();
        System.out.println("模版方法");
    }
}

class ConcreteClassA extends AbstractClass {

    @Override
    public void primitiveOperation1() {
        System.out.println("具体类 A 方法 1 实现");
    }

    @Override
    public void primitiveOperation2() {
        System.out.println("具体类 A 方法 2 实现 ");
    }
}

class ConcreteClassB extends AbstractClass {

    @Override
    public void primitiveOperation1() {
        System.out.println("具体类 B 方法 1 实现");
    }

    @Override
    public void primitiveOperation2() {
        System.out.println("具体类 B 方法 2 实现 ");
    }
}

public class TemplateMethodExampleClass {

    public static void main(String[] args) {
        AbstractClass abstractClass;

        abstractClass = new ConcreteClassA();
        abstractClass.templateMethod();

        abstractClass = new ConcreteClassB();
        abstractClass.templateMethod();
    }
}

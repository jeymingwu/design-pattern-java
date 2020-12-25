package decorator;

/**
 * 装饰模式测试
 *
 * 2020.12.14
 */
public class DecoratorTestDemo {

    public static void main(String[] args) {

        Component component = new ConcreteComponent();
        Decorator componentA = new ConcreteDecoratorA();
        Decorator componentB = new ConcreteDecoratorB();

        componentA.setComponent(component);
        componentA.operation();

        System.out.println();
        componentB.setComponent(componentA);
        componentB.operation();

    }
}

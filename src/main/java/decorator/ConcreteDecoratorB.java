package decorator;

public class ConcreteDecoratorB extends Decorator{

    private void addedBehavior() {
    }

    @Override
    public void operation() {
        super.operation();
        addedBehavior();
        System.out.println("具体装饰对象B的操作");
    }
}

package decorator;

public class ConcreteDecoratorA extends Decorator{

    private String addedState;

    @Override
    public void operation() {
        super.operation();
        addedState = "具体装饰对象A的操作";
        System.out.println(addedState);
    }
}

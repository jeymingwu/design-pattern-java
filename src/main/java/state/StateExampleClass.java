package state;

/**
 * 状态模式
 *
 * 2020.12.17
 */

class Context {

    private State state;

    public Context(State state) {
        this.state = state;
    }


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        System.out.println("状态改变:" + this.state.getClass().getName());
    }

    public void request() {
        this.state.handler(this);
    }
}

abstract class State {

    public abstract void handler(Context context);
}

class ConcreteStateA extends State {

    @Override
    public void handler(Context context) {
        context.setState(new ConcreteStateB());
    }
}

class ConcreteStateB extends State {

    @Override
    public void handler(Context context) {
        context.setState(new ConcreteStateA());
    }
}

public class StateExampleClass {

    public static void main(String[] args) {
        Context c = new Context(new ConcreteStateA());

        c.request();
        c.request();
        c.request();
        c.request();
    }
}

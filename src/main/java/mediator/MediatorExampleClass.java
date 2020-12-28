package mediator;

/**
 * 中介者模式
 *
 * @author jeymingwu
 * @date 2020/12/28 19:44
 */

abstract class Person {

    protected Mediator mediator;

    public Person(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void send(String message);

    public abstract void notify(String message);
}

// 中介者
abstract class Mediator {

    public abstract void send(String message, Person person);
}

class ConcreteMediator extends Mediator {

    private Person personA;
    private Person personB;

    public void setPersonA(Person personA) {
        this.personA = personA;
    }

    public void setPersonB(Person personB) {
        this.personB = personB;
    }

    @Override
    public void send(String message, Person person) {
        if (person == this.personA) {
            this.personB.notify(message);
        } else {
            this.personA.notify(message);
        }
    }
}

class ConcretePersonA extends Person {

    public ConcretePersonA(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        this.mediator.send(message, this);
    }

    @Override
    public void notify(String message) {
        System.out.println(this.getClass().getName() + " 接收到信息：" + message);
    }
}

class ConcretePersonB extends Person {

    public ConcretePersonB(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        this.mediator.send(message, this);
    }

    @Override
    public void notify(String message) {
        System.out.println(this.getClass().getName() + " 接收到信息：" + message);
    }
}

public class MediatorExampleClass {

    public static void main(String[] args) {

        ConcreteMediator mediator = new ConcreteMediator();

        Person personA = new ConcretePersonA(mediator);
        Person personB = new ConcretePersonB(mediator);

        mediator.setPersonA(personA);
        mediator.setPersonB(personB);
        personA.send("Hello, world!");
        personB.send("Hello!");
    }

}

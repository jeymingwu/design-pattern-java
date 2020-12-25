package memento;

/**
 * 备忘录模式
 *
 * 2020.12.19
 */

// 发起人
class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(this.state);
    }

    public void setMemento(Memento memento) {
        this.state = memento.getState();
    }

    public void show() {
        System.out.println("State:" + this.state);
    }
}

// 备忘录
class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// 管理者
class Caretaker {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}


public class MementoExampleClass {

    public static void main(String[] args) {

        Originator originator= new Originator();
        originator.setState("On");
        originator.show();

        Caretaker c = new Caretaker();
        c.setMemento(originator.createMemento());

        originator.setState("Off");
        originator.show();

        originator.setMemento(c.getMemento());
        originator.show();
    }
}

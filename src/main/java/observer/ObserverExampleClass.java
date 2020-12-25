package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式（发布-订阅模式）
 *
 * 2020.12.16
 */

// 主题或抽象通知者 （通知主体）
abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

class ConcreteSubject extends Subject{

    private String subjectState;

    public ConcreteSubject() {
    }

    public ConcreteSubject(String subjectState) {
        this.subjectState = subjectState;
    }

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}

// 抽象观察者（通知对象）
abstract class Observer {
    public abstract void update();
}

class ConcreteObserver extends Observer {

    private String name;
    private String observerState;
    private ConcreteSubject subject;

    public ConcreteObserver(String name, ConcreteSubject subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update() {
        observerState = subject.getSubjectState();
        System.out.println("观察者：" + this.name + " 的新状态：" + this.observerState);
    }

    public ConcreteSubject getSubject() {
        return subject;
    }

    public void setSubject(ConcreteSubject subject) {
        this.subject = subject;
    }
}

public class ObserverExampleClass {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        subject.attach(new ConcreteObserver("A", subject));
        subject.attach(new ConcreteObserver("B", subject));
        subject.attach(new ConcreteObserver("C", subject));

        subject.setSubjectState("ABC");
        subject.notifyObserver();
    }
}

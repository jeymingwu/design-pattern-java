package visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式
 *
 * @author jeymingwu
 * @date 2021/1/3 23:06
 */
// 抽象访问者
abstract class Visitor {

    public abstract void visitConcreteElementA(ConcreteElementA concreteElementA);

    public abstract void visitConcreteElementB(ConcreteElementB concreteElementB);
}

class ConcreteVisitorA extends Visitor {

    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println(concreteElementA.getClass().getName() + " 访问 " + this.getClass().getName());
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.println(concreteElementB.getClass().getName() + " 访问 " + this.getClass().getName());
    }
}

class ConcreteVisitorB extends Visitor {

    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println(concreteElementA.getClass().getName() + " 访问 " + this.getClass().getName());
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.println(concreteElementB.getClass().getName() + " 访问 " + this.getClass().getName());
    }
}

// 抽象元素
abstract class Element {

    public abstract void accept(Visitor visitor);
}

// 具体元素（数据结构）
class ConcreteElementA extends Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);
    }
}

// 具体元素（数据结构）
class ConcreteElementB extends Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementB(this);
    }
}

class ObjectStructure {

    private List<Element> elements = new ArrayList<>();

    public void attach(Element element) {
        elements.add(element);
    }

    public void detach(Element element) {
        elements.remove(element);
    }

    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}

public class VisitorExampleClass {

    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new ConcreteElementA());
        objectStructure.attach(new ConcreteElementB());

        ConcreteVisitorA concreteVisitorA = new ConcreteVisitorA();
        objectStructure.accept(concreteVisitorA);

        ConcreteVisitorB concreteVisitorB = new ConcreteVisitorB();
        objectStructure.accept(concreteVisitorB);
    }
}

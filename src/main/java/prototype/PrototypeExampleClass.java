package prototype;

/**
 * 原型模式
 *
 * 2020.12.14
 */
abstract class Prototype {

    private String id;

    public Prototype(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

class ConcretePrototype extends Prototype implements Cloneable{

    public ConcretePrototype(String id) {
        super(id);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // 浅拷贝
    }
}

public class PrototypeExampleClass {

    public static void main(String[] args) {
        ConcretePrototype c1 = new ConcretePrototype("A");
        System.out.println(c1.getId().hashCode());
        try {
            ConcretePrototype c2 = (ConcretePrototype) c1.clone();
            System.out.println("clone : " + c2.getId());
            System.out.println(c2.getId().hashCode());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

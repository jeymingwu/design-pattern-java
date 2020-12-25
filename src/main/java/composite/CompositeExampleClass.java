package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 *
 * 2020.12.19
 */

// 组合中对象声明的接口/抽象类
abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract void display(int depth);

}

// 叶节点
class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        System.out.println("cannot add to a leaf");
    }

    @Override
    public void remove(Component component) {
        System.out.println("cannot remove from a leaf");
    }

    @Override
    public void display(int depth) {
        for (int i = 0; i < depth; ++i) {
            System.out.print("-");
        }
        System.out.println(this.name);
    }
}

class Composite extends Component {

    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        this.children.add(component);
    }

    @Override
    public void remove(Component component) {
        this.children.remove(component);
    }

    @Override
    public void display(int depth) {
        for (int i = 0; i < depth; ++i) {
            System.out.print("-");
        }
        System.out.println(this.name);

        for (Component component : children) {
            component.display(depth + 2);
        }
    }
}

public class CompositeExampleClass {

    public static void main(String[] args) {
        Composite root = new Composite("root");
        root.add(new Leaf("Leaf A"));
        root.add(new Leaf("Leaf B"));

        Composite composite = new Composite("Composite X");
        composite.add(new Leaf("Leaf XA"));
        composite.add(new Leaf("Leaf XB"));
        root.add(composite);

        Composite composite2 = new Composite("Composite XY");
        composite2.add(new Leaf("Leaf XYA"));
        composite2.add(new Leaf("Leaf XYB"));
        root.add(composite2);

        root.add(new Leaf("Leaf C"));

        Leaf leaf = new Leaf("Leaf D");
        root.add(leaf);
        root.remove(leaf);

        root.display(1);
    }
}

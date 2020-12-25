package iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式
 *
 * 2020.12.19
 */
// 迭代器抽象类
abstract class Iterator {

    public abstract Object first();

    public abstract Object next();

    public abstract boolean isDone(); // 是否到结尾

    public abstract Object currentItem();
}

// 聚集抽象类
abstract class Aggregate {

    public abstract Iterator createIterator();

    public abstract void add(Object object);

    public abstract void remove(Object object);

    public abstract int count();

    public abstract Object get(int index);
}

// 正向遍历
class ConcreteIterator extends Iterator {

    private Aggregate concreteAggregate;
    private int current = 0;

    public ConcreteIterator(Aggregate concreteAggregate) {
        this.concreteAggregate = concreteAggregate;
    }

    @Override
    public Object first() {
        return this.concreteAggregate.get(0);
    }

    @Override
    public Object next() {
        Object object = null;
        this.current++;
        if (this.current < concreteAggregate.count()) {
            object = this.concreteAggregate.get(current);
        }
        return object;
    }

    @Override
    public boolean isDone() {
        return this.current >= this.concreteAggregate.count();
    }

    @Override
    public Object currentItem() {
        return this.concreteAggregate.get(current);
    }
}

class ConcreteIteratorDesc extends Iterator {

    private Aggregate concreteAggregate;
    private int current = 0;

    public ConcreteIteratorDesc(Aggregate concreteAggregate) {
        this.concreteAggregate = concreteAggregate;
        this.current = concreteAggregate.count() - 1;
    }

    @Override
    public Object first() {
        return this.concreteAggregate.get(this.concreteAggregate.count() - 1);
    }

    @Override
    public Object next() {
        Object object = null;
        this.current--;
        if (this.current >= 0) {
            object = this.concreteAggregate.get(current);
        }
        return object;
    }

    @Override
    public boolean isDone() {
        return this.current < 0;
    }

    @Override
    public Object currentItem() {
        return this.concreteAggregate.get(this.current);
    }
}

class ConcreteAggregate extends Aggregate {

    private List<Object> items = new ArrayList<>();

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    public void add(Object object) {
        this.items.add(object);
    }

    public void remove(Object object) {
        this.items.remove(object);
    }

    public int count() {
        return this.items.size();
    }

    public Object get(int index) {
        return this.items.get(index);
    }
}

public class IteratorExampleClass {

    public static void main(String[] args) {

        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("Tony");
        aggregate.add("Jenny");
        aggregate.add("Lisa");
        aggregate.add("Jane");
        aggregate.add("Tom");

        System.out.println("正向遍历");
        Iterator iterator = aggregate.createIterator();
        Object object = iterator.first();
        while  (!iterator.isDone()) {
            System.out.println(object);
            object = iterator.next();
        }

        System.out.println("反向遍历");
        Iterator iteratorDesc = new ConcreteIteratorDesc(aggregate);
        object = iteratorDesc.first();
        while  (!iteratorDesc.isDone()) {
            System.out.println(object);
            object = iteratorDesc.next();
        }

    }
}

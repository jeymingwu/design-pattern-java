package visitor.person;

/**
 * @author jeymingwu
 * @date 2021/1/3 23:08
 */
public abstract class Person {

    public abstract void accept(Action action);
}

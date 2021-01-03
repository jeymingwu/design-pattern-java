package visitor.person;

/**
 * @author jeymingwu
 * @date 2021/1/3 23:11
 */
public class Man extends Person{

    @Override
    public void accept(Action action) {
        action.getManConclusion(this);
    }
}

package visitor.person;

/**
 * @author jeymingwu
 * @date 2021/1/3 23:12
 */
public class Woman extends Person {

    @Override
    public void accept(Action action) {
        action.getWomanConclusion(this);
    }
}

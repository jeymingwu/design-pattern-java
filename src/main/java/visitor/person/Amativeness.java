package visitor.person;

/**
 * @author jeymingwu
 * @date 2021/1/3 23:21
 */
public class Amativeness extends Action {
    @Override
    public void getManConclusion(Man man) {
        System.out.println("男人恋爱时，凡事不懂也要装懂。");
    }

    @Override
    public void getWomanConclusion(Woman woman) {
        System.out.println("女人恋爱时，凡是懂也装作不懂。");
    }
}

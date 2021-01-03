package visitor.person;

/**
 * @author jeymingwu
 * @date 2021/1/3 23:14
 */
public class Success extends Action {
    @Override
    public void getManConclusion(Man man) {
        System.out.println("男人成功时，背后多半有一个伟大的女人。");
    }

    @Override
    public void getWomanConclusion(Woman woman) {
        System.out.println("女人成功时，背后大多有一个不成功的男人。");
    }
}

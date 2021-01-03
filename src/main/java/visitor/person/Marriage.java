package visitor.person;

/**
 * @author jeymingwu
 * @date 2021/1/3 23:28
 */
public class Marriage extends Action {
    @Override
    public void getManConclusion(Man man) {
        System.out.println("男人结婚时，感慨道：恋爱游戏终结时，‘有妻徒刑’遥无期。");
    }

    @Override
    public void getWomanConclusion(Woman woman) {
        System.out.println("女人结婚时，欣慰曰：爱情长跑路漫漫，婚姻保险保平安。");
    }
}

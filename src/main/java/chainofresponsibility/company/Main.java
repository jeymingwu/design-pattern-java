package chainofresponsibility.company;

/**
 * @author jeymingwu
 * @date 2020/12/28 17:35
 */
public class Main {

    private static final String LEAVE = "请假";
    private static final String RAISE = "加薪";


    public static void main(String[] args) {
        Manager manager = new CommonManager("部门经理");
        Manager majorManager = new MajorManager("总监");
        Manager generalManager = new GeneralManager("总经理");

        manager.setSuperior(majorManager);
        majorManager.setSuperior(generalManager);

        Request leave2 = new Request(LEAVE, "xxx原因需请假2天", 2);
        Request leave5 = new Request(LEAVE, "xxx原因需请假5天", 5);
        Request leave10 = new Request(LEAVE, "xxx原因需请假10天", 10);
        Request raise500 = new Request(RAISE, "xxx申请加薪500", 500);
        Request raise1000 = new Request(RAISE, "xxx申请加薪1000", 1000);

        manager.requestApplication(leave2);
        manager.requestApplication(leave5);
        manager.requestApplication(leave10);
        manager.requestApplication(raise500);
        manager.requestApplication(raise1000);
    }
}

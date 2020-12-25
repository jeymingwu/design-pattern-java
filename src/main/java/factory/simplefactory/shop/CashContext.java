package factory.simplefactory.shop;

/**
 * 策略模式与简单工厂模式结合
 *
 * 2020.12.13
 */
public class CashContext {

    CashSuper cs = null;

    public CashContext(String type) {
        cs = CashFactory.createCashAccept(type);

//        // 策略模式本质：根据不同的策略生成不同的对象
//        switch (type) {
//            case "正常收费":
//                cs = CashFactory.createCashAccept(type);
//                break;
//            case "满 300 减 100":
//                cs = CashFactory.createCashAccept(type);
//                break;
//            case "打 8 折":
//                cs = CashFactory.createCashAccept(type);
//                break;
//        }
    }

    public double getResult(double money) {
        return cs.acceptCash(money);
    }
}

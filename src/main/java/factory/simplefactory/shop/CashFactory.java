package factory.simplefactory.shop;

/**
 * 简单工厂模式
 *
 * 2020.12.10
 */
public class CashFactory {

    public static CashSuper createCashAccept(String type) {
        switch (type) {
            case "正常收费":
                return new CashNormal();
            case "满 300 返 100":
                return new CashReturn(300d, 100d);
            case "打 8 折":
                return new CashRebate(0.8d);
            default:
                return null;
        }
    }
}

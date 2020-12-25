package factory.simplefactory.shop;

public class CashRebate extends CashSuper{

    // 打折利率
    private double moneyRate;

    public CashRebate() {
        this.moneyRate = 1d;
    }

    public CashRebate(double moneyRate) {
        this.moneyRate = moneyRate;
    }

    @Override
    public double acceptCash(double money) {
        return money * this.moneyRate;
    }
}

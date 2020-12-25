package factory.simplefactory.shop;

public class CashReturn extends CashSuper{

    // 返利条件
    private double moneyCondition;
    // 返利金额
    private double moneyReturn;

    public CashReturn() {
        this.moneyCondition = 0d;
        this.moneyReturn = 0d;
    }

    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        if (money > this.moneyCondition) {
            return (money - Math.floor(money / this.moneyCondition) * this.moneyReturn);
        }
        return money;
    }
}

package strategy;

/**
 * 策略模式
 *
 * 2020.12.11
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    // 上下文接口
    public void contextInterface() {
        strategy.algorithmInterface();
    }
}

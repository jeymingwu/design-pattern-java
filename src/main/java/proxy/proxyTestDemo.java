package proxy;

/**
 * 代理模式
 *
 * 2020.12.14
 */
public class proxyTestDemo {

    public static void main(String[] args) {
        Girl lisa = new Girl("lisa");

        Proxy proxy = new Proxy(lisa);
        proxy.giveDolls();
        proxy.giveFlowers();
        proxy.giveChocolate();
    }
}

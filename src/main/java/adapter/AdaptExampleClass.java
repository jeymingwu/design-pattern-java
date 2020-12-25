package adapter;

/**
 * 适配器模式
 *
 * 2020.12.17
 */

// 目标：可是具体的类，也可抽象的类或接口
class Target {

    public void request() {
        System.out.println("普通请求！");
    }
}

class Adaptee {

    public void specificRequest() {
        System.out.println("特殊请求！");
    }
}

class Adapter extends Target {

    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

public class AdaptExampleClass {

    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}

package flyweight;

import java.util.HashMap;

/**
 * 享元模式
 *
 * @author jeymingwu
 * @date 2020/12/28 20:25
 */
abstract class Flyweight {

    public abstract void operation(int extrinsicState);
}

class ConcreteFlyweight extends Flyweight {

    @Override
    public void operation(int extrinsicState) {
        System.out.println("具体 Flyweight：" + extrinsicState);
    }
}

class UnsharedConcreteFlyweight extends Flyweight {

    @Override
    public void operation(int extrinsicState) {
        System.out.println("不共享的具体 Flyweight:" + extrinsicState);
    }
}

// 享元工厂，主要创建和管理 Flyweight 对象，确保合理地共享 Flyweight；
class FlyweightFactory {

    private HashMap<String, Flyweight> flyweightHashMap = new HashMap<>();

    public FlyweightFactory() {
        flyweightHashMap.put("X", new ConcreteFlyweight());
        flyweightHashMap.put("Y", new ConcreteFlyweight());
        flyweightHashMap.put("Z", new ConcreteFlyweight());
    }

    public Flyweight getFlyweight(String key) {
        return flyweightHashMap.get(key);
    }
}

public class FlyweightExampleClass {

    public static void main(String[] args) {

        int extrinsicState = 22;

        FlyweightFactory flyweightFactory = new FlyweightFactory();

        Flyweight x = flyweightFactory.getFlyweight("X");
        x.operation(--extrinsicState);

        Flyweight y = flyweightFactory.getFlyweight("Y");
        y.operation(--extrinsicState);

        Flyweight z = flyweightFactory.getFlyweight("Z");
        z.operation(--extrinsicState);

        UnsharedConcreteFlyweight unsharedConcreteFlyweight = new UnsharedConcreteFlyweight();
        unsharedConcreteFlyweight.operation(--extrinsicState);
    }
}

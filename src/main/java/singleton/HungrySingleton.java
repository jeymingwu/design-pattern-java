package singleton;

/**
 * 单例模式-懒汉式
 * 优点：延迟加载；
 * 缺点：只能在单线程程序下使用；在多线程下使用出现线程安全问题；
 *
 * 2020.12.20
 */
public class HungrySingleton {

    private static HungrySingleton instance;

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        if (instance == null) {
            instance = new HungrySingleton();
        }
        return instance;
    }
}

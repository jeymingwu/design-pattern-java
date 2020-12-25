package singleton;

/**
 * 单例模式-饿汉式（静态代码块）
 * 优点：写法简单，在类加载时完成实例化，避免了线程同步问题；
 * 缺点：在类加载时完成实例，若无需使用，则造成内存浪费；
 *
 * 2020.12.20
 */
public class StaticBlockSingleton{

    private final static StaticBlockSingleton INSTANCE;

    static {
        INSTANCE = new StaticBlockSingleton();
    }

    private StaticBlockSingleton() {

    }

    public static StaticBlockSingleton getInstance() {
        return INSTANCE;
    }
}

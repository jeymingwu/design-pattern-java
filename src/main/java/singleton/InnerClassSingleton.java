package singleton;

/**
 * 单例模式-懒汉式（静态内部类）
 * 与懒汉式方式差不多，均采用类装载机制保证初始化实例只有一个线程；
 * 静态内部类在 Singleton 类加载时并不会立即实例化，而是在调用时才装载；
 * 优点：线程安全，延时加载，效率高；
 *
 * 2020.12.20
 */
public class InnerClassSingleton {

    private InnerClassSingleton() {

    }

    private static class SingletonInstance {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}

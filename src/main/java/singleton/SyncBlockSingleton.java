package singleton;

/**
 * 单例模式-懒汉式（同步代码块）
 * 优点：延迟加载；
 * 缺点：线程不安全，多线程中不可用；
 *
 * 2020.12.20
 */
public class SyncBlockSingleton {

    private static SyncBlockSingleton instance;

    private SyncBlockSingleton() {

    }

    public static SyncBlockSingleton getInstance() {
        if (instance == null) {
            synchronized (SyncBlockSingleton.class) {
                instance = new SyncBlockSingleton();
            }
        }
        return instance;
    }
}

package singleton;

/**
 * 单例模式-懒汉式（同步方法）
 * 优点：延迟加载；在多线程中可用；
 * 缺点：效率低，每个线程获取类的时候都需要同步；
 *
 * 2020.12.20
 */
public class SyncSingleton {

    private static SyncSingleton instance;

    private SyncSingleton() {
    }

    public synchronized static SyncSingleton getInstance() {
        if (instance == null) {
            instance = new SyncSingleton();
        }
        return instance;
    }
}

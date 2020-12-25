package singleton;

/**
 * 单例模式最佳实现-枚举
 * 优点：避免多线程同步问题、延时加载、还可以防止反序列化对单例模式的破坏；
 *
 * 2020.12.20
 */

public class EnumSingleton {

    private EnumSingleton() {

    }

    enum Singleton{
        INSTANCE;

        private final EnumSingleton instance;

        Singleton() {
            instance = new EnumSingleton();
        }

        public EnumSingleton getInstance() {
            return instance;
        }
    }

    public static EnumSingleton getInstance() {
        return Singleton.INSTANCE.getInstance();
    }


}

package singleton;

/**
 * 单例模式-饿汉式（静态变量）
 * 优点：写法简单，在类加载时完成实例化，避免了线程同步问题；
 * 缺点：在类加载时完成实例，若无需使用，则造成内存浪费；
 *
 * 2020.12.20
 */

class StaticSingleton {

    private final static StaticSingleton INSTANCE = new StaticSingleton();

    private StaticSingleton() {

    }

    public static StaticSingleton getInstance() {
        return INSTANCE;
    }
}

public class SingletonExampleClass {

    public static void main(String[] args) {
        StaticSingleton s1 = StaticSingleton.getInstance();
        StaticSingleton s2 = StaticSingleton.getInstance();

        System.out.println(s1 == s2);
    }
}

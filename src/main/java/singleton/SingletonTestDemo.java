package singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;

class Singleton implements Serializable {

    private static Singleton instance = new Singleton();

    // 通过反射方式
    // 反射是通过调用构造方法生成新对象；只需在构造方法中进行对对象的判断即可；
    private Singleton() {
        if (instance != null) {
            throw new RuntimeException("实例已存在");
        }
    }

    // 反序列化破坏单例
    // 解决一：不实现序列化接口 Serializable；
    // 解决二：实现序列化接口，重写反序列化方法 readResolve()；
    public Object readResolve() throws ObjectStreamException {
        return instance;
    }



    public static Singleton getInstance() {
        return instance;
    }
}
public class SingletonTestDemo {

    public static void main(String[] args) throws Exception {
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton1);

        Class clazz = Class.forName(Singleton.class.getName());
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton singleton2 = (Singleton) constructor.newInstance();
        System.out.println(singleton2);
    }
}

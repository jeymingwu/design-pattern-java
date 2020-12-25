package proxy;

/**
 * 代理模式-示例
 *
 * 2020.12.14
 */

abstract class Subject {
    public abstract void request();
}

class RealSubject extends Subject {

    @Override
    public void request() {
        System.out.println("true request");
    }
}

class ProxySubject extends Subject {

    private Subject subject;

    public ProxySubject() {
    }

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        if (subject == null) {
            subject = new RealSubject();
        }
        subject.request();
    }
}

public class ProxyExampleClass {

    public static void main(String[] args) {
        ProxySubject proxySubject = new ProxySubject();
        proxySubject.request();
    }
}

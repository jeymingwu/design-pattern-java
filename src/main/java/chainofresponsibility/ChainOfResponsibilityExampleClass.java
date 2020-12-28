package chainofresponsibility;

/**
 * 责任链模式
 *
 * @author jeymingwu
 * @date 2020/12/28 16:56
 */

// 抽象请求
abstract class Handler {

    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handlerRequest(int request);
}

// 具体处理者A：处理它所负责的请求，可访问它的后继者；若请求可处理则处理，否则将请求转发它的后继者；
class ConcreteHandlerA extends Handler {

    @Override
    public void handlerRequest(int request) {
        if (request >= 0 && request < 10) {
            System.out.println(this.getClass().getName() + " 处理请求！request：" + request);
        } else if (this.successor != null) {
            this.successor.handlerRequest(request);
        }
    }
}

// 具体处理者B
class ConcreteHandlerB extends Handler {

    @Override
    public void handlerRequest(int request) {
        if (request >= 10 && request < 20) {
            System.out.println(this.getClass().getName() + " 处理请求！request：" + request);
        } else if (this.successor != null) {
            this.successor.handlerRequest(request);
        }
    }
}

// 具体处理者C
class ConcreteHandlerC extends Handler {

    @Override
    public void handlerRequest(int request) {
        if (request >= 20 && request < 30) {
            System.out.println(this.getClass().getName() + " 处理请求！request：" + request);
        } else if (this.successor != null) {
            this.successor.handlerRequest(request);
        }
    }
}

public class ChainOfResponsibilityExampleClass {

    public static void main(String[] args) {

        Handler h1 = new ConcreteHandlerA();
        Handler h2 = new ConcreteHandlerB();
        Handler h3 = new ConcreteHandlerC();
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

        for (int i = 0; i < 10; ++i) {
            h1.handlerRequest((int) (Math.random() * 30));
        }
    }
}

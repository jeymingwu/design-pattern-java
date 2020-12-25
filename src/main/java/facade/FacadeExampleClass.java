package facade;

/**
 * 外观模式
 *
 * 2020.12.15
 */
class SubSystemA {

    public void method() {
        System.out.println("子系统方法一");
    }
}

class SubSystemB {

    public void method() {
        System.out.println("子系统方法二");
    }
}

class SubSystemC {

    public void method() {
        System.out.println("子系统方法三");
    }
}

class SubSystemD {

    public void method() {
        System.out.println("子系统方法四");
    }
}

class Facade {

    private SubSystemA subSystemA;
    private SubSystemB subSystemB;
    private SubSystemC subSystemC;
    private SubSystemD subSystemD;

    public Facade() {
        this.subSystemA = new SubSystemA();
        this.subSystemB = new SubSystemB();
        this.subSystemC = new SubSystemC();
        this.subSystemD = new SubSystemD();
    }

    public void methodA() {
        System.out.println("方法组A ---");
        this.subSystemA.method();
        this.subSystemB.method();
        this.subSystemD.method();
    }

    public void methodB() {
        System.out.println("方法组B ---");
        this.subSystemB.method();
        this.subSystemC.method();
    }
}

public class FacadeExampleClass {

    public static void main(String[] args) {

        Facade facade = new Facade();

        facade.methodA();
        facade.methodB();
    }
}

package decorator.person;

public class DecoratorPersonTestDemo {

    public static void main(String[] args) {
        Person xiaoMing = new Person("小明");

        TShirts tShirts = new TShirts();
        BigTrouser bigTrouser = new BigTrouser();
        Underwave underwave = new Underwave();

        // 装饰过程
        tShirts.decorate(xiaoMing);
        bigTrouser.decorate(tShirts);
        underwave.decorate(bigTrouser);

        underwave.show();

    }
}

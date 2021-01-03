package visitor.person;

/**
 * @author jeymingwu
 * @date 2021/1/3 23:27
 */
public class Main {

    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());

        Success success = new Success();
        objectStructure.display(success);

        Failing failing = new Failing();
        objectStructure.display(failing);

        Amativeness amativeness = new Amativeness();
        objectStructure.display(amativeness);

        Marriage marriage = new Marriage();
        objectStructure.display(marriage);
    }
}

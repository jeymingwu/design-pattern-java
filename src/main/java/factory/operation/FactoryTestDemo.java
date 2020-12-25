package factory.operation;

public class FactoryTestDemo {

    public static void main(String[] args) throws Exception {
        IFactory operationFactory = new FactoryAdd();
        Operation operation = operationFactory.createOperation();
        operation.setNumberA(1);
        operation.setNumberB(2);
        double result = operation.getResult();
        System.out.println("result:" + result);
    }
}

package factory.simplefactory.operation;

import factory.operation.Operation;

public class SimpleFactoryTestDemo {

    public static void main(String[] args) {
        Operation operation = null;
        operation = OperationFactory.createOption("+");
        operation.setNumberA(10);
        operation.setNumberB(20);
        try {
            System.out.println("result: " + operation.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

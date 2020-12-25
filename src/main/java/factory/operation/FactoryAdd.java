package factory.operation;

public class FactoryAdd implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}

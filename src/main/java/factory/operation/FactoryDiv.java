package factory.operation;

public class FactoryDiv implements IFactory{
    @Override
    public Operation createOperation() {
        return new OperationDiv();
    }
}

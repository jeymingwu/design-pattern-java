package factory.operation;

public class FactoryMul implements IFactory{
    @Override
    public Operation createOperation() {
        return new OperationMul();
    }
}

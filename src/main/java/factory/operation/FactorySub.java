package factory.operation;

public class FactorySub implements IFactory{
    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}

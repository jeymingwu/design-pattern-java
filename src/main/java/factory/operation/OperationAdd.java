package factory.operation;

public class OperationAdd extends Operation{

    @Override
    public double getResult() {
        double result = 0;
        result = super.getNumberA() + super.getNumberB();
        return result;
    }
}

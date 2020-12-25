package factory.operation;

public abstract class Operation {

    private double numberA;
    private double numberB;

    public Operation() {
        numberA = 0;
        numberB = 0;
    }

    public Operation(double numberA, double numberB) {
        this.numberA = numberA;
        this.numberB = numberB;
    }

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    public abstract double getResult() throws Exception;
}

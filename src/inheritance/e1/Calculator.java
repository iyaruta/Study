package inheritance.e1;

/**
 * User: Alexandr
 * Date: 19.11.2014
 */
public class Calculator {

    private Operation operation;

    public Calculator(Operation operation) {
        this.operation = operation;
    }

    public float calculate(float a, float b){
        return operation.calc(a, b);
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}

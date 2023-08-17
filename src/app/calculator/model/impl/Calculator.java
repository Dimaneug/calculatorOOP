package app.calculator.model;

public class Calculator implements Calculable {
    private double previousResult;

    public double getPreviousResult() {
        return previousResult;
    }

    public double performOperation(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                previousResult = num1 + num2;
                break;
            case "-":
                previousResult = num1 - num2;
                break;
            case "*":
                previousResult = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    previousResult = num1 / num2;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        return previousResult;
    }
}

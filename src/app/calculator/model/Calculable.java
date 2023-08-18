package app.calculator.model;

public interface Calculable {
    double performOperation(double num1, double num2, String operator);

    double getPreviousResult();
}

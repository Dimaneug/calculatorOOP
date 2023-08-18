package app.calculator.controller;

import app.calculator.model.Calculable;
import app.calculator.model.impl.Calculator;
import app.calculator.view.CalculatorView;
import app.logger.Loggable;
import app.logger.impl.FileLogger;

import java.io.IOException;

public class CalculatorController {
    private CalculatorView view;
    private Calculable model;
    private Loggable logger;

    public CalculatorController(CalculatorView view) {
        this.view = view;
        this.model = new Calculator();
        this.logger = new FileLogger();
    }

    public CalculatorController(CalculatorView view, Loggable logger) {
        this.view = view;
        this.model = new Calculator();
        this.logger = logger;
    }

    public CalculatorController(CalculatorView view, Calculable model, Loggable logger) {
        this.view = view;
        this.model = model;
        this.logger = logger;
    }

    public void calculate(String line1, String line2, String operator) {
        try {
            double num1;
            if (line1.isEmpty()) {
                num1 = model.getPreviousResult();
            } else {
                num1 = Double.parseDouble(line1);
            }
            double num2 = Double.parseDouble(line2);
            logger.log(String.format("%s %s %s%n", num1, operator, num2));
            double result = model.performOperation(num1, num2, operator);
            logger.log(String.format("result is %s%n", result));
            view.showResult(result);
        } catch (Exception e) {
            try {
                logger.log(String.format("Error: %s%n", e.getMessage()));
            } catch (IOException ex) {
                throw new RuntimeException("Не удалось записать ошибку в logger");
            }
            System.out.println("Error: " + e.getMessage());
        }
    }
}

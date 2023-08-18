package app.calculator.view;

import app.calculator.controller.CalculatorController;

import java.util.Scanner;

public class CalculatorView {
    private CalculatorController controller;
    private Scanner scanner;

    public CalculatorView() {
        controller = new CalculatorController(this);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            String num1 = prompt("Введите первое число: ");

            String operator = prompt("Введите операцию (+, -, *, /): ");

            String num2 = prompt("Введите второе число: ");

            controller.calculate(num1, num2, operator);

            String choice = prompt("Хотите продолжить вычисления? (y/n): ");
            if (!choice.equalsIgnoreCase("y")) {
                break;
            }
        }
        System.out.println("Калькулятор закрыт.");
    }

    public void showResult(double result) {
        System.out.println("Результат: " + result);
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}

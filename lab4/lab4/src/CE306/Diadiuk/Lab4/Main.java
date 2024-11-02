package CE306.Diadiuk.Lab4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Програма-драйвер для обчислення виразу та запису результату у файл.
 */
public class Main {
    public static void main(String[] args) {
        ExpressionCalculator calculator = new ExpressionCalculator();
        try (Scanner scanner = new Scanner(System.in)) {
            double x = 0;
            boolean validInput = false; // Для відстеження правильності вводу

            // Цикл для повторного запиту вводу, поки не буде введено правильне значення
            while (!validInput) {
                System.out.print("Введiть значення x: ");
                try {
                    x = scanner.nextDouble();
                    validInput = true; // Введення правильне, вихід з циклу
                } catch (InputMismatchException e) {
                    System.out.println("Помилка: введено нечислове значення. Будь ласка, введіть число.");
                    scanner.next(); // Очищення невірного вводу
                }
            }

            try {
                double result = calculator.calculate(x);
                calculator.writeResultToFile(result, "result.txt");
                System.out.println("Результат: " + result + " записано у файл result.txt.");
            } catch (ArithmeticException e) {
                System.out.println("Помилка обчислення: " + e.getMessage());
            }
        }
    }
}

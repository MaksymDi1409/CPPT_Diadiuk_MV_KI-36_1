package CE306.Diadiuk.Lab5;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Програма-драйвер для тестування класу FileHandler.
 */
public class FileHandlerTest {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        ExpressionCalculator calculator = new ExpressionCalculator();

        try (Scanner scanner = new Scanner(System.in)) {
            double x = 0;
            boolean validInput = false;

            // Цикл для повторного запиту вводу, поки не буде введено правильне значення
            while (!validInput) {
                System.out.print("Введiть значення x: ");
                try {
                    x = scanner.nextDouble();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Помилка: введено нечислове значення. Будь ласка, введіть число.");
                    scanner.next(); // Очищення невірного вводу
                }
            }

            // Обчислення
            try {
                double result = calculator.calculate(x);
                
                // Запис результату у текстовий файл
                fileHandler.writeToTextFile(result, "result.txt");
                
                // Запис результату у двійковий файл
                fileHandler.writeToBinaryFile(result, "result.bin");
                
                System.out.println("Результат: " + result + " записано у файл result.txt та result.bin.");
                
            } catch (ArithmeticException e) {
                System.out.println("Помилка обчислення: " + e.getMessage());
            }
        }

        // Читання результатів з текстового файлу
        System.out.println("\nРезультати з текстового файлу:");
        fileHandler.readFromTextFile("result.txt");
        
        // Читання результатів з двійкового файлу
        System.out.println("\nРезультати з двiйкового файлу:");
        fileHandler.readFromBinaryFile("result.bin");
    }
}

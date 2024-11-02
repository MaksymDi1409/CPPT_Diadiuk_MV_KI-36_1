package CE306.Diadiuk.Lab5;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас для обчислення виразу y = tg(x) / sin(2x).
 */
public class ExpressionCalculator {

    /**
     * Обчислює значення y = tg(x) / sin(2x).
     * @param x значення для обчислення.
     * @return результат обчислення.
     * @throws ArithmeticException якщо sin(2x) = 0.
     */
    public double calculate(double x) throws ArithmeticException {
        double denominator = Math.sin(2 * x);
        if (denominator == 0) {
            throw new ArithmeticException("Поділ на нуль: sin(2x) дорівнює 0.");
        }
        return Math.tan(x) / denominator;
    }

    /**
     * Записує результат у файл.
     * @param result значення, що потрібно записати.
     * @param filename ім'я файлу для запису.
     */
    public void writeResultToFile(double result, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("Результат: " + result + "\n");
        } catch (IOException e) {
            System.out.println("Помилка запису у файл: " + e.getMessage());
        }
    }
}

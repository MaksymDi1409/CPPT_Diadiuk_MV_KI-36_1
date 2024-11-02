package CE306.Diadiuk.Lab5;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Клас для читання/запису у текстовому і двійковому форматах.
 */
public class FileHandler {

    /**
     * Записує результат у текстовий файл.
     * @param result значення, що потрібно записати.
     * @param filename ім'я файлу для запису.
     */
    public void writeToTextFile(double result, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("Результат: " + result + "\n");
        } catch (IOException e) {
            System.out.println("Помилка запису у текстовий файл: " + e.getMessage());
        }
    }

    /**
     * Записує результат у двійковий файл.
     * @param result значення, що потрібно записати.
     * @param filename ім'я файлу для запису.
     */
    public void writeToBinaryFile(double result, String filename) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename, true))) {
            dos.writeDouble(result);
        } catch (IOException e) {
            System.out.println("Помилка запису у двійковий файл: " + e.getMessage());
        }
    }

    /**
     * Читає результати з текстового файлу.
     * @param filename ім'я файлу для читання.
     */
    public void readFromTextFile(String filename) {
        try {
            Files.lines(Paths.get(filename), Charset.forName("Windows-1251")).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Помилка читання з текстового файлу: " + e.getMessage());
        }
    }

    /**
     * Читає результати з двійкового файлу.
     * @param filename ім'я файлу для читання.
     */
    public void readFromBinaryFile(String filename) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            while (dis.available() > 0) {
                double result = dis.readDouble();
                System.out.println("Результат: " + result);
            }
        } catch (IOException e) {
            System.out.println("Помилка читання з двійкового файлу: " + e.getMessage());
        }
    }
}

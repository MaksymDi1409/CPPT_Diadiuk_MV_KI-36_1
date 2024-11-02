package CE306.Diadiuk.Lab2;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас, що представляє літак з основними складовими частинами, включаючи бак для палива.
 */
public class Airplane {
    private Engine engine;
    private Wing leftWing;
    private Wing rightWing;
    private Cockpit cockpit;
    private Tank tank; // Нове поле для бака
    private FileWriter logWriter;

    /**
     * Конструктор для створення літака з певними параметрами.
     * @param engine двигун літака
     * @param leftWing ліве крило літака
     * @param rightWing праве крило літака
     * @param cockpit кабіна літака
     * @param tank бак літака
     * @throws IOException у випадку помилки при роботі з файлом
     */
    public Airplane(Engine engine, Wing leftWing, Wing rightWing, Cockpit cockpit, Tank tank) throws IOException {
        this.engine = engine;
        this.leftWing = leftWing;
        this.rightWing = rightWing;
        this.cockpit = cockpit;
        this.tank = tank; // Ініціалізація бака
        this.logWriter = new FileWriter("airplane_log.txt", true); // Протокол активностей
        log("Лiтак створено.");
    }

    /**
     * Метод для запуску двигуна літака.
     */
    public void startEngine() throws IOException {
        engine.start();
        log("Двигун запущено.");
    }

    /**
     * Метод для зупинки двигуна літака.
     */
    public void stopEngine() throws IOException {
        engine.stop();
        log("Двигун зупинено.");
    }

    /**
     * Метод для повороту лівого крила.
     */
    public void adjustLeftWing(int angle) throws IOException {
        leftWing.adjust(angle);
        log("Лiве крило налаштовано на кут: " + angle);
    }

    /**
     * Метод для повороту правого крила.
     */
    public void adjustRightWing(int angle) throws IOException {
        rightWing.adjust(angle);
        log("Праве крило налаштовано на кут: " + angle);
    }

    /**
     * Метод для заправки бака літака.
     * @param amount кількість палива для заправки
     */
    public void refuel(int amount) throws IOException {
        tank.fillTank(amount);
        log("Заправлено бак на " + amount + " лiтрiв.");
    }

    /**
     * Метод для перевірки, чи повний бак літака.
     */
    public void checkTank() throws IOException {
        tank.isFull();
        log("Перевiрено стан бака.");
    }

    /**
     * Метод для виведення стану літака.
     */
    public void displayStatus() throws IOException {
        log("Стан лiтака:");
        System.out.println("Двигун: " + engine.getStatus());
        System.out.println("Лiве крило: " + leftWing.getStatus());
        System.out.println("Праве крило: " + rightWing.getStatus());
        System.out.println("Кабiна: " + cockpit.getStatus());
        tank.getStatus(); // Виведення стану бака
    }

    /**
     * Метод для закриття ресурсу (лог-файлу).
     */
    public void closeLog() throws IOException {
        log("Протокол завершено.");
        logWriter.close();
    }

    /**
     * Приватний метод для запису в лог-файл.
     */
    private void log(String message) throws IOException {
        logWriter.write(message + "\n");
        logWriter.flush();
    }
}

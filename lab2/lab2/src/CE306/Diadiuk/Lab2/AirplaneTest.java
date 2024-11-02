package CE306.Diadiuk.Lab2;

import java.io.IOException;

/**
 * Клас-драйвер для тестування роботи класу Airplane.
 */
public class AirplaneTest {
    public static void main(String[] args) {
        try {
            // Створюємо складові частини літака
            Engine engine = new Engine();
            Wing leftWing = new Wing();
            Wing rightWing = new Wing();
            Cockpit cockpit = new Cockpit("Petro Vasylovich");

            // Додаємо бак на 100 літрів
            Tank tank = new Tank(100);

            // Створюємо літак з доданими складовими
            Airplane airplane = new Airplane(engine, leftWing, rightWing, cockpit, tank);

            // Тестування основних функцій
            airplane.startEngine();
            airplane.adjustLeftWing(15);
            airplane.adjustRightWing(15);
            airplane.displayStatus();

            // Заправляємо літак
            airplane.refuel(50); // Заправляємо 50 літрів
            airplane.checkTank(); // Перевіряємо стан бака

            airplane.refuel(70); // Спроба заправити більше, ніж ємність бака
            airplane.checkTank(); // Повторно перевіряємо стан бака

            // Виводимо фінальний стан літака
            airplane.displayStatus();

            // Зупиняємо двигун
            airplane.stopEngine();
            airplane.displayStatus();

            // Закриваємо лог-файл
            airplane.closeLog();

        } catch (IOException e) {
            System.out.println("Виникла помилка пiд час роботи з файлом: " + e.getMessage());
        }
    }
}

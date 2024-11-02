package CE306.Diadiuk.Lab3;

import java.io.IOException;

/**
 * Клас-драйвер для тестування бомбардувальника.
 */
public class BomberTest {
    public static void main(String[] args) {
        try {
            Engine engine = new Engine();
            Wing leftWing = new Wing();
            Wing rightWing = new Wing();
            Cockpit cockpit = new Cockpit("Ivan Petrovich");
            Tank tank = new Tank(1000);
            
            Bomber bomber = new Bomber(engine, leftWing, rightWing, cockpit, tank, 5);

            bomber.startEngine();
            bomber.adjustLeftWing(15);
            bomber.adjustRightWing(15);
            bomber.refuel(500);
            bomber.displayStatus();

            // Скидаємо бомби
            bomber.dropBomb();
            bomber.dropBomb();
            System.out.println("Кiлькiсть бомб, що залишилися: " + bomber.getBombCount());

            bomber.stopEngine();
            bomber.closeLog();

        } catch (IOException e) {
            System.out.println("Помилка пiд час роботи з файлом: " + e.getMessage());
        }
    }
}

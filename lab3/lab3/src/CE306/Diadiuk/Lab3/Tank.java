package CE306.Diadiuk.Lab3;

/**
 * Клас представляє бак літака.
 */
public class Tank {
    private int capacity;   // Максимальна ємність бака
    private int currentFuel; // Поточний рівень палива в баку

    /**
     * Конструктор для ініціалізації ємності бака.
     * @param capacity Максимальна ємність бака.
     */
    public Tank(int capacity) {
        this.capacity = capacity;
        this.currentFuel = 0; // Початково бак пустий
    }

    /**
     * Метод для заповнення бака до вказаного рівня.
     * @param amount Кількість палива для додавання.
     */
    public void fillTank(int amount) {
        if (amount < 0) {
            System.out.println("Кiлькiсть палива не може бути вiд'ємною.");
        } else if (currentFuel + amount > capacity) {
            System.out.println("Хотiли заправити " + amount + " лiтрiв палива. Поточний рiвень: " + currentFuel + "/" + capacity);
            System.out.println("Не можна перевищити максимальну ємнiсть бака.");
            System.out.println("Лишнє паливо " + (currentFuel + amount - capacity) );
            currentFuel = capacity; // Заповнюємо до максимума
        } else {
            currentFuel += amount; // Додаємо вказану кількість палива
            System.out.println("Додано " + amount + " лiтрiв палива. Поточний рiвень: " + currentFuel + "/" + capacity);
        }
    }

    /**
     * Метод для перевірки, чи повний бак.
     * @return true, якщо бак повний, і false, якщо бак не повний.
     */
    public boolean isFull() {
        if (currentFuel >= capacity) {
            System.out.println("Бак повний.");
            return true;
        } else {
            System.out.println("Бак не повний.");
            return false;
        }
    }

    /**
     * Метод для виведення поточного стану бака.
     */
    public void getStatus() {
        System.out.println("Поточний рiвень палива: " + currentFuel + "/" + capacity);
    }
}

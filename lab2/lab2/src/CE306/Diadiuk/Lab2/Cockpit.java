package CE306.Diadiuk.Lab2;

/**
 * Клас, що представляє кабіну літака.
 */
public class Cockpit {
    private String pilotName;

    /**
     * Конструктор для створення кабіни з іменем пілота.
     * @param pilotName Ім'я пілота.
     */
    public Cockpit(String pilotName) {
        this.pilotName = pilotName;
    }

    /**
     * Повертає інформацію про пілота.
     * @return Ім'я пілота.
     */
    public String getStatus() {
        return "Пiлот: " + pilotName;
    }
}

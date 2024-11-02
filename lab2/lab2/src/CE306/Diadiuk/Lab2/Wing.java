package CE306.Diadiuk.Lab2;

/**
 * Клас, що представляє крило літака.
 */
public class Wing {
    private int angle;

    /**
     * Налаштовує кут повороту крила.
     * @param angle Кут повороту.
     */
    public void adjust(int angle) {
        this.angle = angle;
    }

    /**
     * Повертає поточний статус крила.
     * @return кут повороту крила.
     */
    public String getStatus() {
        return "кут: " + angle;
    }
}

package CE306.Diadiuk.Lab2;

/**
 * Клас, що представляє двигун літака.
 */
public class Engine {
    private boolean running;

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    public String getStatus() {
        return running ? "працює" : "не працює";
    }
}
package CE306.Diadiuk.Lab3;

//import java.io.FileWriter;
//import java.io.IOException;
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
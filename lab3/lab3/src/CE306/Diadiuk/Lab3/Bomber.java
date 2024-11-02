package CE306.Diadiuk.Lab3;

import java.io.IOException;

/**
 * Клас, що представляє бомбардувальник.
 */
public class Bomber extends Airplane implements BombDropper {
    private int bombCount;

    public Bomber(Engine engine, Wing leftWing, Wing rightWing, Cockpit cockpit, Tank tank, int bombCount) throws IOException {
        super(engine, leftWing, rightWing, cockpit, tank);
        this.bombCount = bombCount;
    }

    
    public void dropBombs() {
        if (bombCount > 0) {
            System.out.println("Бомба скинута!");
            bombCount--;
        } else {
            System.out.println("Усі бомби скинуті.");
        }
    }

    public void dropBomb() {
        dropBombs();
    }

    public int getBombCount() {
        return bombCount;
    }
}

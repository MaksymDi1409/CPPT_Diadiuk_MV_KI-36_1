package CE306.Diadiuk.Lab6;

/**
 * Клас Tool представляє інструмент.
 */
public class Tool implements Comparable<Tool> {
    private String name;
    private int weight;

    public Tool(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Tool other) {
        return Integer.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return name + " (" + weight + " кг)";
    }
}

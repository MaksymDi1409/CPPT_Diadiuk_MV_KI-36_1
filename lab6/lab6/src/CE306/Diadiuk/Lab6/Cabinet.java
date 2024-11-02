package CE306.Diadiuk.Lab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Параметризований клас Cabinet, що представляє шафу з можливістю додавання та вилучення елементів.
 * @param <T> Тип елементів, які зберігаються в шафі. 
 */
public class Cabinet<T extends Comparable<T>> {
    private List<T> items;

    public Cabinet() {
        items = new ArrayList<>();
    }

    /**
     * Метод для додавання елемента до шафи.
     * @param item Елемент для додавання.
     */
    public void addItem(T item) {
        items.add(item);
        System.out.println("Елемент додано: " + item);
    }

    /**
     * Метод для видалення елемента зі шафи.
     * @param item Елемент для видалення.
     */
    public void removeItem(T item) {
        if (items.remove(item)) {
            System.out.println("Елемент видалено: " + item);
        } else {
            System.out.println("Елемент не знайдено.");
        }
    }

    /**
     * Метод для пошуку мінімального елемента в шафі.
     * @return Мінімальний елемент або null, якщо шафа пуста.
     */
    public T findMinimum() {
        if (items.isEmpty()) return null;
        return Collections.min(items);
    }

    /**
     * Метод для виведення вмісту шафи.
     */
    public void displayItems() {
        System.out.println("Вмiст шафи: " + items);
    }
}

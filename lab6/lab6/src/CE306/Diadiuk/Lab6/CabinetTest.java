package CE306.Diadiuk.Lab6;

public class CabinetTest {
    public static void main(String[] args) {
        Cabinet<Book> bookCabinet = new Cabinet<>();
        bookCabinet.addItem(new Book("Java Programming", 500));
        bookCabinet.addItem(new Book("Data Structures", 300));
        bookCabinet.displayItems();
        System.out.println("Мiнiмальний елемент: " + bookCabinet.findMinimum());

        Cabinet<Tool> toolCabinet = new Cabinet<>();
        toolCabinet.addItem(new Tool("Hammer", 2));
        toolCabinet.addItem(new Tool("Screwdriver", 1));
        toolCabinet.displayItems();
        System.out.println("Мiнiмальний елемент: " + toolCabinet.findMinimum());
    }
}

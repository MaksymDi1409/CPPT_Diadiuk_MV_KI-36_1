import java.io.*;
import java.util.Scanner;

/**
 * Клас реалізує приклад програми відповідно до вимог лабораторної роботи 1.
 * 
 */
   public class Lab1Diadiuk306 {
/**
     * Основний метод, який є точкою входу в програму.
     * @param args Аргументи командного рядка, передані програмі.
     */
    public static void main(String[] args) {
        try {
            runProgram();
        } catch (FileNotFoundException e) {
            System.out.println("Помилка: неможливо створити файл.");
        }
    }

    /**
     * Основний метод програми.
     * @throws FileNotFoundException у випадку неможливості створити або записати у файл.
     */
    public static void runProgram() throws FileNotFoundException {
        // Ініціалізація сканера для читання вводу користувача
        try (Scanner inputScanner = new Scanner(System.in)) {
            // Отримання розміру матриці та перевірка коректності
            int matrixSize = getMatrixSize(inputScanner);

            // Отримання символу-заповнювача та перевірка коректності
            String fillCharacter = getFillCharacter(inputScanner);

            // Створення файлу для зберігання результатів виводу
            File outputFile = new File("MyFile.txt");
            try (PrintWriter fileWriter = new PrintWriter(outputFile)) {
                // Ініціалізація та заповнення матриці
                char[][] matrix = initializeMatrix(matrixSize, fillCharacter);

                // Виведення матриці на екран і у файл
                printMatrix(matrix, fileWriter);
            }
        }
    }

    /**
     * Метод для отримання і перевірки коректності розміру матриці.
     */
    private static int getMatrixSize(Scanner scanner) {
        int matrixSize;
        do {
            System.out.print("Введiть розмiрнiсть матрицi: ");
            matrixSize = scanner.nextInt();
            scanner.nextLine(); // Очищення буферу
            if (matrixSize < 1) {
                System.out.println("Некоректна розмiрнiсть матрицi. Введiть додатне число.");
            }
        } while (matrixSize < 1);
        return matrixSize;
    }

    /**
     * Метод для отримання і перевірки коректності символа-заповнювача.
     */
    private static String getFillCharacter(Scanner scanner) {
        String fillCharacter;
        do {
            System.out.print("Введiть символ-заповнювач: ");
            fillCharacter = scanner.nextLine();
            if (fillCharacter.length() == 0) {
                System.out.println("Не введено символ-заповнювач.");
            } else if (fillCharacter.length() > 1) {
                System.out.println("Забагато символiв-заповнювачiв. Введiть один символ.");
            }
        } while (fillCharacter.length() != 1);
        return fillCharacter;
    }

    /**
     * Метод для ініціалізації та заповнення матриці.
     */
    private static char[][] initializeMatrix(int matrixSize, String fillCharacter) {
        char[][] matrix = new char[matrixSize][];

        // Обчислення половини розміру матриці
        int halfSize = (matrixSize + 1) / 2;

        // Заповнення матриці
        for (int i = 0; i < halfSize; ++i) {
            int oppositeIndex = matrixSize - i - 1; // Протилежний рядок для симетрії
            int length;

            if (i == halfSize - 1 && matrixSize % 2 != 0) {
                length = matrixSize; // Середній рядок повинен мати кількість елементів рівну matrixSize
            } else {
                length = 2 + (i * 2); // Для інших рядків
            }

            matrix[i] = new char[length];
            if (i != oppositeIndex) {
                matrix[oppositeIndex] = new char[length];
            }

            // Заповнення символом-заповнювачем
            for (int j = 0; j < length; j++) {
                matrix[i][j] = matrix[oppositeIndex][j] = fillCharacter.charAt(0);
            }
        }
        return matrix;
    }

    /**
     * Метод для виведення матриці на екран і запису у файл.
     */
    private static void printMatrix(char[][] matrix, PrintWriter fileWriter) {
        int matrixSize = matrix.length;

        for (int i = 0; i < matrixSize; ++i) {
            int currentRowLength = matrix[i].length;
            int spacesBetween = (matrixSize - currentRowLength) * 2;

            // Виведення лівої половини символів
            for (int q = 0; q < currentRowLength / 2; ++q) {
                System.out.print(matrix[i][q] + " ");
                fileWriter.print(matrix[i][q] + " ");
            }

            // Виведення пробілів
            for (int l = 0; l < spacesBetween; l++) {
                System.out.print(" ");
                fileWriter.print(" ");
            }

            // Виведення правої половини символів
            for (int q = currentRowLength / 2; q < currentRowLength; ++q) {
                System.out.print(matrix[i][q] + " ");
                fileWriter.print(matrix[i][q] + " ");
            }

            // Перехід на новий рядок після кожного рядка
            System.out.println();
            fileWriter.println();
        }
    }
}
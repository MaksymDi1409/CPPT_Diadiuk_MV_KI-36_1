import math
import struct

# Функція для обчислення виразу згідно з варіантом
def calculate_expression(x):
    """Обчислює значення y = tan(x) / sin(2 * x)."""
    try:
        result = math.tan(x) / math.sin(2 * x)
        return result
    except ZeroDivisionError:
        raise ValueError("Неможливо обчислити: ділення на нуль.")

# Функція для запису результату у текстовий файл
def write_text_file(filename, x, y):
    """Записує значення x та y у текстовий файл."""
    try:
        with open(filename, 'w') as file:
            file.write(f"x: {x}, y: {y}\n")
    except IOError:
        print(f"Помилка запису до текстового файлу: {filename}")

# Функція для запису результату у двійковий файл
def write_binary_file(filename, x, y):
    """Записує значення x та y у двійковий файл."""
    try:
        with open(filename, 'wb') as file:
            file.write(struct.pack('ff', x, y))
    except IOError:
        print(f"Помилка запису до двійкового файлу: {filename}")

# Функція для читання результату з текстового файлу
def read_text_file(filename):
    """Зчитує значення x та y з текстового файлу."""
    try:
        with open(filename, 'r') as file:
            data = file.read()
            print("З текстового файлу:", data)
    except FileNotFoundError:
        print(f"Файл не знайдено: {filename}")
    except IOError:
        print(f"Помилка читання з текстового файлу: {filename}")

# Функція для читання результату з двійкового файлу
def read_binary_file(filename):
    """Зчитує значення x та y з двійкового файлу."""
    try:
        with open(filename, 'rb') as file:
            data = struct.unpack('ff', file.read(8))
            print("З двійкового файлу: x =", data[0], ", y =", data[1])
    except FileNotFoundError:
        print(f"Файл не знайдено: {filename}")
    except struct.error:
        print(f"Помилка читання даних з двійкового файлу: {filename}")
    except IOError:
        print(f"Помилка доступу до двійкового файлу: {filename}")

# Основна функція
def main():
    try:
        x = float(input("Введіть значення x: "))
        y = calculate_expression(x)

        # Запис результатів у файли
        write_text_file("results.txt", x, y)
        write_binary_file("results.bin", x, y)

        # Читання результатів з файлів
        read_text_file("results.txt")
        read_binary_file("results.bin")
    except ValueError as e:
        print("Помилка:", e)

if __name__ == "__main__":
    main()
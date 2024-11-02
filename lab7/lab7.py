# lab7.py
import sys

# Модуль для генерації та виведення зубчастого списку на основі введення користувача.
def main():
    try:
        # Отримуємо розмір матриці та символ-заповнювач від користувача
        matrix_size = get_matrix_size()
        fill_char = get_fill_character()

        # Ініціалізуємо матрицю та виводимо її на екран
        matrix = initialize_matrix(matrix_size, fill_char)
        print_matrix(matrix)
    except Exception as e:
        print("Виникла помилка:", e)


def get_matrix_size():
    """Отримує та перевіряє коректність розміру матриці, введеного користувачем."""
    while True:
        try:
            matrix_size = int(input("Введіть розмір матриці: "))
            if matrix_size < 1:
                print("Розмір матриці має бути додатнім.")
            else:
                return matrix_size
        except ValueError:
            print("Некоректне введення. Введіть ціле число.")


def get_fill_character():
    """Отримує та перевіряє символ-заповнювач, введений користувачем."""
    while True:
        fill_char = input("Введіть один символ-заповнювач: ")
        if len(fill_char) != 1:
            print("Введіть рівно один символ.")
        else:
            return fill_char


def initialize_matrix(matrix_size, fill_char):
    """Ініціалізує та заповнює зубчасту матрицю символом-заповнювачем."""
    matrix = [None] * matrix_size
    half_size = (matrix_size + 1) // 2  # Половина розміру матриці

    for i in range(half_size):
        opposite_index = matrix_size - i - 1  # Індекс симетричного рядка
        if i == half_size - 1 and matrix_size % 2 != 0:
            length = matrix_size  # Середній рядок матиме повний розмір
        else:
            length = 2 + (i * 2)  # Інші рядки мають збільшену довжину
        matrix[i] = [fill_char] * length
        if i != opposite_index:
            matrix[opposite_index] = [fill_char] * length
    return matrix


def print_matrix(matrix):
    """Виводить матрицю у відформатованому вигляді."""
    matrix_size = len(matrix)

    for row in matrix:
        current_row_length = len(row)
        spaces_between = (matrix_size - current_row_length) * 2  # Кількість пробілів для симетрії

        # Виведення лівої половини рядка
        for elem in row[:current_row_length // 2]:
            print(elem, end=" ")

        # Виведення пробілів посередині
        print(" " * spaces_between, end="")

        # Виведення правої половини рядка
        for elem in row[current_row_length // 2:]:
            print(elem, end=" ")
        print()


if __name__ == "__main__":
    main()
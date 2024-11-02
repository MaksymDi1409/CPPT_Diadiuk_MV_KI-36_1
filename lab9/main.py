from aircraft.airplane import Airplane
from aircraft.bomber import Bomber

def main():
    """Основна функція програми."""
    # Створюємо літак
    plane = Airplane("Boeing 737", 200)
    print(plane.info())
    print(plane.fly())

    # Створюємо бомбардувальник
    bomber = Bomber("B-52", 10, 10)
    print(bomber.info())
    print(bomber.fly())
    print(bomber.drop_bombs())

if __name__ == "__main__":
    main()
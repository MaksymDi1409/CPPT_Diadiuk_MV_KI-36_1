class Airplane:
    def __init__(self, model, capacity):
        """Ініціалізує літак з моделлю та місткістю."""
        self.model = model
        self.capacity = capacity

    def fly(self):
        """Метод, що імітує політ літака."""
        return f"{self.model} піднімається в повітря!"

    def info(self):
        """Повертає інформацію про літак."""
        return f"Модель: {self.model}, Місткість: {self.capacity} осіб."
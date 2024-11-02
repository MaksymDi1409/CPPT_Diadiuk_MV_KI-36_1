from aircraft.airplane import Airplane

class Bomber(Airplane):
    def __init__(self, model, capacity, bomb_capacity):
        """Ініціалізує бомбардувальник з моделлю, місткістю та місткістю бомб."""
        super().__init__(model, capacity)
        self.bomb_capacity = bomb_capacity

    def drop_bombs(self):
        """Метод, що імітує скидання бомб."""
        return f"{self.model} скидає {self.bomb_capacity}  бомб!"

    def info(self):
        """Повертає інформацію про бомбардувальник."""
        return f"{super().info()}, Місткість бомб: {self.bomb_capacity} "
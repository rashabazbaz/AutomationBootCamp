from math import pi

class circle:
    radius = 0
    def get_area(self):
        return pi * (self.radius**2)



    def __init__(self, radius):
        self.radius = radius

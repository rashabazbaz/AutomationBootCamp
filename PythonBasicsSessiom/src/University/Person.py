class Person:
    Name = None
    id = None
    def __init__(self, name, id):
        self.Name = name
        self.id = id

    def getInfo(self):
        print(self.Name +","+str(self.id))
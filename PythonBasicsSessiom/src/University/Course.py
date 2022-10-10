class Course:
    NumOfHours = 0
    Teacher = None
    Students = []
    Name = None

    def __init__(self, Name, NumOfHours):
        self.Name = Name
        self.NumOfHours = NumOfHours

    def getInfo(self):
        print(self.Name + " , " + str(self.NumOfHours))

    def getStudents(self):
        return self.Students

    def getTeacherName(self):
        return self.Teacher.Name
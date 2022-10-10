class Teacher:
    Name = None
    id = None
    courses = []

    def __init__(self, name, id):
        self.Name = name
        self.id = id
        self.courses = []

    def getInformation(self):
        print(self.Name + ", " + self.id)

    def getCourses(self):
        return self.courses

    def assignToCourse(self, course):
        self.courses.append(course)
        course.Teacher = self
from University.Person import Person


class Teacher(Person):
    Name = None
    id = None
    courses = []

    def __init__(self, name, id):
        super().__init__(name, id)
        self.courses = []

    def getCourses(self):
        return self.courses

    def assignToCourse(self, course):
        self.courses.append(course)
        course.Teacher = self
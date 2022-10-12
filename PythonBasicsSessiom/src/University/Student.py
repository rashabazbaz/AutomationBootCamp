from University.Person import Person


class Student(Person):
    id = None
    Name = None
    Major = None
    Birthdate = None
    courses = []

    def __init__(self, name, id, birtdate, Major):
        super().__init__(name, id)

        self.Birthdate = birtdate
        self.Major = Major
        self.courses = []




    def getRegCourses(self):
        return self.courses

    def register(self, course):
        self.courses.append(course)
        course.Students.append(self)
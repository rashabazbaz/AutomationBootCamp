class Student:
    id = None
    Name = None
    Major = None
    Birthdate = None
    courses = []

    def __init__(self, name, id, birtdate, Major):
        self.Name = name
        self.id = id
        self.Birthdate = birtdate
        self.Major = Major
        self.courses = []


    def getInfo(self):
        print(self.Name +","+self.id+","+self.Birthdate+","+self.Major)

    def getRegCourses(self):
        return self.courses

    def register(self, course):
        self.courses.append(course)
        course.Students.append(self)
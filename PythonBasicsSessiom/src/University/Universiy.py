from University import Teacher
from University.Course import Course
from University.Student import Student



if __name__ == '__main__':
    print("")
    #Create 3 teachers, and print teacher info for each one
    firstTeach = Teacher.Teacher("Ahmad", "123")
    secondTeach = Teacher.Teacher("Ali", "666")
    thirdTeach = Teacher.Teacher("Rana", "12333")
    teachers = [firstTeach,secondTeach,thirdTeach]
    for tech in teachers:
        tech.getInfo()
    #Create 6 courses and
    cour_list = []
    for i in range(6):
        corsee = Course("Course"+ str(i) , i)
        cour_list.append(corsee)

    #Print course information for each course
    for c in cour_list:
        c.getInfo()

    #assign 2 courses for each teacher
    teachers[0].assignToCourse(cour_list[0])
    teachers[0].assignToCourse(cour_list[1])

    teachers[1].assignToCourse(cour_list[2])
    teachers[1].assignToCourse(cour_list[3])

    teachers[2].assignToCourse(cour_list[4])
    teachers[2].assignToCourse(cour_list[5])
    #Print couse names for each teacher
    for tech in teachers:
        tech_cours = tech.getCourses()
        print("Teacher "+tech.Name+" courses")
        for cou in tech_cours:
            print(cou.Name)
    #Create 5 students
    students_list = []
    stu1 = Student( "wisam", "13i8834", "22-22-2222", "IT")
    students_list.append(stu1)
    stu2 = Student("mahmoud", "13kki8834", "22-22-2222", "IT")
    students_list.append(stu2)
    stu3 = Student("dana", "13i8dd834", "22-22-2222", "IT")
    students_list.append(stu3)
    stu4 = Student("dua", "13i88dd34", "22-22-2222", "IT")
    students_list.append(stu4)
    stu5 = Student("riham", "13ddi8834", "22-22-2222", "IT")
    students_list.append(stu5)
    #Register each student in one or more courses
    stu1.register(cour_list[0])
    stu1.register(cour_list[1])
    stu1.register(cour_list[2])

    stu2.register(cour_list[3])
    stu2.register(cour_list[1])
    stu2.register(cour_list[2])

    stu3.register(cour_list[3])
    stu3.register(cour_list[4])
    stu4.register(cour_list[2])

    stu4.register(cour_list[3])
    stu4.register(cour_list[4])
    stu4.register(cour_list[5])

    stu5.register(cour_list[0])


    #Print student info for each student
    for s in students_list:
        s.getInfo()
    #Print registered courses for each student
    for s in students_list:
        reg_courses = s.getRegCourses()
        print("courses for student named "+ s.Name)
        for c in reg_courses:
            print(c.Name)
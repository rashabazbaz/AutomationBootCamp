class AutomationCourse:
    NumOfHours = 5

    def printInformation(self):
        name= None
        print("this course has " + str(self.NumOfHours) + " hours")


course = AutomationCourse()
try:
    course.printInformation()
except:
    print("Exception")
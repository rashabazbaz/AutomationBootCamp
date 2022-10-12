import allure
from ddt import *
from unittest import TestCase
from Core.WorkWithCsv import *
@ddt
class TestData(TestCase):
    @data((3, 2,3), (4, 3,4), (5, 3,5))
    @unpack
    def test_numbers(self, num1, num2, maxNum):
        self.assertEqual(maxNum, max(num1,num2))

    @data(*WorkWithCsv.get_csv_data("../../files/dataTest.csv"))
    @unpack
    def test_numbers(self, num1, num2, maxNum):
        self.assertEqual(maxNum, max(num1, num2))

    def setUp(self):
        allure.attach.file("../../files/dataTest.csv","test_data.csv",attachment_type=allure.attachment_type.CSV)
        print("Setup")

    def tearDown(self) :
        print("Teardown")

    @classmethod
    def setUpClass(cls) :
        print("Setup class")

    @classmethod
    def tearDownClass(cls):
        print("Teardown class")
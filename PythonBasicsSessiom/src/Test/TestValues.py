from unittest import TestCase

from ddt import *

from Core.WorkWithCsv import *


@ddt
class TestValues(TestCase):
    @data(*WorkWithCsv.get_csv_data("../../files/dataTest.csv"))
    @unpack
    def test_data(self,num1,num2, num3):
        self.assertEqual(max(int(num1),int(num2)),int(num3))
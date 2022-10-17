from ddt import *
from Pages.Calculator import Calculator
from Tests.UnitTestBaseClass import UnitTestBaseClass, get_csv_data

@ddt
class CalculatorTestDDT(UnitTestBaseClass):

    @data(*get_csv_data('../Config/calculator_test_cases.csv'))
    @unpack
    def test_calculator(self, first_number, second_number, cal_method, expected_result):
        calculator_page_inst = Calculator()
        calculator_page_inst.open_calculator_page(self.driver)
        calculator_page_inst.click_on_button(self.driver, "AC")
        self.assertEqual("0", str(calculator_page_inst.get_oputput_text(self.driver)).strip())
        for number in first_number:
            calculator_page_inst.click_on_button(self.driver,number)
        calculator_page_inst.click_on_button(self.driver, cal_method)
        for number in second_number:
            calculator_page_inst.click_on_button(self.driver,number)
        calculator_page_inst.click_on_button(self.driver, "=")

        self.assertEqual(expected_result, str(calculator_page_inst.get_oputput_text(self.driver)).strip())
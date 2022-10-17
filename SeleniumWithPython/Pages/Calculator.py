from selenium.webdriver.common.by import By


class Calculator:
    def open_calculator_page(self, driver):
        driver.get("https://www.calculator.net/")

    def get_button(self,driver,btn_txt):

        return driver.find_element(By.XPATH,"//tr/td[2]//*[text()='{}']".format(btn_txt))


    def click_on_button(self, driver, btn_txt):
        button = self.get_button(driver,btn_txt)
        button.click()

    def get_input_text(self,driver):
        output_text_box = driver.find_element(By.ID, "sciInPut")
        return output_text_box.text

    def get_oputput_text(self,driver):
        output_text_box = driver.find_element(By.ID,"sciOutPut")
        return output_text_box.text

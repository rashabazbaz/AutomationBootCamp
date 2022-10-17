import time

from selenium.webdriver.common.by import By

from Core.MainFunctions import MainFunctions
from Tests.UnitTestBaseClass import UnitTestBaseClass


class BingSearchTest(UnitTestBaseClass):
    def test_Bing_search(self):
        self.driver.get("https://www.bing.com/")
        self.driver.find_element(By.NAME, "q").send_keys("Automation Testing with Selenium")
        self.driver.find_element(By.NAME, "q").submit()
        time.sleep(30)
        print(self.driver.find_elements(By.XPATH,"//h2/a")[0].text)
import time
import unittest

from appium.webdriver.common.appiumby import AppiumBy

from core.ConnectToDevice import ConnectToDevice


class TestCalculator(unittest.TestCase):

    def test(self):
        driver = ConnectToDevice.connect_to_device("emulator-5554", "../apk/sample_Calculator_1.0_Apkpure.apk",
                                                   "com.bak.mnr.calculatrice", None)
        time.sleep(5)
        element = driver.find_element(AppiumBy.ID,"com.bak.mnr.calculatrice:id/btn2")
        element.click()

        time.sleep(5)
        element = driver.find_element(AppiumBy.ID,"com.bak.mnr.calculatrice:id/btnP")
        element.click()
        time.sleep(5)
        element = driver.find_element(AppiumBy.ID,"com.bak.mnr.calculatrice:id/btn4")
        element.click()
        time.sleep(5)

        element = driver.find_element(AppiumBy.ID,"com.bak.mnr.calculatrice:id/btnE")
        element.click()
        time.sleep(5)

        element = driver.find_element(AppiumBy.ID,"com.bak.mnr.calculatrice:id/Cadre")
        self.assertEquals(element.text, '6.0')

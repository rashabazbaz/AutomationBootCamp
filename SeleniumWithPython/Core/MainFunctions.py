from selenium import webdriver
from selenium.webdriver.chrome.options import Options

from Core.Constants import Constants


class MainFunctions:
    @staticmethod
    def open_browser():
        options = Options()
        #options.add_argument('--headless')
        options.add_argument('--disable-gpu')
        options.add_argument('--disable-dev-shm-usage')
        driver = webdriver.Chrome(executable_path=Constants.CHROME_DRIVER_PATH, chrome_options=options)
        driver.implicitly_wait(100)
        driver.maximize_window()
        return driver
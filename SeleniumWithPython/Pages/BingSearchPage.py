from selenium.webdriver.common.by import By


class BingSearchPage:
    @staticmethod
    def open_bing_page(driver):
        driver.get("https://www.bing.com/")

    @staticmethod
    def get_search_box(driver):
        return driver.find_element(By.NAME, "q")

    def search(self, driver, search_text):
        search_box = BingSearchPage.get_search_box(driver)
        search_box.send_keys(search_text)
        search_box.submit()

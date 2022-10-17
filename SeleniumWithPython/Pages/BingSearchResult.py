from selenium.webdriver.common.by import By


class BingSearchResult:

    @staticmethod
    def get_results(driver):
        return driver.find_elements(By.XPATH,"//h2/a")

    @staticmethod
    def get_result_text(driver,index):
        results_list = BingSearchResult.get_results(driver)
        return results_list[index].text
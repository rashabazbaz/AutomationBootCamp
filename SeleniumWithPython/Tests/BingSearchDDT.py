from ddt import *
from Pages.BingSearchPage import BingSearchPage
from Pages.BingSearchResult import BingSearchResult
from Tests.UnitTestBaseClass import UnitTestBaseClass, get_csv_data

@ddt
class BingSearchDDT(UnitTestBaseClass):

    @data(*get_csv_data('../Config/Bing_search_test_cases.csv'))
    @unpack
    def test_Bing_search(self, search_text, first_result):
        bing_search_inst = BingSearchPage()
        bing_search_inst.open_bing_page(self.driver)
        bing_search_inst.search(self.driver,search_text)
        self.assertEqual(str(first_result).strip(), str(BingSearchResult.get_result_text(self.driver,0)).strip())

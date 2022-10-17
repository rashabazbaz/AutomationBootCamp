from unittest import TestCase

from Core.MainFunctions import *
from ddt import *
from Rest.ReqUsage import *


@ddt
class TestRestApis(TestCase):
    failedCasses = []
    headers = []
    baseUrl = ""

    @classmethod
    def setUpClass(cls):
        cls.baseUrl = MainFunctions.get_prop_value("../Configs/prop.config", "server", "url")
        cls.headers = ["method", "route", "status", "expected_status_code"]

    @classmethod
    def tearDownClass(cls):
        MainFunctions.write_csv_file("failed.csv", cls.headers, cls.failedCasses)

    @data(*MainFunctions.get_csv_data("../Configs/get_tests.csv"))
    @unpack
    def test_get(self, route, expected_status):
        status_code, text = ReqUsage.get_req(self.baseUrl + route)
        if int(status_code) != int(expected_status):
            self.failedCasses.append(["get",route,status_code, expected_status])
        self.assertEqual(int(status_code), int(expected_status))

    @data(*MainFunctions.get_csv_data("../Configs/delete_tests.csv"))
    @unpack
    def test_delete(self, route, expected_status):
        status_code, text = ReqUsage.delete_req(self.baseUrl + route)
        if int(status_code) != int(expected_status):
            self.failedCasses.append(["delete",route,status_code, expected_status])
        self.assertEqual(int(status_code), int(expected_status))

    @data(*MainFunctions.get_data_list_json("../Configs/put_tests.json", ["route", "expected_status", "body"]))
    @unpack
    def test_put(self, route, expected_status, body):
        status_code, text = ReqUsage.put_req(body, self.baseUrl + route)
        if int(status_code) != int(expected_status):
            self.failedCasses.append(["put",route,status_code, expected_status])
        self.assertEqual(int(status_code), int(expected_status))

    @data(*MainFunctions.get_data_list_json("../Configs/post_tests.json", ["route", "expected_status", "body"]))
    @unpack
    def test_post(self, route, expected_status, body):
        status_code, text = ReqUsage.post_req(body, self.baseUrl + route)
        if int(status_code) != int(expected_status):
            self.failedCasses.append(["post",route,status_code, expected_status])
        self.assertEqual(int(status_code), int(expected_status))

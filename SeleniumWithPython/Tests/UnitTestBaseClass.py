import csv

import os
import unittest

from Core.MainFunctions import MainFunctions


def get_csv_data(csv_path):
    print(os.path.abspath(csv_path))
    rows = []
    csv_data = open(str(csv_path), "r", encoding="utf8")
    content = csv.reader(csv_data)
    next(content, None)
    for row in content:
        rows.append(row)
    return rows


class UnitTestBaseClass(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.driver = MainFunctions.open_browser()
        cls.driver.maximize_window()

    @classmethod
    def tearDownClass(cls):
        cls.driver.close()

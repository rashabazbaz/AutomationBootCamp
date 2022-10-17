import configparser
import csv
import json
import os


class MainFunctions:
    @staticmethod
    def get_csv_data(csv_path):
        print(os.path.abspath(csv_path))
        rows = []
        csv_data = open(str(csv_path), "r", encoding="utf8")
        content = csv.reader(csv_data)
        next(content, None)
        for row in content:
            rows.append(row)
        return rows

    @staticmethod
    def write_csv_file(file_path, headers, data):
        with open(file_path, mode='w', newline='') as csv_file:
            csv_file_writer = csv.writer(csv_file, delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL)
            csv_file_writer.writerow(headers)
            for row in data:
                csv_file_writer.writerow(row)

    @staticmethod
    def get_prop_value(filePath, head, key):
        config = configparser.ConfigParser()
        config.read(filePath)
        value = config.get(head, key)
        return value

    @staticmethod
    def read_json_file(path):
        with open(path, encoding="utf8") as json_file:
            data = json.load(json_file)
        return data

    @staticmethod
    def get_data_list_json(path, headers):
        data_list = []
        data = MainFunctions.read_json_file(path)
        for item in data:
            row_to_add = []
            for header in headers:
                row_to_add.append(item[header])
            data_list.append(row_to_add)
        return data_list

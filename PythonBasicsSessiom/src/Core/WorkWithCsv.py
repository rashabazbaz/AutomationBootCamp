import csv


class WorkWithCsv:

    @staticmethod
    def read_csv_file(file_path):
        data = []
        headers = []
        with open(file_path) as csv_file:
            csv_reader = csv.reader(csv_file, delimiter=',')
            for row in csv_reader:
                if len(headers) == 0:
                    headers.extend(row)
                else:
                    data.append(row)
        return headers, data

    @staticmethod
    def get_csv_data(file_path):
        headers, data = WorkWithCsv.read_csv_file(file_path)
        return data

    @staticmethod
    def write_csv_file(file_path, headers, data):
        with open(file_path, mode='w', newline='') as csv_file:
            csv_file_writer = csv.writer(csv_file, delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL)
            csv_file_writer.writerow(headers)
            for row in data:
                csv_file_writer.writerow(row)



if __name__ == '__main__':
    headers, data = WorkWithCsv.read_csv_file("../../files/input.csv")
    WorkWithCsv.write_csv_file("../../files/output.csv",headers,data)


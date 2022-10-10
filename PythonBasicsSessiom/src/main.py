# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    data_list = []
    data_list.append("Ahmad")
    data_list.append("Wisam")
    data_list.append("Alaa")
    print(data_list)
    data_list.sort()
    print(data_list)
    data_list.extend(["Ali","Hani","Ahmad"])
    print(data_list)
    data_list.remove("Ahmad")
    print(data_list)
    data_list.append(["Deyaa", "Amal", "Khalid"])
    print(data_list)

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

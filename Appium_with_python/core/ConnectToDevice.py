import os
from urllib import parse

from appium import webdriver
from appium.options.android import UiAutomator2Options


class ConnectToDevice:
    @staticmethod
    def connect_to_device(deviceName, apk_file,appPackage, appActivity ):
        desired_caps = {}
        options = UiAutomator2Options()
        options.device_name = deviceName
        desired_caps['platformName'] = 'Android'
        desired_caps['deviceName'] = deviceName


        if apk_file:
            options.app = os.path.abspath(apk_file)
            desired_caps['app'] = os.path.abspath(apk_file)
        desired_caps["appPackage"] = appPackage
        options.app_package = appPackage
        if appActivity:
            options.app_activity = appActivity
            desired_caps['appActivity'] = appActivity

        driver = webdriver.Remote('http://localhost:4723/wd/hub', desired_caps)
        return driver
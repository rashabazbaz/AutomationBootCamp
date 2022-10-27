import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CurrencyTest {
	@Test
	public void CurrencyTest() throws IOException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "1C171FDEE00AUC");
		capabilities.setCapability("appPackage", "com.prince.studio.newcurrency");
		capabilities.setCapability("appActivity", "com.prince.studio.newcurrency.MainActivity");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
		Thread.sleep(1000);
		AndroidElement scheduleEvent =driver.findElement(MobileBy.xpath("//*[@text='Add New']"));
		scheduleEvent.click();
		Thread.sleep(1000);		
	}
}

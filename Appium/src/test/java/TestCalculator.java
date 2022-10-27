import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.remote.MobileCapabilityType;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.remote.DesiredCapabilities;

public class TestCalculator {
	AndroidDriver<AndroidElement> driver;
	@BeforeSuite
	public void beforeSuite() throws IOException {
		String path = new File("sample_Calculator_1.0_Apkpure.apk").getAbsoluteFile().getCanonicalFile().getPath();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "1C171FDEE00AUC");
		capabilities.setCapability("app", path);
		capabilities.setCapability("appPackage", "com.bak.mnr.calculatrice");
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
	}
	
	
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		TakeScreenShot.takeScreenShot(driver, result.getName()+".jpg");
		CalculatorPage calc = new CalculatorPage(driver);
		calc.clearResults();
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
	@Test
	public void test() throws IOException, InterruptedException {
		CalculatorPage calc = new CalculatorPage(driver);
		calc.clickOnBtn("1");
		Thread.sleep(1000);
		calc.clickOnBtn("+");
		Thread.sleep(1000);
		calc.clickOnBtn("5");
		Thread.sleep(1000);
		calc.clickOnBtn("=");
		Thread.sleep(1000);
		//locate the edit box of the calculator by using By.tagName()
		//Check the calculated value on the edit box
		String actualRes = calc.getResultText();
		assertEquals(actualRes, "6.0","Actual value is : "+actualRes+" did not match with expected value: 6");

	}
	

	@Test
	public void testWithType() throws IOException, InterruptedException {
		CalculatorPage calc = new CalculatorPage(driver);
		calc.writeInResults("5");
		Thread.sleep(1000);
		calc.clickOnBtn("-");
		Thread.sleep(1000);
		calc.writeInResults("3");
		Thread.sleep(1000);
		calc.clickOnBtn("=");
		Thread.sleep(1000);
		String actualRes = calc.getResultText();
		assertEquals(actualRes, "2.0","Actual value is : "+actualRes+" did not match with expected value: 2");

	}
}

package WorkWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Core.OpenBrowsers;

public class TestAlerts {
	WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite() {
		driver = OpenBrowsers.openBrowser("chrome");
		
	}
	@BeforeMethod
	public void before() {
		driver.get("https://demo.automationtesting.in/Alerts.html");

	}
	@Test
	public void TestAcceptAlert() {
		driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
		driver.switchTo().alert().accept();
	}
	
	
	@Test
	public void TestDissmissAlert() {
		driver.findElement(By.partialLinkText("Alert with OK & Cancel")).click();
		driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
		driver.switchTo().alert().dismiss();
	}
	
	
	@Test
	public void TestSendTextToAlert() {
		driver.findElement(By.partialLinkText("Alert with Textbox")).click();
		driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
		driver.switchTo().alert().sendKeys("Test Automation bootcamp");
		driver.switchTo().alert().accept();
		
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.quit();
		}
}

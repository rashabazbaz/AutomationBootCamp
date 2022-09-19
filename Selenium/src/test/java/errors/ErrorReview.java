package errors;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Core.OpenBrowsers;

public class ErrorReview {
	WebDriver driver;
	@Test
	public void TestMethod() {
		WebDriver driver = OpenBrowsers.openBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}
	@Test
	public void TestMethod2() {
		driver.findElement(By.name("q")).sendKeys("Cypress");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}
}

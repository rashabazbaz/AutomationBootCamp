import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Core.OpenBrowsers;

public class TestJS {
	@Test
	public void testJs() throws InterruptedException {
		WebDriver driver = OpenBrowsers.openBrowser("chrome");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://demoqa.com/automation-practice-form");
		js.executeScript("document.getElementById('firstName').value='Rasha';");
		WebElement MaleBtn = driver.findElement(By.id("gender-radio-1"));
		WebElement femaleBtn = driver.findElement(By.id("gender-radio-2"));
		js.executeScript("arguments[0].click(); arguments[1].click();", MaleBtn, femaleBtn);
		Thread.sleep(5000);
		js.executeScript("arguments[0].checked=false;", MaleBtn);
		Thread.sleep(5000);

		js.executeScript("document.getElementById('gender-radio-2').click();");
		Thread.sleep(5000);
		js.executeScript("document.getElementById('gender-radio-2').checked=false;");
		Thread.sleep(5000);
		js.executeScript("history.go(0)"); 
		js.executeScript("window.scrollBy(0,150)"); 
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,150)");
		js.executeScript("window.location = 'https://www.softwaretestingmaterial.com'");
		Thread.sleep(5000);

	}
}

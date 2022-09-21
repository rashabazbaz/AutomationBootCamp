package WorkWithMouseAndKeyboard;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Core.OpenBrowsers;

public class TestCopyPaste {
	WebDriver driver;
	
	@BeforeSuite
	public void before() {
		driver = OpenBrowsers.openBrowser("chrome");
		driver.get("https://demo.automationtesting.in/Register.html");
	}
	
	@Test
	public void testCopyPaste() {
		WebElement firstName = driver.findElement(By.xpath("//input[@ng-model=\"FirstName\"]"));
		WebElement lastName = driver.findElement(By.xpath("//input[@ng-model=\"LastName\"]"));
		firstName.sendKeys("test");
		Actions actions = new Actions(driver);
		actions.click(firstName);
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("a");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();
		
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("c");
		actions.keyUp(Keys.CONTROL);

		actions.build().perform();
		
		actions.click(lastName);
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("v");
		actions.keyUp(Keys.CONTROL);

		actions.build().perform();
	}
	
	
}

package WorkWithMouseAndKeyboard;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Core.OpenBrowsers;
import Core.TakeScreenShot;

public class workWithActions {
	WebDriver driver;
	TakeScreenShot takeScr;
	@BeforeSuite
	public void beforeSuite() {
		
		driver = OpenBrowsers.openBrowser("chrome");
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		takeScr = new TakeScreenShot(driver);
	}
	
	@Test
	public void testRightClick() throws InterruptedException, IOException {
		Actions actions = new Actions(driver);
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));
		actions.contextClick(btn).perform();
		takeScr.takeScreenShot("rightClick.png");

		driver.findElement(By.xpath("//*[@id=\"authentication\"]/ul/li[7]/span")).click();
//		driver.switchTo().alert();
//		takeScr.takeScreenShot("quitAlert.png");

		driver.switchTo().alert().accept();
		
		
	}
	
	@Test
	public void testDoubleClick() throws InterruptedException, IOException {
		Actions actions = new Actions(driver);
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));

		actions.doubleClick(btn).perform();
//		driver.switchTo().alert();
//		takeScr.takeScreenShot("doubleClick.png");
		driver.switchTo().alert().accept();
		
		
		
		
	}
	
	@AfterSuite
	public void after() {
		driver.quit();
	}
}

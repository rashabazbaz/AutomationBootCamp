package Booking;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Core.OpenBrowsers;
import Core.TakeScreenShot;

public class TestBooking {
	@Test
	public void testBing() throws InterruptedException, IOException {
		WebDriver driver = OpenBrowsers.openBrowser("chrome");
		Dimension newDimension = new Dimension(1600, 1200);
		driver.manage().window().setSize(newDimension);
		driver.get("https://www.booking.com/");
		Thread.sleep(5000);
		//driver.findElement(By.className("sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByClassName(\"sb-date-field__field\")[0].click();");
		js.executeScript("document.querySelector('[data-date=\"2022-11-15\"]').click();");
		js.executeScript("document.querySelector('[data-date=\"2022-11-16\"]').click();");
		
		WebElement search = driver.findElement(By.id("ss"));
		search.sendKeys("Istanbul");
//
//		search.sendKeys(Keys.DOWN);
//		search.sendKeys(Keys.ENTER);
		driver.findElement(By.className("sb-searchbox__button")).click();
		TakeScreenShot takeSc = new TakeScreenShot(driver);
		takeSc.takeScreenShot("downloads/booking.jpg");
//		



	}
}

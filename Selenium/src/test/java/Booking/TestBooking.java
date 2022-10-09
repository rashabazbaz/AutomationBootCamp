package Booking;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Core.OpenBrowsers;
import Core.TakeScreenShot;

public class TestBooking {
	@Test
	public void testBing() throws InterruptedException, IOException {
		WebDriver driver = OpenBrowsers.openchromeWithOptions();
		Dimension newDimension = new Dimension(1600, 1200);
		driver.manage().window().setSize(newDimension);
		driver.get("https://www.booking.com/");
		Thread.sleep(5000);
		driver.getPageSource();
		TakeScreenShot takeSc = new TakeScreenShot(driver);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@data-mode=\"checkin\"]")).sendKeys("Thu, Oct 6");

		takeSc.takeScreenShot("downloads/booking3.jpg");
		driver.findElement(By.id("ss")).sendKeys("Istanbul");
		//Thread.sleep(5000);

		Thread.sleep(5000);

		driver.findElement(By.id("ss")).sendKeys(Keys.ENTER);
		takeSc.takeScreenShot("downloads/booking.jpg");

		Thread.sleep(5000);
		takeSc.takeScreenShot("downloads/booking2.jpg");



	}
}

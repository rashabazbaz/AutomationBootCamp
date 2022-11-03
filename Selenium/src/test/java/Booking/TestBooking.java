package Booking;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Core.OpenBrowsers;
import Core.TakeScreenShot;
import io.qameta.allure.Allure;

public class TestBooking {
	@Test
	public void testBing() throws InterruptedException, IOException {
		
		File resultFile = new File( "SearchPageOutput.csv");
	    Allure.addAttachment(resultFile.getName(), FileUtils.openInputStream(resultFile));
		
		
		WebDriver driver = OpenBrowsers.openBrowser("chrome");
		Dimension newDimension = new Dimension(1600, 1200);
		driver.manage().window().setSize(newDimension);
		driver.get("https://www.booking.com/");
		Thread.sleep(5000);
		//driver.findElement(By.className("sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//*[@data-testid=\"searchbox-dates-container\"]")).click();
		//js.executeScript("document.getElementsByClassName(\"sb-date-field__field\")[0].click();");
		js.executeScript("document.querySelector('[data-date=\"2022-11-15\"]').click();");
		js.executeScript("document.querySelector('[data-date=\"2022-11-16\"]').click();");
		
		WebElement search = driver.findElement(By.name("ss"));
		search.sendKeys("Istanbul");
//
//		search.sendKeys(Keys.DOWN);
//		search.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"indexsearch\"]//button")).click();
		TakeScreenShot takeSc = new TakeScreenShot(driver);
		takeSc.takeScreenShot("downloads/booking.jpg");
		
		Thread.sleep(5000);
//		List<WebElement> links =driver.findElements(By.xpath("//*[@data-testid=\"title\"]/.."));
//		links.get(0).click();
		driver.findElement(By.xpath("//*[@data-testid=\"title\"]/..")).click();
//		



	}
}

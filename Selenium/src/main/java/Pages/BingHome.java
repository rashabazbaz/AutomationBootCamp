package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BingHome {
	WebDriver driver;
	WebElement searchTxtBox;
	WebElement searchBtn;
	
	public BingHome(WebDriver driver) {
		this.driver = driver;
		this.searchBtn = driver.findElement(By.xpath("//*[@id=\"search_icon\"]"));
		this.searchTxtBox = driver.findElement(By.name("q"));
	}
	
	public void search(String txt) {
		this.searchTxtBox.sendKeys(txt);
		this.searchBtn.click();
	}
}

package Pages.BankSystem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainMenu {
	WebDriver driver;
	WebElement menuItem;
	
	public MainMenu(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	public void pressMenuItem(String MenuTxt) {
		menuItem = driver.findElement(By.linkText(MenuTxt));
		menuItem.click();
	}
}

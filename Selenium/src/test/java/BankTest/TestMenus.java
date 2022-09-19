package BankTest;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Core.OpenBrowsers;
import Pages.BankSystem.LoginPage;

public class TestMenus {
	WebDriver driver;
	@BeforeSuite
	public void before() throws InterruptedException {
		driver = OpenBrowsers.openBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/V1/index.php");
		Thread.sleep(10000);
		String userIdVal = "mngr438269";
		String passVal = "zegYzyh";
		LoginPage login = new LoginPage(driver);
		login.login(userIdVal, passVal);
	}
	@Test(dataProvider = "getTitles")
	public void testMenu(String menuText) throws InterruptedException {
		if (menuText != "Log out") {
			WebElement menuItem  =driver.findElement(By.linkText(menuText));
			String partialUrl = menuItem.getAttribute("href");
			menuItem.click();
			if (driver.getCurrentUrl().contains("#")) {
				WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
				driver.switchTo().frame(frame1);
				WebElement frame2 = driver.findElement(By.id("ad_iframe"));
				driver.switchTo().frame(frame2);
				driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
				driver.switchTo().defaultContent();
				Thread.sleep(3000);

			}
			assertTrue(driver.getCurrentUrl().contains(partialUrl) && driver.getTitle().contains(menuText));
		}
	}

	@DataProvider
	public Object[][] getTitles(){
		List<WebElement> menus =driver.findElements(By.xpath("/html/body/div[3]/div/ul/li/a"));
		Object[][] data = new Object[menus.size()][1];
		int index = 0;
		for (WebElement menu: menus) {
			data[index][0] = menu.getText();
			index++;
		}
		return data;

	}

}

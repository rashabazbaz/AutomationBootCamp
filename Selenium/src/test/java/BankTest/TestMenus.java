package BankTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Core.OpenBrowsers;
import Core.TakeScreenShot;
import Pages.BankSystem.LoginPage;

public class TestMenus {
	WebDriver driver;
	String menuName;
	@BeforeSuite
	public void before() throws InterruptedException {
		driver = OpenBrowsers.openBrowser("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.get("https://demo.guru99.com/V1/index.php");
		Thread.sleep(10000);
		String userIdVal = "mngr438269";
		String passVal = "zegYzyh";
		LoginPage login = new LoginPage(driver);
		login.login(userIdVal, passVal);
	}
	@Test(dataProvider = "getTitles")
	public void testMenu(String menuText) throws InterruptedException {
		menuName = menuText;
		if (!menuText.equals("Log out")) {
			WebElement menuItem  =driver.findElement(By.linkText(menuText));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(menuText)));
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
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			TakeScreenShot takeScr = new TakeScreenShot(driver);
			takeScr.takeScreenShot(result.getName()+"_"+menuName.replace(" ", "_")+".jpg");
		}
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
}

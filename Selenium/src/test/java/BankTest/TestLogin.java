package BankTest;

import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Core.OpenBrowsers;
import Pages.BankSystem.LoginPage;
import Pages.BankSystem.MainMenu;

public class TestLogin {
	WebDriver driver;
	String userIdVal = "mngr438269";
	String passVal = "zegYzyh";
	@BeforeSuite
	public void beforeSuite() throws InterruptedException {
		driver = OpenBrowsers.openBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/V1/index.php");
		Thread.sleep(10000);

	}
	@BeforeMethod
	public void beforeMethod() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.resetForm();
	
	}
	@Test(groups = {"negative"})
	public void testEmptyPassword() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(userIdVal, "");
		
		assertNotEquals(loginPage.getErrorMsgPassword(), "");
	}
	
	@Test(groups = {"negative"})
	public void testEmptyUserId() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("", passVal);
		assertNotEquals(loginPage.getErrorMsgUserId(), "");
	}
	@Test(groups = {"negative"})
	public void testEmptyUserIdAndPassword() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("", "");
		assertNotEquals(loginPage.getErrorMsgPassword(), "");

		assertNotEquals(loginPage.getErrorMsgUserId(), "");
	}
	
	@Test(dependsOnGroups = {"negative"}, alwaysRun = true)
	public void loginTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(userIdVal, passVal);
		
		Thread.sleep(10000);
		MainMenu men = new MainMenu(driver);
		men.pressMenuItem("Log out");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	}
}

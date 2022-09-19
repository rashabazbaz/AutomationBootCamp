package errors;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Core.OpenBrowsers;
import Pages.BankSystem.LoginPage;

public class ErrorsTest {
	String userIdVal = "mngr438269";
	String passVal = "zegYzyh";
	
	@Test
	public void testMeth() throws InterruptedException {
		WebDriver driver = OpenBrowsers.openBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/V1/index.php");
		Thread.sleep(10000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(userIdVal, passVal);
		Thread.sleep(5000);
		System.out.println(loginPage.getErrorMsgPassword());
		
	
	}
}

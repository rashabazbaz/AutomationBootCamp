import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Core.OpenBrowsers;

public class TestLogout {
	@Test
	public void logout() throws InterruptedException {
		WebDriver driver = OpenBrowsers.openBrowser("chrome");
		driver.get("https://demo.guru99.com/V1/index.php");
		Thread.sleep(10000);
		driver.manage().window().maximize();

		driver.findElement(By.name("uid")).sendKeys("mngr438269");
		driver.findElement(By.name("password")).sendKeys("zegYzyh");
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(10000);
		driver.findElement(By.partialLinkText("Log out")).click();
		try {
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
		}catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(10000);
	//	driver.quit();
	}
}

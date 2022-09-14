import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Core.OpenBrowsers;

public class TestBrowsersWithParameters {
	@Parameters({"browser"})
	@Test
	public void testBrowsers(String browser) throws InterruptedException {
		WebDriver driver = OpenBrowsers.openBrowser(browser);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		driver.get("https://www.bing.com/");
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().forward();
		Thread.sleep(10000);
		driver.quit();
	}
}

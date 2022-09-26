package WorkWithWindows;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import Core.OpenBrowsers;

public class TestWindows {
	@Test
	public void workWithWindows() throws InterruptedException {
		WebDriver driver = OpenBrowsers.openBrowser("chrome");
		
		String firstWindow = driver.getWindowHandle();
		System.out.println(driver.getWindowHandles().size());
		driver.get("https://www.bing.com/");
		Thread.sleep(5000);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		String secondWindow = driver.getWindowHandle();
		System.out.println(driver.getWindowHandles().size());
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.bing.com/");
		Thread.sleep(5000);
		String thirdTab = driver.getWindowHandle();

		System.out.println(driver.getWindowHandles().size());
		
		
		driver.switchTo().window(secondWindow);
		//driver.close();
		//driver.switchTo().window(thirdTab).close();
		driver.switchTo().window(firstWindow);
		driver.get("https://www.google.com/");
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.quit();
	}
}

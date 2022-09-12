import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestBing {

	@Test
	public void testBing() throws InterruptedException {
		WebDriver driver = OpenBrowsers.openBrowser("chrome");
		driver.get("https://www.bing.com/");
		Thread.sleep(10000);
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Selenium");
		//		
		//		search.clear();
		//		search.sendKeys("Celin dion");
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"search_icon\"]"));
		btn.click();
		List<WebElement> results = driver.findElements(By.xpath("//*[@id=\"b_results\"]//*/h2/a")); 
		for(WebElement result: results) {
			System.out.println(result.getText());
			System.out.println(result.getAttribute("href"));
		}
		
		driver.quit();
		//driver.switchTo().alert().accept();
		System.out.println("Test");

	}
}

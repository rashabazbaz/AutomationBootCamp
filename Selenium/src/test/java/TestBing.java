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
		
		search.clear();
		search.sendKeys("Youtube");
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"search_icon\"]"));
		btn.click();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"b_results\"]/li[1]/h2/a")).getText());
		System.out.println("Test");
	}
}

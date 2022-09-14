package WorkWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Core.OpenBrowsers;
import Core.Table;

public class TestWorkWithTable {
	@Test
	public void workWithTable() throws InterruptedException {
		WebDriver driver = OpenBrowsers.openBrowser("chrome");
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		
		Thread.sleep(10000);
		WebElement tableWebElement = driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table"));
		Table dataTable = new Table(driver, tableWebElement);
		System.out.println(dataTable.getCellValue(1, "Company"));
		System.out.println(dataTable.getRowNumber());
		driver.quit();
	}
}

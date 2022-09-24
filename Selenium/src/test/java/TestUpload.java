import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Core.OpenBrowsers;

public class TestUpload {
	@Test
	public void testUpload() {
		WebDriver driver = OpenBrowsers.openBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/upload/");
		File file = new File("input.csv");
		driver.findElement(By.name("uploadfile_0")).sendKeys(file.getAbsolutePath());
		
		driver.findElement(By.id("submitbutton")).click();
		driver.findElement(By.id("terms")).click();
		
		
	}
}

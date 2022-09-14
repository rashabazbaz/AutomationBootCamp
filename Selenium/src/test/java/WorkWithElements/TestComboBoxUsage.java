package WorkWithElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Core.OpenBrowsers;

public class TestComboBoxUsage {
	@Test
	public void workWithComboBox() throws InterruptedException {
		WebDriver driver = OpenBrowsers.openBrowser("chrome");
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		WebElement skillsElement = driver.findElement(By.id("Skills"));
		Select skills = new Select(skillsElement);
		skills.selectByIndex(1);
		Thread.sleep(10000);
		System.out.println(skills.getFirstSelectedOption().getText());
		
		skills.selectByValue("Python");
		Thread.sleep(10000);
		System.out.println(skills.getFirstSelectedOption().getText());
		
		

		skills.selectByValue("Ruby");
		Thread.sleep(10000);
		System.out.println(skills.getFirstSelectedOption().getText());
		driver.quit();
	}
}

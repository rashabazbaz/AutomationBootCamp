import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CalculatorPage {
	AndroidDriver<AndroidElement> driver;
	
	public CalculatorPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}
	
	public void clickOnBtn(String txt) {
		AndroidElement btn=driver.findElement(MobileBy.xpath("//*[@text='"+txt+"']"));
		btn.click();
	}
	
	public void clearResults() {
		WebElement btn=driver.findElement(By.id("com.bak.mnr.calculatrice:id/btnC"));
		btn.clear();
		
	}
	
	public String getResultText() {
		WebElement results=driver.findElement(By.id("com.bak.mnr.calculatrice:id/Cadre"));
		return results.getText();
	}
	
	
	public void writeInResults(String value) {
		WebElement results=driver.findElement(By.id("com.bak.mnr.calculatrice:id/Cadre"));
		results.clear();
		results.sendKeys(value);
	}
}

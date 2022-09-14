package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BingResults {
	WebDriver driver;
	
	public BingResults(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<WebElement> getResults(){
		List<WebElement> results = driver.findElements(By.xpath("//*[@id=\"b_results\"]//*/h2/a"));
		return results;
	}
	
	public List<String> getLinks(){
		List<String> links = new ArrayList<String>();
		List<WebElement> results = this.getResults();
		for(WebElement res: results) {
			links.add(res.getAttribute("href"));
		}
		return links;
	}
}

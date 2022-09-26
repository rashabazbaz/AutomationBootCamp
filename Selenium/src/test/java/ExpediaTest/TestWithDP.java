package ExpediaTest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Core.OpenBrowsers;
import Core.ReadCsvFile;
import Core.WriteCsvFile;
import Pages.BingHome;
import Pages.BingResults;

public class TestWithDP {
	WebDriver driver;
	ArrayList<String> outputHeaders = new ArrayList<String>();
	ArrayList<ArrayList<String>> outputData = new ArrayList<ArrayList<String>>();
	@BeforeSuite
	public void beforeSuite() throws InterruptedException {
		driver = OpenBrowsers.openchromeWithOptions();
		//driver = OpenBrowsers.openBrowser("chrome");
		outputHeaders.add("hotel_id");
		outputHeaders.add("name");
		outputHeaders.add("city");
		outputHeaders.add("address");
		Thread.sleep(10000);
		driver.manage().window().maximize();
	}

	@DataProvider
	public static Object[][] getData() throws Exception{

		List<String[]> lines = ReadCsvFile.readAllLines("input.csv");
		lines.remove(0);
		Object[][] data = new Object[lines.size()][lines.get(0).length];
		int index = 0;
		for(String[] line : lines) {
			data[index] = line;
			index++;
		}
		return data;
	}
	@Test(dataProvider = "getData")
	public void testExpediaLinks(String hotel_id, String name, String city, String	address) {
		String searchText = name + " " + city + " expedia";
		
		ArrayList<String> currOutput = new ArrayList<String>();
		currOutput.add(hotel_id);
		currOutput.add(name);
		currOutput.add(city);
		currOutput.add(address);
		BingHome home = new BingHome(driver);
		home.search(searchText);
		BingResults resPage = new BingResults(driver);
		List<String> results = resPage.getLinks();
		
		ArrayList<String> links = new ArrayList<String>();
		for(String link: results) {

			if(link.startsWith("https://www.expedia.com/") && link.endsWith("Hotel-Information")) {
				links.add(link);
				if(!outputHeaders.contains("link "+ links.size())) {
					outputHeaders.add("link "+ links.size());
				}
			}
		}
		if(links.size() == 0) {
			currOutput.add("hotel not found");
		}else {
			currOutput.addAll(links);
		}
		outputData.add(currOutput);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://www.bing.com/");
	}
	@AfterSuite
	public void afterSuite() {
		driver.quit();
		List<String[]> data = new ArrayList<String[]>();
		for(ArrayList<String> row: outputData) {
			String[] row_data = new String[row.size()];
			for(int i= 0;i<row.size();i++) {
				row_data[i] = row.get(i);
			}
			data.add(row_data);
		}
		String[] headers = new String[outputHeaders.size()];
		for(int i= 0;i<outputHeaders.size();i++) {
			headers[i] = outputHeaders.get(i);
		}
		WriteCsvFile.writeDataLineByLine("output.csv", data, headers);
		
	}
}

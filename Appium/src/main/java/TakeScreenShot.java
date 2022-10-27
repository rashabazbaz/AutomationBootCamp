import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

public class TakeScreenShot {
	public static void takeScreenShot(AndroidDriver driver,String filePath) throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File DestFile=new File(filePath);

		//Copy file at destination

		FileUtils.copyFile(scrFile, DestFile);
	}
}

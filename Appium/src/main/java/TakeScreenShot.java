import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TakeScreenShot {
	public static void takeScreenShot(AndroidDriver<AndroidElement> driver,String filePath) throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File DestFile=new File(filePath);
		FileUtils.copyFile(scrFile, DestFile);
	}
}

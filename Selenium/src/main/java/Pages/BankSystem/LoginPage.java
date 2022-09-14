package Pages.BankSystem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	WebElement userIdTxt;
	WebElement passTxt;
	WebElement loginBtn;
	WebElement passErr;
	WebElement useErr;
	WebElement resetBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		userIdTxt = driver.findElement(By.name("uid"));
		passTxt = driver.findElement(By.name("password"));
		loginBtn = driver.findElement(By.name("btnLogin"));
		resetBtn = driver.findElement(By.name("btnReset"));
	}
	//
	//

	public void resetForm() {
		resetBtn.click();
	}

	public String getErrorMsgUserId() {
		String msg = "";

		try {
			useErr = driver.findElement(By.id("message23"));
			msg = useErr.getText();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return msg;
	}

	public String getErrorMsgPassword() {
		String msg = "";

		try {
			passErr = driver.findElement(By.id("message18"));
			msg = passErr.getText();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return msg;
	}

	public void fillUserId(String txt) {
		userIdTxt.sendKeys(txt);
	}

	public void fillPassword(String txt) {
		passTxt.sendKeys(txt);
	}
	public void clickLogin() {
		loginBtn.click();
	}

	public void login(String user, String pass) {
		this.fillUserId(user);
		this.fillPassword(pass);
		//if (user != "" && pass != "") {
			this.clickLogin();
		

	}
}

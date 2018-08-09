package com.automation.session;

import static com.automation.utility.YamlReader.setYamlFilePath;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import com.automation.actions.*;


public class StartSession {
	
	protected WebDriver driver;

	String driverpath = "src\\test\\resources\\driver\\chromedriver.exe";
	public LoginPageAction loginPageAction;

	private void _initPage() {
		loginPageAction = new LoginPageAction(driver);
		
	}
	
	public StartSession() {
		try {
			testInitiator();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void testInitiator() throws IOException {
		setYamlFilePath();
		try {
			 System.setProperty("webdriver.chrome.driver", driverpath);
		        ChromeOptions options = new ChromeOptions();
		        DesiredCapabilities cap = DesiredCapabilities.chrome();
		        cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(cap);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_initPage();
	}
	
	public void launchApplication(String baseurl) {
		Reporter.log("The application url is :- " + baseurl, true);
		driver.manage().deleteAllCookies();
		driver.get(baseurl);
	}
	
	public void closeBrowserSession() {
		driver.quit();
	}
}

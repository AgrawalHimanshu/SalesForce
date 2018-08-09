package com.automation.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.session.StartSession;
import static com.automation.utility.YamlReader.getYamlValue;

import java.io.IOException;

public class LoginTest {
	
	StartSession test;
	
	@BeforeClass
	public void Start_Test_Session() {
		test = new StartSession();
	}
  
	@Test
	public void Step01_Launch_Application() {
		
		test.launchApplication(getYamlValue("baseUrl"));
		test.loginPageAction.enterUserName("abc@xyg.com");
		test.loginPageAction.enterPassword("A111111");
		test.loginPageAction.clickLogin();
	}
		
	@AfterClass
	public void close_Test_Session() throws IOException {
		//test.closeBrowserSession();
	}

}

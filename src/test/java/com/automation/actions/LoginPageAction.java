package com.automation.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.automation.pageObjects.LoginPage;

public class LoginPageAction extends LoginPage{
	
	WebDriver driver;
	
	public LoginPageAction(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	
	 public void enterUserName(String strUserName){
	     userName.sendKeys(strUserName);
	 }
	 
	 public void enterPassword(String strPassword){
		 password.sendKeys(strPassword);
	 }
	 
	 public void clickLogin(){
         loginButton.click();
	 }

	 
	 
}

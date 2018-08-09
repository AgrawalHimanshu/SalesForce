package com.automation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id="lst-ib")
	protected WebElement userName;

    @FindBy(name="password")
    protected WebElement password;

    @FindBy(className="Login")
    protected WebElement loginButton;
    
    
    

}

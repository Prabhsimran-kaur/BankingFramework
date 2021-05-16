package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver ldriver;
	
	 public Loginpage(WebDriver rdriver )//create constructor
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
  @FindBy(name="uid")//give locator path for username
  @CacheLookup
  WebElement txtUserName;
  
  @FindBy(name="password")//give locator path for password
  @CacheLookup
  WebElement txtPassword;
  
  @FindBy(name="btnLogin")//give locator path for login
  @CacheLookup
  WebElement btnLogin;
  
  
  @FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")//give locator path for logout
	@CacheLookup
	WebElement lnkLogout;
//create 4 methods
public void setUserName(String uname)//method of username
{
	txtUserName.sendKeys(uname);
}
public void setPassword(String pwd)//method of pasword
{
	txtPassword.sendKeys(pwd);
}
public void clickSubmit()//method of login
{
	btnLogin.click();
	
}

public void clickLogout() {
	
	lnkLogout.click();
}

}



  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

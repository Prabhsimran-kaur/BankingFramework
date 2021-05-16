package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.Loginpage;

public class LoginTest_002 extends BaseClass {
	@Test
	public void loginTest() throws IOException
	{
		driver.get(baseURL);
		Logger.info("Url is opened");
		
		Loginpage lp=new Loginpage(driver);//create reference of that login page 
		
		lp.setUserName(UserName);
		Logger.info("Enter username");
		
		
		lp.setPassword(Password);
		Logger.info("Enter password");
		
		lp.clickSubmit();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage ")) {
			Assert.assertTrue(true);
			Logger.info(" passed");
			
			
		} else {

			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			Logger.info(" fail");

		}

}}

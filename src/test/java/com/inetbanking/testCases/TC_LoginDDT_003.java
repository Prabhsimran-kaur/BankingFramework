package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.Loginpage;
import com.inetbanking.utilities.Xlutils;

import junit.framework.Assert;

public class TC_LoginDDT_003 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
	Loginpage lp=new Loginpage(driver);
	lp.setUserName(user);
	Logger.info("username povided");
	lp.setPassword(pwd);
	Logger.info("password povided");
	lp.clickSubmit(); 
	Thread.sleep(3000);
	
	if (isAlertPresent()==true)
	{
		driver.switchTo().alert().accept();//close alert
		driver.switchTo().defaultContent();//focus on home page
		Assert.assertTrue(false);
		Logger.warn("login failed");//warning message
	}
	else
	{
		Assert.assertTrue(true);
		Logger.info("Login passed");
		lp.clickLogout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();//close logout alert
	}
	}
	
	public boolean isAlertPresent()//user defined method created to check alert is present or not
	{
		try {
			driver.switchTo().alert();	
			return true;
		} 
		catch (NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider (name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inerbanking/testData/LoginData.xlsx"
				;
		int rownum=Xlutils.getRowCount(path,"Sheet1");
		int colcount=Xlutils.getCellCount(path, "Sheet1",1);
		
		
		
		String logindata[][]=new String [rownum][colcount];
		for (int i = 1; i <= rownum; i++) 
		{
			
			for (int j = 0; j < colcount; j++)
			{
				logindata[i-1][j]=Xlutils.getCellData(path, "Sheet1", i, j);
				
			}
		}
		return logindata;
	}
	
	
	
}

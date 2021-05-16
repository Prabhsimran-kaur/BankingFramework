package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.CustomerPage;
import com.inetbanking.pageObjects.Loginpage;

import junit.framework.Assert;

public class TC_AddCustomerTest_004 extends BaseClass {
	
@Test	
 public void addNewCustomer() throws InterruptedException, IOException
 {
	 Loginpage lp= new Loginpage(driver);
	 lp.setUserName(UserName);
	 Logger.info("Username is provided");
	 lp.setPassword(Password);
	 Logger.info("Paasword is provided");
	 
	 lp.clickSubmit();
	 Thread.sleep(3000);
	 
	 CustomerPage cp=new CustomerPage(driver);
	 cp.clickAddNewCustomer();
	 cp.custName("simran");
	 cp.custgender("female");
	 cp.custdob("03", "31", "1991");
	 Thread.sleep(5000);//take some time for dob
	 cp.custaddress("CANADA");
	 cp.custcity("TORONTO");
	 cp.custstate("Brampton");
	 cp.custpinno("143001");
	 cp.custtelephoneno("5147153786");
	 
	 String email=randomstring()+"@gmail.com";
	 cp.custemailid(email);
	 cp.custpassword("abcd");
	 cp.custsubmit();
	 Thread.sleep(3000);
	 Logger.info("validation started........");
	 
	 boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
	 if (res==true) {
		Assert.assertTrue(true);
		Logger.info("test case passed....");
	} else
	{
	captureScreen(driver,"addNewCustomer")	;//testcase name addnew customer
	Assert.assertTrue(false);
	Logger.info("test case failed....");
	

	}
 }
}

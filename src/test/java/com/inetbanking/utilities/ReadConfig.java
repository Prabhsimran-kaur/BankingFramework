package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;//create object
	
	public ReadConfig()//create constructor
	{
		File src=new File("./Configuration/config.properties");//src refering to config .properties
		
		
		try
		{
			FileInputStream fis= new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);//load all values
		}catch(Exception e)
		{
			System.out.println("exception is"+e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
				return url;
	}
	public String getUsername()
	{
	String username=pro.getProperty("username");
	return username;
	}
	public String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}
	

}

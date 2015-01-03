package com.example.fw;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;

//import com.example.tests.TestBase;

public class ApplicationManager {
	

	//protected ApplicationManager app;
	public WebDriver driver;
	public String baseUrl;
	public boolean acceptNextAlert = true;
	
	
	
    private GroupHelper grouphelper;
    private AddressHelper adresshelper;
	private NavigationHelper navigationhelper;
    	
	public ApplicationManager(){
		 driver = new FirefoxDriver();
		 baseUrl = "http://localhost";
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
//       Нинициализация  	
//		 navigationhelper = new NavigationHelper(this); 
//		 adresshelper = new AddressHelper(this);
//		 grouphelper = new GroupHelper(this);
	}
	
	
	public void stop() {
		   driver.quit();
	
	}
// лк	
	public NavigationHelper getNavigationHelper() {
	if (navigationhelper == null) 
	{	
		navigationhelper = new NavigationHelper(this);
	}
	return 	navigationhelper;

	}
	
	public GroupHelper getGroupHelper() {
		if (grouphelper == null) 
		{	
			grouphelper = new GroupHelper(this);
		}
		return 	grouphelper;

		}

	
	public AddressHelper getAddressHelper() {
	if (adresshelper == null) 
	{	
		adresshelper = new AddressHelper(this);
	}
	return 	adresshelper;

	}
	

}

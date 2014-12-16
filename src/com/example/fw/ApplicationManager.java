package com.example.fw;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

//import com.example.tests.TestBase;

public class ApplicationManager {
	
	//protected ApplicationManager app;
	public WebDriver driver;
	public String baseUrl;
	public boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	public NavigationHelper navigationhelper;
    public GroupHelper grouphelper;
    public AddressHelper adresshelper;
    	
	public ApplicationManager(){
		 driver = new FirefoxDriver();
		 baseUrl = "http://localhost:8081/";
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		 navigationhelper = new NavigationHelper(this);
		 adresshelper = new AddressHelper(this);
		 grouphelper = new GroupHelper(this);
	}
	
	
	public void stop() {
		   driver.quit();
	
	}
	
	

	

}

package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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
	private Properties properties;
	public static String formattext;
    	
	public ApplicationManager(Properties properties){
		this.properties=properties; 
		String browser = properties.getProperty("browser");
		if ("firefox".equals(browser)) {
			driver = new FirefoxDriver();
		} else if ("ie".equals(browser)){
			driver = new InternetExplorerDriver();
		} else if ("chrome".equals(browser)){
			driver = new ChromeDriver();
		} else {
		throw new Error("unsupported browser");
		}
		baseUrl = properties.getProperty("baseUrl");
//		 baseUrl = "http://localhost";
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
//       Нинициализация  	
//		 navigationhelper = new NavigationHelper(this); 
//		 adresshelper = new AddressHelper(this);
//		 grouphelper = new GroupHelper(this);
		 driver.get(baseUrl);
		 formattext = properties.getProperty("formattext");
	}
	
	
	public void stop() {
		   driver.quit();
	
	}
// лк	
	public NavigationHelper navigateTO() {
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

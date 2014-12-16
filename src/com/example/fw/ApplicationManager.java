package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.example.tests.AddressDate;
import com.example.tests.GroupDate;
import com.example.tests.TestBase;

public class ApplicationManager {
	
	//protected ApplicationManager app;
	public static WebDriver driver;
	public static String baseUrl;
	public static boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	public ApplicationManager(){
		 driver = new FirefoxDriver();
		 baseUrl = "http://localhost:8081/";
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		 
	}
	
	
	public void stop() {
		   driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      Assert.fail(verificationErrorString);
		    }
	}
	
	public void returnPage(String pageName) {
		driver.findElement(By.linkText(pageName)).click();
	}

	public void submitForm() {
		driver.findElement(By.name("submit")).click();
	}

	public void fillGropForm(TestBase testBase, GroupDate group) {
		driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.groupname);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	public void fillFormAddress(TestBase testBase, AddressDate addr) { 
		
		
	    driver.findElement(By.name("firstname")).clear();
	    driver.findElement(By.name("firstname")).sendKeys(addr.fname);
	    driver.findElement(By.name("lastname")).clear();
	    driver.findElement(By.name("lastname")).sendKeys(addr.lastname);
	    driver.findElement(By.name("address")).clear();
	    driver.findElement(By.name("address")).sendKeys(addr.address);
	    driver.findElement(By.name("home")).clear();
	    driver.findElement(By.name("home")).sendKeys(addr.home);
	    driver.findElement(By.name("mobile")).clear();
	    driver.findElement(By.name("mobile")).sendKeys(addr.mobile);
	    driver.findElement(By.name("work")).clear();
	    driver.findElement(By.name("work")).sendKeys(addr.work);
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys(addr.email);
	    driver.findElement(By.name("email2")).clear();
	    driver.findElement(By.name("email2")).sendKeys(addr.email2);
	    Select sel = new Select(driver.findElement(By.name("bday")));
	    if  (addr.bday != " ")
	    { 		
	    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(addr.bday);
	    }
	   
	    if (addr.bmonth != " ")
	    {	
	    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(addr.bmonth);
	    }   
	  
	    driver.findElement(By.name("byear")).clear();
	    driver.findElement(By.name("byear")).sendKeys(addr.byear);
	//	    if (addr.group != " ")
	//	    {
	    //new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(addr.group);
	    //}
	    
	    driver.findElement(By.name("address2")).clear();
	    driver.findElement(By.name("address2")).sendKeys(addr.address2);
	    driver.findElement(By.name("phone2")).clear();
	    driver.findElement(By.name("phone2")).sendKeys(addr.phone2);
	
	
	}

	public void newGropCreation() {
		driver.findElement(By.name("new")).click();
	}

	public void GetUrl() {
		driver.get(baseUrl + "/");
	}
	
	public void gotoPage(String namepage) {
	
	    driver.findElement(By.linkText(namepage)).click();
	}

	public void openMainPage() {
	    driver.findElement(By.linkText("addressbookv4.1.4")).click();
	}

	public boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	public boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	public String closeAlertAndGetItsText(TestBase testBase) {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

	

}

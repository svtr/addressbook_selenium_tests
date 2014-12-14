package com.example.tests;

import java.util.concurrent.TimeUnit;


//import org.apache.bcel.generic.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.support.ui.Select;




public class TestBase {

	protected static WebDriver driver;
	protected static String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();



	@BeforeTest
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	


	@AfterTest
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      Assert.fail(verificationErrorString);
	    }
	  }


	protected void returnPage(String pageName) {
		driver.findElement(By.linkText(pageName)).click();
	}
	
	


	
	protected void submitForm() {
		driver.findElement(By.name("submit")).click();
	}

	
	

	protected void fillGropForm(GroupDate group) {
		driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.groupname);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}
	
	

	protected void fillFormAddress(AddressDate addr) { 
		
		
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
	
	
	
	protected void newGropCreation() {
		driver.findElement(By.name("new")).click();
	}

	protected void gotoPage(String namepage) {
	
	    driver.findElement(By.linkText(namepage)).click();
	} 
	

	protected void openMainPage() {
	    driver.findElement(By.linkText("addressbookv4.1.4")).click();
	}


	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	private String closeAlertAndGetItsText() {
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

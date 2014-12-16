package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.AddressDate;
//import com.example.tests.TestBase;

public class AddressHelper extends HelperBase{
	
	    public AddressHelper(ApplicationManager manager) {
		super(manager);
		}

	public void fillFormAddress(AddressDate addr) { 
		
		
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
	    //Select sel = new Select(manager.driver.findElement(By.name("bday")));
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

}

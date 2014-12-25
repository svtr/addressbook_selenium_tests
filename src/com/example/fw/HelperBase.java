package com.example.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.TestBase;

public abstract  class HelperBase {

	
 
	protected ApplicationManager manager;
	protected WebDriver driver;

	public HelperBase(ApplicationManager manager) {
		this.manager = manager;
		this.driver = manager.driver;
    
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
	      if (manager.acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      manager.acceptNextAlert = true;
	    }
	  }


	protected void type(By Locator, String text) {
		if (text != null)
		{
		driver.findElement(Locator).clear();
	 	driver.findElement(Locator).sendKeys(text);
		}
	}


	protected void click(By locator) {
		driver.findElement(locator).click();
	}
	
	protected void selectByText(String text, By locator) {
		new Select(driver.findElement(locator)).selectByVisibleText(text);
	}

    
	
	
	public static String replaceNull(String input) {
		  return input == null ? "" : input;
		}

}

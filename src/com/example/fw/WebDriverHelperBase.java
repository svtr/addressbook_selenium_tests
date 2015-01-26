package com.example.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.TestBase;

public abstract  class WebDriverHelperBase extends HelperBase {

	
 

	protected WebDriver driver;

	public WebDriverHelperBase(ApplicationManager manager) {
		super(manager);
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

    
	
	
	public static String replaceNullOrEmpty(String input) {
		if   (input == null){
			return " ";	
		}
		if   (input.isEmpty() == true){
			return " ";
		}		
		return input;
	  }
	
	
	
	public static String replaceEmpty(String input) {
		if   (input.isEmpty() == true){
			return " ";	
		}
		else return input;
	    }
	


}

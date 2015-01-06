package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NavigationHelper  extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
		}

	public void mainPage() {
		if (!onMainPage()){
//			driver.get(manager.baseUrl + "/addressbookv4.1.4/");
            click(By.linkText("home"));
		}
	}

	private boolean onMainPage() {
		return (driver.findElements(By.id("maintable")).size()>0);
	}

	public void gotoPage(String namepage) {
	
		driver.findElement(By.linkText(namepage)).click();

	}

	
	
	public  NavigationHelper returnPage(String pageName) {
		if ((pageName =="groups")&&(!onGroupPage())){
		click(By.linkText("groups"));
		}
		if ((pageName =="home page")&&!onMainPage())
		{
		click(By.linkText("home page"));
		}
		if (pageName =="group page"){
			driver.findElement(By.linkText(pageName)).click();
		}
		return this;
				
	}

	private boolean onGroupPage() {
		if (driver.getCurrentUrl().contains("/group.php")&& (driver.findElements(By.name("new")).size()>0)){
		return true;
		} else {
				return false;
		}
		
	}



	public NavigationHelper GetUrl() {
		driver.get(manager.baseUrl + "/addressbookv4.1.4/");
		return this;
	}

	
}

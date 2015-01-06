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
			click(By.linkText("home"));
		}
	}

	private boolean onMainPage() {
		return (driver.findElements(By.id("maintable")).size()>0);
	}

	private boolean onGroupPage() {
		if (driver.getCurrentUrl().contains("/group.php")&& (driver.findElements(By.name("new")).size()>0)){
		return true;
		} else {
				return false;
		}
		
	}
	public NavigationHelper gotoPage(String namepage) {
	
		if ((namepage =="groups")&&(!onGroupPage())){
			click(By.linkText("groups"));
			}
			if ((namepage =="home page")&&!onMainPage())
			{
			click(By.linkText("home page"));
			}
			if ((namepage =="group page")&&(!onGroupPage())){
				driver.findElement(By.linkText(namepage)).click();
			}
			return this;
	}

	


	public NavigationHelper GetUrl() {
		driver.get(manager.baseUrl + "/addressbookv4.1.4/");
		return this;
	}

	
}

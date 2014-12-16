package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper  extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
		}

	public void openMainPage() {
		driver.findElement(By.linkText("addressbookv4.1.4")).click();
	}

	public void gotoPage(String namepage) {
	
		driver.findElement(By.linkText(namepage)).click();
	}

	public void returnPage(String pageName) {
		driver.findElement(By.linkText(pageName)).click();
	}

	public void submitForm() {
		driver.findElement(By.name("submit")).click();
	}

	public void GetUrl(ApplicationManager applicationManager) {
		applicationManager.driver.get(applicationManager.baseUrl + "/");
	}

}

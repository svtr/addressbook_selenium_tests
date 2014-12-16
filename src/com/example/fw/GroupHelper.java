package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupDate;
//import com.example.tests.TestBase;

public class GroupHelper extends HelperBase {
	   
	    public GroupHelper(ApplicationManager manager) {
		super(manager);
		}

	public void fillGropForm(GroupDate group) {
		driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.groupname);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	public void newGropCreation() {
		driver.findElement(By.name("new")).click();
	}

}

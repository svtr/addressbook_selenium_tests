package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupDate;
//import com.example.tests.TestBase;

public class GroupHelper extends HelperBase {
	   
	    public GroupHelper(ApplicationManager manager) {
		super(manager);
		}

	public void fillGropForm(GroupDate group) {
		type(By.name("group_name"), group.groupname);
		type(By.name("group_header"), group.header);
		type(By.name("group_footer"), group.footer);
	    	 
	}

	public void newGropCreation() {
		click(By.name("new"));
	}

	public void deletegroupe(int index) {
		selectGroupeByIndex(index);
		click(By.name("delete"));
		
	}

	private void selectGroupeByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+index+"]"));
	}

	public void initmodifygroupe(int index) {
		selectGroupeByIndex(index);
		click(By.name("edit"));
		
	}

	public void submitGroupFirm() {
		click(By.name("update"));
		
	}


   

}

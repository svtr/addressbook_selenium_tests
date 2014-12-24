package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
		click(By.xpath("//input[@name='selected[]']["+(index+1)+"]"));
	}

	public void initmodifygroupe(int index) {
		selectGroupeByIndex(index);
		click(By.name("edit"));
		
	}

	public void submitGroupFirm() {
		click(By.name("update"));
		
	}

	public List<GroupDate> GetGroups() {
		List<GroupDate> groups = new ArrayList<GroupDate>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupDate group = new GroupDate();
			String title = checkbox.getAttribute("title");
			group.groupname =   title.substring("Select (".length(), title.length() - ")".length());
			groups.add(group);
			
		}
		return groups;
	}


   

}

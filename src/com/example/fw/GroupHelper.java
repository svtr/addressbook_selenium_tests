package com.example.fw;

import java.util.List;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebElement;
import com.example.tests.GroupData;
import com.example.utils.*;

public class GroupHelper extends WebDriverHelperBase {
	   
	    public GroupHelper(ApplicationManager manager) {
		super(manager);
		}

public GroupHelper createGroup(GroupData group) {
     	manager.navigateTO().gotoPage("groups");
    	newGroupCreation();
    	fillGroupForm(group);
        submitForm();
    	manager.navigateTO().gotoPage("group page");
    	//rebuild model 
    	manager.getApplicationModel().addGroup(group);
 //   	rebuildCacheGroups();
    	return this;
		
	}
	

public GroupHelper modifyGroup(GroupData group, int index) {
		initmodifygroupe(index);
		fillGroupForm(group);
		submitGroupForm();
		manager.navigateTO().gotoPage("group page");
    	manager.getApplicationModel().removeGroup(index).addGroup(group);
//		rebuildCacheGroups();
		return this;
	}	
	
public GroupHelper deletegroupe(int index) {
		selectGroupeByIndex(index);
		submitGroupDelete();
//		cachedGroups = null;
		manager.navigateTO().gotoPage("group page");
		manager.getApplicationModel().removeGroup(index);
//		rebuildCacheGroups();
		return this;
		
	}

//private SortedListOf<GroupData> cachedGroups;

//public SortedListOf<GroupData> GetGroups() {
//	 
//	    if (cachedGroups == null){
//	    rebuildCacheGroups();
//	    } 
//	    return new SortedListOf<GroupData>(cachedGroups);
		
//	}
//private void rebuildCacheGroups() {
public SortedListOf<GroupData> getUiGroups() {
//	    cachedGroups =  new SortedListOf<GroupData>();
        SortedListOf<GroupData> groups = new SortedListOf<GroupData>();
		manager.navigateTO().gotoPage("groups");
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String groupname=   title.substring("Select (".length(), title.length() - ")".length());
			groupname =  replaceNullOrEmpty(groupname);
//			group.groupname =   title.substring("Select (".length(), title.length() - ")".length());
//			group.groupname =  replaceNull(group.groupname);
	        groups.add(new GroupData().withGroupName(groupname));
			
		}
		
		return groups;
		
}

//------------------------------------------------------отделяем высокоуровневые методы для читаемости


   private GroupHelper submitGroupDelete() {
	    click(By.name("delete"));
//	    cachedGroups = null;
	    return this;
}	


	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getGroupname());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;	    	 
	}

	public GroupHelper newGroupCreation() {
		click(By.name("new"));
		return this;
	}



	private GroupHelper selectGroupeByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+(index+1)+"]"));
		return this;
	}

	public GroupHelper initmodifygroupe(int index) {
		selectGroupeByIndex(index);
		click(By.name("edit"));
		return this;
		
	}

	public GroupHelper submitGroupForm() {
		click(By.name("update"));
//		cachedGroups = null;
		return this;
	}


	public GroupHelper submitForm() {
		driver.findElement(By.name("submit")).click();
//		cachedGroups = null;
		return this;
	}



	

   

}

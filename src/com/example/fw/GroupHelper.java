package com.example.fw;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.GroupDate;
import com.example.utils.*;

public class GroupHelper extends HelperBase {
	   
	    public GroupHelper(ApplicationManager manager) {
		super(manager);
		}

public GroupHelper createGroup(GroupDate group) {
     	manager.navigateTO().gotoPage("groups");
    	newGroupCreation();
    	fillGroupForm(group);
        submitForm();
    	manager.navigateTO().gotoPage("group page");
    	rebuildCache();
    	return this;
		
	}
	

public GroupHelper modifyGroup(GroupDate group, int index) {
		initmodifygroupe(index);
		fillGroupForm(group);
		submitGroupForm();
		manager.navigateTO().gotoPage("group page");
		rebuildCache();
		return this;
	}	
	
public GroupHelper deletegroupe(int index) {
		selectGroupeByIndex(index);
		submitGroupDelete();
		manager.navigateTO().gotoPage("group page");
		rebuildCache();
		return this;
		
	}

private SortedListOf<GroupDate> cachedGroups;

public SortedListOf<GroupDate> GetGroups() {
	 
	    if (cachedGroups == null){
	    rebuildCache();
	    } 
	    return new SortedListOf<GroupDate>(cachedGroups);
		
	}
private void rebuildCache() {
 
	    cachedGroups =  new SortedListOf<GroupDate>();
		manager.navigateTO().gotoPage("groups");
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String groupname=   title.substring("Select (".length(), title.length() - ")".length());
			groupname =  replaceNullOrEmpty(groupname);
//			group.groupname =   title.substring("Select (".length(), title.length() - ")".length());
//			group.groupname =  replaceNull(group.groupname);
	        cachedGroups.add(new GroupDate().withGroupName(groupname));
			
		}
	
}

//------------------------------------------------------отделяем высокоуровневые методы для читаемости


   private GroupHelper submitGroupDelete() {
	    click(By.name("delete"));
	    cachedGroups = null;
	    return this;
}	


	public GroupHelper fillGroupForm(GroupDate group) {
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
		cachedGroups = null;
		return this;
	}


	public GroupHelper submitForm() {
		driver.findElement(By.name("submit")).click();
		cachedGroups = null;
		return this;
	}

	


	

   

}

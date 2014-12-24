package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupeRemoveTest extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void deleteGroup(GroupDate group) {
        app.getNavigationHelper().GetUrl(app);
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoPage("groups");
	    // save old
	    
	    List<GroupDate> oldList = app.getGroupHelper().GetGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
		app.getGroupHelper().deletegroupe(index);
	    app.getNavigationHelper().returnPage("group page");
	    
	    List<GroupDate>  newlist= app.getGroupHelper().GetGroups();     
  	    
    //	assertEquals(newlist.size(),oldList.size()-1);      
        oldList.remove(index);
        Collections.sort(oldList);
        Collections.sort(newlist);
        assertEquals(newlist, oldList);
	    
	    
	}
	
}

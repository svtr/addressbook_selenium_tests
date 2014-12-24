package com.example.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;


import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

@Test(dataProvider = "randomValidGroupGenerator")
public class GroupeMidifyTest extends TestBase{

	       
        public void modifyGroup(GroupDate group) {
        	app.getNavigationHelper().GetUrl(app);
      		app.getNavigationHelper().openMainPage();
      	    app.getNavigationHelper().gotoPage("groups");
      	    //save old
            List<GroupDate> oldList = app.getGroupHelper().GetGroups();
            Random rnd = new Random();
    	    int index = rnd.nextInt(oldList.size()-1);
            
      		app.getGroupHelper().initmodifygroupe(index);
//      		GroupDate group = new GroupDate();
//      		group.groupname = "new name";
//      		app.getGroupHelper().fillGropForm(group);
      		app.getGroupHelper().submitGroupFirm();	
      	    app.getNavigationHelper().returnPage("group page");
      	    
      	    //save new list
      	 List<GroupDate>  newlist= app.getGroupHelper().GetGroups();     
      	    
      	  AssertJUnit.assertEquals(newlist.size(),oldList.size());      
          oldList.remove(index);
          oldList.add(group);
          Collections.sort(oldList);
          AssertJUnit.assertEquals(oldList, newlist);

	    }

}
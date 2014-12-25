package com.example.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import java.util.Random;



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
//      	GroupDate group = new GroupDate();
//      	group.groupname = "new name";
         	app.getGroupHelper().fillGropForm(group);
      		app.getGroupHelper().submitGroupForm();	
      	    app.getNavigationHelper().returnPage("group page");
   	    
      	    //save new list
            List<GroupDate>  newlist= app.getGroupHelper().GetGroups();     
            oldList.remove(index);
            oldList.add(group);
            Collections.sort(oldList);
            assertEquals(newlist, oldList);

	    }

}
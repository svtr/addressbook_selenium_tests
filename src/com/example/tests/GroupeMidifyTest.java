package com.example.tests;

import org.testng.annotations.Test;
import java.util.Random;
import com.example.utils.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@Test(dataProvider = "groupsFromFile")
public class GroupeMidifyTest extends TestBase{
	
   
         public void modifyGroup(GroupData group) {
//        	app.navigateTO().mainPage().gotoPage("groups");
//    		//save old
//   	    int index = rnd.nextInt(oldList.size()-1);
//          
//  	    app.getGroupHelper().modifyGroup(group, index);
//
//  	    //save new list
//          SortedListOf<GroupData>  newlist= app.getGroupHelper().getUiGroups();    
//          //compare
//          assertThat(newlist, equalTo(oldList.without(index).withAdded(group)));
      Random rnd = new Random();
	  SortedListOf<GroupData> oldList = app.getApplicationModel().getGroups();
      int index = rnd.nextInt(oldList.size()-1);
	  app.getGroupHelper().modifyGroup(group, index);
     
      
      SortedListOf<GroupData>  newlist= app.getApplicationModel().getGroups();    
 
	  
	  if("yes".equals(app.getProperty("check.db"))) {
		  if (wantToCheck()) {
		  assertThat(app.getApplicationModel().getGroups(),equalTo(app.getHibernateHelper().listGroups()));
		  }
	  }
	  
	  if("yes".equals(app.getProperty("check.ui"))) {
		  if (wantToCheck()) {
		  assertThat(app.getApplicationModel().getGroups(),equalTo(app.getGroupHelper().getUiGroups()));
		  }
	  }
	  
	  
   
  }

	


}
package com.example.tests;

import org.testng.annotations.Test;

import com.example.utils.*;
import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


public class GroupeCreationTests extends TestBase{
	
  	
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationwithValidData(GroupDate group) throws Exception {
//      app.navigateTO().mainPage();
//      app.navigateTO().gotoPage("groups");
	   //save old
      SortedListOf<GroupDate> oldList = app.getGroupHelper().GetGroups();

      app.getGroupHelper().createGroup(group);
     
      
      SortedListOf<GroupDate>  newlist= app.getGroupHelper().GetGroups();      
 
      assertEquals(newlist.size(),oldList.size()+1);
	  assertThat(newlist, equalTo(oldList.withAdded(group)));
   
  }

 
}

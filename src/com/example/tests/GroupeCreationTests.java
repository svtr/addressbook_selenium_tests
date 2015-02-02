package com.example.tests;

import java.io.File;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.*;

//import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


public class GroupeCreationTests extends TestBase{

	
	
	



@Test(dataProvider = "groupsFromFile")
  public void testGroupCreationwithValidData(GroupData group) throws Exception {
//      app.navigateTO().mainPage();
//      app.navigateTO().gotoPage("groups");
	   //save old
      SortedListOf<GroupData> oldList = app.getApplicationModel().getGroups();

      app.getGroupHelper().createGroup(group);
     
      
      SortedListOf<GroupData>  newlist= app.getApplicationModel().getGroups();    
 
      assertEquals(newlist.size(),oldList.size()+1);
	  assertThat(newlist, equalTo(oldList.withAdded(group)));
	  assertThat(app.getApplicationModel().getGroups(),equalTo(app.getHibernateHelper().listGroups()));
	  assertThat(app.getApplicationModel().getGroups(),equalTo(app.getGroupHelper().getUiGroups()));
   
  }

 
}

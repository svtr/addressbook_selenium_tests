package com.example.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


import java.util.Collections;

import java.util.List;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


public class GroupeCreationTests extends TestBase{
	

	
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationwithValidData(GroupDate group) throws Exception {
      app.getNavigationHelper().GetUrl(app);
	  app.getNavigationHelper().openMainPage();
      app.getNavigationHelper().gotoPage("groups");
      //save old
      List<GroupDate> oldList = app.getGroupHelper().GetGroups();
   
      app.getGroupHelper().newGropCreation();
// не нужно так как добавлен public Iterator<Object[]> randomValidGroupGenerator(){
//      GroupDate group = new GroupDate();
//      group.groupname = "groupe name 1";
//      group.header = "groupe header 1";
//      group.footer ="footer 1";		  
	  app.getGroupHelper().fillGropForm(group);
      app.getNavigationHelper().submitForm();

      app.getNavigationHelper().returnPage("group page");
      List<GroupDate>  newlist= app.getGroupHelper().GetGroups();      
 
      assertEquals(newlist.size(),oldList.size()+1); 
      oldList.add(group);
      Collections.sort(oldList);
      Collections.sort(newlist);
      assertEquals(newlist, oldList);
     
      
      
     
      
  }

 
}

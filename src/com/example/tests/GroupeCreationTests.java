package com.example.tests;

import org.testng.annotations.Test;


public class GroupeCreationTests extends TestBase{
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
      app.getNavigationHelper().GetUrl(app);
	  app.getNavigationHelper().openMainPage();
      app.getNavigationHelper().gotoPage("groups");
      app.getGroupHelper().newGropCreation();
      GroupDate group = new GroupDate();
      group.groupname = "groupe name 1";
      group.header = "groupe header 1";
      group.footer ="footer 1";		  
	  app.getGroupHelper().fillGropForm(group);
      app.getNavigationHelper().submitForm();
      app.getNavigationHelper().returnPage("group page");
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
          app.getNavigationHelper().GetUrl(app);
		  app.getNavigationHelper().openMainPage();
	      app.getNavigationHelper().gotoPage("groups");
	      app.getGroupHelper().newGropCreation();
	      app.getGroupHelper().fillGropForm(new GroupDate(" ", " ", " "));
	      app.getNavigationHelper().submitForm();
	      app.getNavigationHelper().returnPage("group page");
	  }
}

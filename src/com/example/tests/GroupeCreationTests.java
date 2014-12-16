package com.example.tests;

import org.testng.annotations.Test;


public class GroupeCreationTests extends TestBase{
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
      app.GetUrl();
	  app.openMainPage();
      app.gotoPage("groups");
      app.newGropCreation();
      GroupDate group = new GroupDate();
      group.groupname = "groupe name 1";
      group.header = "groupe header 1";
      group.footer ="footer 1";		  
	  app.fillGropForm(this, group);
      app.submitForm();
      app.returnPage("group page");
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
          app.GetUrl();
		  app.openMainPage();
	      app.gotoPage("groups");
	      app.newGropCreation();
	      app.fillGropForm(this, new GroupDate(" ", " ", " "));
	      app.submitForm();
	      app.returnPage("group page");
	  }
}

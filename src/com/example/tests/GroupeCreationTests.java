package com.example.tests;

import org.testng.annotations.Test;


public class GroupeCreationTests extends TestBase{
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
      app.navigationhelper.GetUrl(app);
	  app.navigationhelper.openMainPage();
      app.navigationhelper.gotoPage("groups");
      app.grouphelper.newGropCreation();
      GroupDate group = new GroupDate();
      group.groupname = "groupe name 1";
      group.header = "groupe header 1";
      group.footer ="footer 1";		  
	  app.grouphelper.fillGropForm(group);
      app.navigationhelper.submitForm();
      app.navigationhelper.returnPage("group page");
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
          app.navigationhelper.GetUrl(app);
		  app.navigationhelper.openMainPage();
	      app.navigationhelper.gotoPage("groups");
	      app.grouphelper.newGropCreation();
	      app.grouphelper.fillGropForm(new GroupDate(" ", " ", " "));
	      app.navigationhelper.submitForm();
	      app.navigationhelper.returnPage("group page");
	  }
}

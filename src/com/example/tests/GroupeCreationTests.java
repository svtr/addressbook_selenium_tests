package com.example.tests;

import org.testng.annotations.Test;


public class GroupeCreationTests extends TestBase{
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    driver.get(baseUrl + "/");
	  openMainPage();
      gotoPage("groups");
      newGropCreation();
      GroupDate group = new GroupDate();
      group.groupname = "groupe name 1";
      group.header = "groupe header 1";
      group.footer ="footer 1";		  
	  fillGropForm(group);
      submitForm();
      returnPage("group page");
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
	    driver.get(baseUrl + "/");
		  openMainPage();
	      gotoPage("groups");
	      newGropCreation();
	      fillGropForm(new GroupDate(" ", " ", " "));
	      submitForm();
	      returnPage("group page");
	  }
}

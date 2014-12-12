package com.example.tests;

import org.testng.annotations.Test;


public class AdressCreateTest extends TestBase{
  @Test
  public void testNonEmptyGPhoneCreation() throws Exception {
    driver.get(baseUrl + "/");
	  openMainPage();
      gotoPage("add new");
      newGropCreation();
      GroupDate group = new GroupDate();
      group.groupname = "groupe name 1";
      group.header = "groupe header 1";
      group.footer ="footer 1";		  
	fillGropForm(group);
      submitGroupForm();
      returnGroupPage();
  }

  @Test
  public void testEmptyPhoneCreation() throws Exception {
	    driver.get(baseUrl + "/");
		  openMainPage();
	      gotoPage("add new");
	      newGropCreation();
	      fillGropForm(new GroupDate(" ", " ", " "));
	      submitGroupForm();
	      returnGroupPage();
	  }
}

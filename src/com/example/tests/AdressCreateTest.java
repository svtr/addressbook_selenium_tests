package com.example.tests;

import org.testng.annotations.Test;




public class AdressCreateTest extends TestBase{
  @Test
  public void testNonEmptyPhoneCreation() throws Exception {
    
	  app.navigationhelper.GetUrl(app);
	  app.navigationhelper.openMainPage();
      app.navigationhelper.gotoPage("add new");
      AddressDate addr = new AddressDate();
      addr.fname = "Ivan";
	  addr.lastname = "Ivanov";
	  addr.address = "Spb";
      addr.home = "";
	  addr.mobile = "89211111111";
	  addr.work = "89211111111";
	  addr.email = "my@mail.ru";
	  addr.email2 = "my2@mail.ru";
	  addr.bday = "1";
	  addr.bmonth = "January";
	  addr.byear = "1980";
	  addr.groupdate = "group1";
	  addr.address2 = "address";
	  addr.phone2 = "phone2";

      app.adresshelper.fillFormAddress(addr);
      app.navigationhelper.submitForm();
      app.navigationhelper.returnPage("home page");
  }
  
  
  
  

  @Test
  public void testEmptyPhoneCreation() throws Exception {
	      app.navigationhelper.GetUrl(app);
		  app.navigationhelper.openMainPage();
		  app.navigationhelper.gotoPage("add new");
	      app.adresshelper.fillFormAddress(new AddressDate(" ", " ", " "," ", " ", " "," ", " "," " ," ", " ", " "," ", " "));
	      app.navigationhelper.submitForm();
	      app.navigationhelper.returnPage("home page");
	  }
}

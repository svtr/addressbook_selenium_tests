package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import com.example.utils.*;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;


public class AdressCreateTest extends TestBase{
 
  @Test(dataProvider = "randomValidAddressGenerator")
  public void testAddressCreationwithValidData(AddressDate address) throws Exception {
    
      //save old list
	  SortedListOf<AddressDate> oldList = app.getAddressHelper().GetAddress();
	  //action
      app.getAddressHelper().createAddress(address);
      //save new list
      SortedListOf<AddressDate> newList = app.getAddressHelper().GetAddress();
      //compare
 	  assertThat(newList, equalTo(oldList.withAdded(address)));
  }
  
  
  
  

  //@Test
  //public void testEmptyPhoneCreation() throws Exception {
//	      app.navigateTO().GetUrl(app);
//		  app.navigateTO().mainPage();
//		  app.navigateTO().gotoPage("add new");
//		  
//	      app.getAddressHelper().fillFormAddress(new AddressDate(" ", " ", " "," ", " ", " "," ", " "," " ," ", " ", " "," ", " "),CREATION);
//	      app.navigateTO().submitForm();
//	      app.navigateTO().returnPage("home page");
//	  }
}

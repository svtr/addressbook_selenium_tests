package com.example.tests;


import static org.hamcrest.Matchers.equalTo;


import com.example.utils.*;


import org.testng.annotations.Test;

import static org.junit.Assert.assertThat;


public class AdressCreateTest extends TestBase{
	
	

 
  @Test(dataProvider = "addressFromFile")
  public void testAddressCreationwithValidData(AddressDate address) throws Exception {
    
      //save old list
	  SortedListOf<AddressDate> oldList = app.getAddressHelper().GetContacts();
	  //action
      app.getAddressHelper().createAddress(address);
      //save new list
      SortedListOf<AddressDate> newList = app.getAddressHelper().GetContacts();
      //compare
 	  assertThat(newList, equalTo(oldList.withAdded(address)));
  }
  
  
  
  
}
 
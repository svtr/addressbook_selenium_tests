package com.example.tests;


import static org.hamcrest.Matchers.equalTo;


import com.example.utils.*;


import org.testng.annotations.Test;

import static org.junit.Assert.assertThat;


public class AddressCreateTest extends TestBase{
	
	

 
  @Test(dataProvider = "addressFromFile")
  public void testAddressCreationwithValidData(AddressData address) throws Exception {
    
      //save old list
	  SortedListOf<AddressData> oldList = app.getAddressHelper().GetContacts();
	  //action
      app.getAddressHelper().createAddress(address);
      //save new list
      SortedListOf<AddressData> newList = app.getAddressHelper().GetContacts();
      //compare
 	  assertThat(newList, equalTo(oldList.withAdded(address)));
  }
  
  
  
  
}
 
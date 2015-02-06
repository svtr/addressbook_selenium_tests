package com.example.tests;


import static org.hamcrest.Matchers.equalTo;


import com.example.utils.*;


import org.testng.annotations.Test;

import static org.junit.Assert.assertThat;


public class AddressCreateTest extends TestBase{
	
	

 
  @Test(dataProvider = "addressFromFile")
  public void testAddressCreationwithValidData(AddressData address) throws Exception {
    
      //save old list
	  SortedListOf<AddressData> oldList = app.getApplicationModel().getAddress();
      //create address from interface
      app.getAddressHelper().createAddress(address);
      //save new list
      SortedListOf<AddressData> newList = app.getApplicationModel().getAddress();


  
 	  
	  if("yes".equals(app.getProperty("check.db"))) {
		  if (wantToCheck()) {
		  assertThat(app.getApplicationModel().getAddress(),equalTo(app.getHibernateHelper().listAddress()));
		  }
	  }
	  
	  if("yes".equals(app.getProperty("check.ui"))) {
		  if (wantToCheck()) {
		  assertThat(app.getApplicationModel().getAddress(),equalTo(app.getAddressHelper().getUiAddress()));
		  }
	  }
  }
  
  
  
  
}
 
package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class AddressRemoveTest extends TestBase{

	
	 @Test(dataProvider = "addressFromFile")
    	public void deleteAddress(AddressDate address) {
        

		
		SortedListOf<AddressDate> oldList = app.getAddressHelper().GetContacts();
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		
		
	    app.getAddressHelper().deleteAddress(index);

	    SortedListOf<AddressDate>  newList= app.getAddressHelper().GetContacts();    
  	    assertThat(newList, equalTo(oldList.without(index)));
  	   
	  
	}
}

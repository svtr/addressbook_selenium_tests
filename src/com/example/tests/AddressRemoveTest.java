package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class AddressRemoveTest extends TestBase{

	
	 @Test(dataProvider = "addressFromFile")
    	public void deleteAddress(AddressData address) {
        

		
		SortedListOf<AddressData> oldList = app.getAddressHelper().getUiAddress();
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		
		
	    app.getAddressHelper().deleteAddress(index);

	    SortedListOf<AddressData>  newList= app.getAddressHelper().getUiAddress();    
  	    assertThat(newList, equalTo(oldList.without(index)));
  	   
	  
	}
}

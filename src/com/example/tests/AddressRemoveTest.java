package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class AddressRemoveTest extends TestBase{

	
	 @Test(dataProvider = "randomValidAddressGenerator")
    	public void deleteAddress(AddressDate address) {
        
//		app.navigateTO().GetUrl(app).mainPage();
		
		SortedListOf<AddressDate> oldList = app.getAddressHelper().GetAddress();
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		
		
	    app.getAddressHelper().deleteAddress(index);

	    SortedListOf<AddressDate>  newList= app.getAddressHelper().GetAddress();    
    //	assertEquals(newlist.size(),oldList.size()-1);      
	//    oldList.remove(index);
	//   Collections.sort(oldList);
	//    Collections.sort(newList);
	//    assertEquals(newList, oldList);
  	     assertThat(newList, equalTo(oldList.without(index)));
	    
	  
	}
}

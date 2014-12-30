package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class AddressRemoveTest extends TestBase{

	
	 @Test(dataProvider = "randomValidAddressGenerator")
    	public void deleteAddress(AddressDate address) {
        
		app.getNavigationHelper().GetUrl(app);
		app.getNavigationHelper().openMainPage();
		
		List<AddressDate> oldList = app.getAddressHelper().GetAddress();
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-2);
		
		
	    app.getAddressHelper().deleteAddress(index);
	    app.getNavigationHelper().returnPage("home page");
	    List<AddressDate>  newList= app.getAddressHelper().GetAddress();    
    //	assertEquals(newlist.size(),oldList.size()-1);      
	    oldList.remove(index);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	    
	  
	}
}

package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;


public class AddressModifyTest extends TestBase{

	@Test(dataProvider = "randomValidAddressGenerator")
	public void modifyAddress(AddressDate address) throws Exception{
	
    app.getNavigationHelper().GetUrl(app);
	app.getNavigationHelper().openMainPage();
	
	 //save old list
	List<AddressDate> oldList = app.getAddressHelper().GetAddress();
	Random rnd = new Random();
	int index = rnd.nextInt(oldList.size()-1);
	  
	app.getAddressHelper().initmodifyaddress(index);
	app.getAddressHelper().fillFormAddress(address);
	app.getAddressHelper().updateAddressForm();
	app.getNavigationHelper().returnPage("home page");	
	
	
	 //save new list
	List<AddressDate> newList = app.getAddressHelper().GetAddress();
	oldList.remove(index);
    oldList.add(address);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);

	}
	
	
}

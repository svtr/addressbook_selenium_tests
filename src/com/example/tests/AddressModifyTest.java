package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;
import static com.example.fw.AddressHelper.CREATION;
import static com.example.fw.AddressHelper.MODIFICATION;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;


public class AddressModifyTest extends TestBase{

	@Test(dataProvider = "randomValidAddressGenerator")
	public void modifyAddress(AddressDate address) throws Exception{
	
//    app.navigateTO().GetUrl(app).mainPage();
	
	 //save old list
	SortedListOf<AddressDate> oldList = app.getAddressHelper().GetAddress();
	Random rnd = new Random();
	int index = rnd.nextInt(oldList.size()-1);
	app.getAddressHelper().modifyAddress(index,address);  
//	app.getAddressHelper()
//	.initmodifyaddress(index)
//	.fillFormAddress(address, MODIFICATION);
//	app.getAddressHelper().updateAddressForm();
	
//	app.getAddressHelper().updateAddressForm();
//	app.navigateTO().returnPage("home page");	
	
	
	 //save new list
	SortedListOf<AddressDate> newList = app.getAddressHelper().GetAddress();
	
    assertThat(newList, equalTo(oldList.without(index).withAdded(address)));

	}
	
	
}

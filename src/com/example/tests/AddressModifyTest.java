package com.example.tests;

import org.testng.annotations.Test;

public class AddressModifyTest extends TestBase{

	@Test	
	public void modifyAddress() {
	
    app.getNavigationHelper().GetUrl(app);
	app.getNavigationHelper().openMainPage();
	app.getAddressHelper().initmodifyaddress(8);
	AddressDate address = new AddressDate();
	address.fname = "new name";
	app.getAddressHelper().fillFormAddress(address);
    app.getAddressHelper().updateGroupForm();	
	app.getNavigationHelper().returnPage("home page");

	}
	
	
}

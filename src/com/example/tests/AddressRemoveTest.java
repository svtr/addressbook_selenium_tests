package com.example.tests;

import org.testng.annotations.Test;

public class AddressRemoveTest extends TestBase{

	
	@Test
	public void deleteAddress() {
        app.getNavigationHelper().GetUrl(app);
		app.getNavigationHelper().openMainPage();
	    app.getAddressHelper().deleteAddress(8);
	  
	}
}

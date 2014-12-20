package com.example.tests;

import org.testng.annotations.Test;

public class GroupeRemoveTest extends TestBase {

	@Test
	public void deleteGroup() {
        app.getNavigationHelper().GetUrl(app);
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoPage("groups");
		app.getGroupHelper().deletegroupe(1);
	    app.getNavigationHelper().returnPage("group page");
	}
	
}

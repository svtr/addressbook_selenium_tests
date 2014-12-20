package com.example.tests;

import org.testng.annotations.Test;

public class GroupeMidifyTest extends TestBase{

	       
        @Test	
	    public void modifyGroup() {
        	  app.getNavigationHelper().GetUrl(app);
      		app.getNavigationHelper().openMainPage();
      	    app.getNavigationHelper().gotoPage("groups");
      		app.getGroupHelper().initmodifygroupe(1);
      		GroupDate group = new GroupDate();
      		group.groupname = "new name";
      		app.getGroupHelper().fillGropForm(group);
      		app.getGroupHelper().submitGroupFirm();	
      	    app.getNavigationHelper().returnPage("group page");

	    }

}
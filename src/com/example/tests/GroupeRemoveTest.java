package com.example.tests;


import java.util.Random;
import com.example.utils.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

public class GroupeRemoveTest extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void deleteGroup(GroupDate group) {
//        app.navigateTO().mainPage().gotoPage("groups");
		
	    // save old
	    
	    SortedListOf<GroupDate> oldList = app.getGroupHelper().GetGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
		app.getGroupHelper().deletegroupe(index);
	    
	    SortedListOf<GroupDate>  newlist= app.getGroupHelper().GetGroups();     
  	    assertThat(newlist, equalTo(oldList.without(index)));
//        oldList.remove(index);
//        Collections.sort(oldList);
//        Collections.sort(newlist);
//        assertEquals(newlist, oldList);
	    
	    
	}
	
}

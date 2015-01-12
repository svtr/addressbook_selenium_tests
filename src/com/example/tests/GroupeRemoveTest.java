package com.example.tests;


import java.util.Random;
import com.example.utils.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

public class GroupeRemoveTest extends TestBase {

	@Test(dataProvider = "groupsFromFile")
	public void deleteGroup(GroupDate group) {
		
	    // save old
         SortedListOf<GroupDate> oldList = app.getGroupHelper().GetGroups();
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
    	app.getGroupHelper().deletegroupe(index);
	    SortedListOf<GroupDate>  newlist= app.getGroupHelper().GetGroups();     
  	    assertThat(newlist, equalTo(oldList.without(index)));

	    
	    
	}
	
}

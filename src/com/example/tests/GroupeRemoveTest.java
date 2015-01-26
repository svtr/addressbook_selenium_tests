package com.example.tests;


import java.util.Random;
import com.example.utils.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

public class GroupeRemoveTest extends TestBase {

	@Test(dataProvider = "groupsFromFile")
	public void deleteGroup(GroupData group) {
		
	    // save old
         SortedListOf<GroupData> oldList = app.getGroupHelper().GetGroups();
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
    	app.getGroupHelper().deletegroupe(index);
	    SortedListOf<GroupData>  newlist= app.getGroupHelper().GetGroups();     
  	    assertThat(newlist, equalTo(oldList.without(index)));

	    
	    
	}
	
}

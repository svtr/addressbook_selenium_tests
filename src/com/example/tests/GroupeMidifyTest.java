package com.example.tests;

import org.testng.annotations.Test;


import java.util.Random;

import com.example.utils.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;



@Test(dataProvider = "groupsFromFile")
public class GroupeMidifyTest extends TestBase{

	       
        public void modifyGroup(GroupData group) {
//        	app.navigateTO().mainPage().gotoPage("groups");
      		//save old
            SortedListOf<GroupData> oldList = app.getGroupHelper().GetGroups();
            Random rnd = new Random();
    	    int index = rnd.nextInt(oldList.size()-1);
            
    	    app.getGroupHelper().modifyGroup(group, index);

    	    //save new list
            SortedListOf<GroupData>  newlist= app.getGroupHelper().GetGroups();    
            //compare
            assertThat(newlist, equalTo(oldList.without(index).withAdded(group)));

	    }

}
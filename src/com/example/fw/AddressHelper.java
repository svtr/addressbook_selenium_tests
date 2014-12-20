package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.AddressDate;
//import com.example.tests.TestBase;

public class AddressHelper extends HelperBase{
	
	    public AddressHelper(ApplicationManager manager) {
		super(manager);
		}

	public void fillFormAddress(AddressDate addr) { 
		
		type(By.name("firstname"), addr.fname);
		type(By.name("lastname"), addr.lastname);
		type(By.name("address"), addr.address);
		type(By.name("home"), addr.home);
		type(By.name("mobile"), addr.mobile);
		type(By.name("work"), addr.work);
		type(By.name("email"), addr.email);
		type(By.name("email2"), addr.email2);

	    //Select sel = new Select(manager.driver.findElement(By.name("bday")));
	  
		if  (addr.bday != " ")
	    { 		
	   
		selectByText(addr.bday, By.name("bday"));
	    }
	   
	    if (addr.bmonth != " ")
	    {	
    	selectByText(addr.bmonth, By.name("bmonth"));	

	    }   
	  
	    type(By.name("byear"), addr.byear);

	//	    if (addr.group != " ")
	//	    {
	    // type(By.name("new_group"), addr.group); 
	    //}
	    type(By.name("address2"), addr.address2);
	    type(By.name("phone2"), addr.phone2);
	   
	
	
	}


}

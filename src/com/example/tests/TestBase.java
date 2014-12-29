package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
//import org.apache.bcel.generic.Select;




public class TestBase {
     
	public static ApplicationManager app;



	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	   
	  }
	


	@AfterTest
	public void tearDown() throws Exception {
	app.stop();
	   
	  }
	
	
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		
	List<Object[]> list =  new ArrayList<Object[]>();
	
	for (int i = 0; i<5; i++)
	{
		GroupDate group = new GroupDate();
		
		 group.groupname = generateRandomString();
	     group.header = generateRandomString();
         group.footer =generateRandomString();
         list.add(new Object[]{group});
		
	}
	
	
	//....
	return list.iterator();
		
	}
	
	
	
	@DataProvider
	public Iterator<Object[]> randomValidAddressGenerator(){
		
	List<Object[]> list =  new ArrayList<Object[]>();
	
	for (int i = 0; i<1; i++)
	{
		 AddressDate address = new AddressDate();
		 address.lastname =  generateRandomString();
		 address.fname =  generateRandomString();
         address.address =  generateRandomString();
	     address.home =  generateRandomString();
		 address.mobile =  generateRandomString();
		 address.work =  generateRandomString();
		 address.email =  generateRandomString();
		 address.email2 =  generateRandomString();
		 address.bday = "1";
		 address.bmonth = "January";
		 address.byear = "1980";
		 address.groupdate = "group1";
		 address.address2 =  generateRandomString();
		 address.phone2 =  generateRandomString();
         list.add(new Object[]{address});
		
	}
	
	
	//....
	return list.iterator();
		
	}
	

	
	
	public String generateRandomString()
	{
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0)
		{
			return " ";
			
		}	else  
			return "test" + rnd.nextInt();
	}

}

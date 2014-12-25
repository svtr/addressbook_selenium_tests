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
	
	for (int i = 0; i<2; i++)
	{
		 AddressDate addr = new AddressDate();
		 addr.fname =  generateRandomString();
	     addr.lastname =  generateRandomString();
		 addr.address =  generateRandomString();
	     addr.home =  generateRandomString();
		 addr.mobile =  generateRandomString();
		 addr.work =  generateRandomString();
		 addr.email =  generateRandomString();
		 addr.email2 =  generateRandomString();
		 addr.bday = "1";
		 addr.bmonth = "January";
		 addr.byear = "1980";
		 addr.groupdate = "group1";
		 addr.address2 =  generateRandomString();
		 addr.phone2 =  generateRandomString();
         list.add(new Object[]{addr});
		
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

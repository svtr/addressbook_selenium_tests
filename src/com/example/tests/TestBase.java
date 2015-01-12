package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.GroupDataGenerator.generateRandomString;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;

import static com.example.tests.AddressDataGenerator.generateRandomAddress;
import static com.example.tests.AddressDataGenerator.loadAddressFromCsvFile;
import static com.example.tests.AddressDataGenerator.loadAddressFromXmlFile;
import static com.example.fw.ApplicationManager.formattext;

//import org.apache.bcel.generic.Select;




public class TestBase {
     
	public static ApplicationManager app;


	@BeforeTest
	public void setUp() throws Exception {
		Properties properties = new Properties();
		properties.load(new FileReader(new File ("test.properties")));
		app = new ApplicationManager(properties);
   
	  }
	


	@AfterTest
	public void tearDown() throws Exception {
	app.stop();
	   
	  }
	
	
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
	//....
	return wrapGroupDateForProvider(generateRandomGroups(5)).iterator();
		
	}
	
	
	
	protected List<Object[]> wrapGroupDateForProvider(List<GroupDate> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupDate group :groups) {
			list.add(new Object[]{group});
		}
		return list;
	}



	@DataProvider
	public Iterator<Object[]> randomValidAddressGenerator(){
	return wrapAddressDateForProvider(generateRandomAddress(5)).iterator();	
	}
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws Exception {
	//
    if (formattext.equals("xml") ){
	return wrapGroupDateForProvider(loadGroupsFromXmlFile(new File ("group.xml"))).iterator();
	}else if  (formattext.equals("csv")){
	return wrapGroupDateForProvider(loadGroupsFromCsvFile(new File ("group.txt"))).iterator();
	} else 	return wrapGroupDateForProvider(loadGroupsFromXmlFile(new File ("group.xml"))).iterator();
    
	}
	
	
	@DataProvider
	public Iterator<Object[]> addressFromFile() throws Exception {
	if (formattext.equals("xml")){
	return wrapAddressDateForProvider(loadAddressFromXmlFile(new File ("address.xml"))).iterator();
	}else if  (formattext.equals("csv")){
	return wrapAddressDateForProvider(loadAddressFromCsvFile(new File ("address.txt"))).iterator();	
	}else return wrapAddressDateForProvider(loadAddressFromXmlFile(new File ("address.xml"))).iterator();
	}
	
	protected List<Object[]> wrapAddressDateForProvider(List<AddressDate> address) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (AddressDate adr :address) {
			list.add(new Object[]{adr});
		}
		return list;
	}
		
//	List<Object[]> list =  new ArrayList<Object[]>();
	
//	for (int i = 0; i<5; i++)
//	{
//		 AddressDate address = new AddressDate()
//		 .withLastName (generateRandomString()) +
//		 .withFname(generateRandomString()) +
//		 .withAddress(generateRandomString()) +
//		 .withHome(generateRandomString()) +
//		 .withMobile(generateRandomString()) +
//		 .withWork(generateRandomString()) +
//		 .withEmail(generateRandomString()) +
//		 .withEmail2(generateRandomString()) +
//		 .withbDay("1")
//		 .withbMounth("January")
//		 .withbYear("1980")
//		 .withGroupDate("group1")
//		 .withAddress2(generateRandomString()) +
//		 .withPhone2(generateRandomString());
//		 address.lastname =  generateRandomString();
//		 address.fname =  generateRandomString();
//         address.address =  generateRandomString();
//	     address.home =  generateRandomString();
//		 address.mobile =  generateRandomString();
//		 address.work =  generateRandomString();
//		 address.email =  generateRandomString();
//		 address.email2 =  generateRandomString();
//		 address.bday = "1";
//		 address.bmonth = "January";
//		 address.byear = "1980";
//       address.groupdate = "group1";
//		 address.address2 =  generateRandomString();
//		 address.phone2 =  generateRandomString();
 //        list.add(new Object[]{address});
		
//	}
	
	
	//....
//	return list.iterator();
		
	

	
	
	

}

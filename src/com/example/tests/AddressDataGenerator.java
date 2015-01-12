package com.example.tests;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import com.thoughtworks.xstream.XStream;

public class AddressDataGenerator {
	
	
	

	public static void main(String[] args) throws IOException {
		if (args.length<3){
			System.out.println("Need 3 parametrs : amount, file, format");
			return;
		}
     int amount = Integer.parseInt(args[0]);
     File  file = new File(args[1]);
     String format = args[2];
     
     List<AddressDate> address = generateRandomAddress(amount);
     if ("csv".equals(format)){
    	 saveAddressToCsvFile(address,file);
     } else if ("xml".equals(format)) {
    	 saveAddressToXmlFile(address,file);
     } else { 
    	 System.out.println("Format only csv or xml");
    	 return;
     }
    	 
	}

  	
    public static List<AddressDate> loadAddressFromCsvFile(File file) throws IOException {
    	List<AddressDate> list =  new ArrayList<AddressDate>();
    	FileReader reader = new FileReader(file);
    	BufferedReader bufferedreader = new BufferedReader(reader);
    	String line = bufferedreader.readLine();
    	while (line != null) {
		    String[] part = line.split(",");
		  
       		AddressDate address = new AddressDate()
    		.withLastName(part[0])
    		.withFname(part[1])
    		.withAddress(part[2])
    		.withHome(part[3])
    		.withMobile(part[4])
    		.withWork(part[5])
    		.withEmail(part[6])
    		.withEmail2(part[7])
    		.withbDay(part[8])
		    .withbMounth(part[9])
		    .withbYear(part[10])
		    .withGroupDate(part[11])
			.withAddress2(part[12])
			.withPhone2(part[13]);
    		list.add(address);		
    		line = bufferedreader.readLine();
	    
    		
//    		list.add(adr);		
 //   		line = bufferedreader.readLine();
		}
    	bufferedreader.close();
    
    	return list;
	}
	
    public static List<AddressDate> loadAddressFromXmlFile(File file) throws IOException {
    	XStream xstream = new XStream();
		xstream.alias("address",AddressDate.class);
		return (List<AddressDate>) xstream.fromXML(file);
		
	}
    
	private static void saveAddressToXmlFile(List<AddressDate> address, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("address",AddressDate.class);
		String xml = xstream.toXML(address);
		FileWriter writer = new FileWriter(file);
	    writer.write(xml);
	    writer.close();
		 
		
	}

	private static void saveAddressToCsvFile(List<AddressDate> address, File file) throws IOException {
	  FileWriter writer = new FileWriter(file);
	  for (AddressDate adr : address) {
		  writer.write(adr.getLastname()+","+adr.getFname()+","+adr.getAddress()+","+adr.getHome()+","+adr.getMobile()+","+adr.getWork()+","+
	                   adr.getEmail()+","+adr.getEmail2()+","+adr.getBday()+","+adr.getBmonth()+","+adr.getByear()+","+adr.getGroupdate()+","+
	                   adr.getAddress2()+","+adr.getPhone2()+",!"+"\n");
		
	}
		writer.close();
	}

	public static List<AddressDate> generateRandomAddress(int amount) {
		List<AddressDate> list =  new ArrayList<AddressDate>();
		
		for (int i = 0; i<amount; i++)
		{
			AddressDate adr = new AddressDate()
			 .withLastName(generateRandomString())
    		 .withFname(generateRandomString())
    		 .withAddress(generateRandomString())
    		 .withHome(generateRandomString())
    		 .withMobile(generateRandomString())
    		 .withWork(generateRandomString())
    		 .withEmail(generateRandomString())
    		 .withEmail2(generateRandomString())
    		 .withbDay("1")
		     .withbMounth("January")
		     .withbYear("1980")
		     .withGroupDate("group1")
			 .withAddress2(generateRandomString())
			 .withPhone2(generateRandomString()); 
		
			
	// убрали 4 урок при добавление верхней строки вытягивание в цепочку
//			 group.groupname = generateRandomString();
//		     group.header = generateRandomString();
//	       group.footer =generateRandomString();
	         list.add(adr);
			
		}
		
		
		//....
		return list;
	}
	
	public static String generateRandomString()
	{
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0)
		{
			return " ";
					}	else  
			return "test" + rnd.nextInt();
	}


}

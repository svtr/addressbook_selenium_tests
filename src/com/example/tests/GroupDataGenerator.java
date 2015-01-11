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

public class GroupDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length<3){
			System.out.println("Need 3 parametrs : amount, file, format");
			return;
		}
     int amount = Integer.parseInt(args[0]);
     File  file = new File(args[1]);
     String format = args[2];
     
     List<GroupDate> groups = generateRandomGroups(amount);
     if ("csv".equals(format)){
    	 saveGroupsToCsvFile(groups,file);
     } else if ("xml".equals(format)) {
    	 saveGroupsToXmlFile(groups,file);
     } else { 
    	 System.out.println("Format only csv or xml");
    	 return;
     }
    	 
	}

  	
    public static List<GroupDate> loadGroupsFromCsvFile(File file) throws IOException {
    	List<GroupDate> list =  new ArrayList<GroupDate>();
    	FileReader reader = new FileReader(file);
    	BufferedReader bufferedreader = new BufferedReader(reader);
    	String line = bufferedreader.readLine();
    	while (line != null) {
		    String[] part = line.split(",");
    		GroupDate group = new GroupDate()
    		.withGroupName(part[0])
    		.withHeader(part[1])
    		.withFooter(part[2]);
    		list.add(group);		
    		line = bufferedreader.readLine();
		}
    	bufferedreader.close();
    
    	return list;
	}
	
    public static List<GroupDate> loadGroupsFromXmlFile(File file) throws IOException {
    	XStream xstream = new XStream();
		xstream.alias("group",GroupDate.class);
		return (List<GroupDate>) xstream.fromXML(file);
		
	}
    
	private static void saveGroupsToXmlFile(List<GroupDate> groups, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("group",GroupDate.class);
		String xml = xstream.toXML(groups);
		FileWriter writer = new FileWriter(file);
	    writer.write(xml);
	    writer.close();
		 
		
	}

	private static void saveGroupsToCsvFile(List<GroupDate> groups, File file) throws IOException {
	  FileWriter writer = new FileWriter(file);
	  for (GroupDate group : groups) {
		  writer.write(group.getGroupname()+","+group.getHeader()+","+group.getFooter()+",!"+"\n");
		
	}
		writer.close();
	}

	public static List<GroupDate> generateRandomGroups(int amount) {
		List<GroupDate> list =  new ArrayList<GroupDate>();
		
		for (int i = 0; i<amount; i++)
		{
			GroupDate group = new GroupDate()
			 .withGroupName (generateRandomString())
			 .withHeader (generateRandomString())
	         .withFooter(generateRandomString());
			
	// убрали 4 урок при добавление верхней строки вытягивание в цепочку
//			 group.groupname = generateRandomString();
//		     group.header = generateRandomString();
//	       group.footer =generateRandomString();
	         list.add(group);
			
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

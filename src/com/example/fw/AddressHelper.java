package com.example.fw;




import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.AddressDate;
import com.example.tests.GroupDate;
import com.example.utils.SortedListOf;


public class AddressHelper extends HelperBase {

    public static boolean CREATION=true;
    public static boolean MODIFICATION = false;
	
	public AddressHelper(ApplicationManager manager) {
		super(manager);
	}

	public AddressHelper createAddress(AddressDate address) {
		gotoCreateAddress();
	    fillFormAddress(address, CREATION);
	    submitFormCreateAddress();
	    manager.navigateTO().gotoPage("home page");
	    rebuildCacheAddress();
	    return this;
	}
	
	public AddressHelper modifyAddress(int index, AddressDate address) {
		initmodifyaddress(index);
		fillFormAddress(address, MODIFICATION);
		updateAddressForm();
		manager.navigateTO().gotoPage("home page");
		rebuildCacheAddress();
		return this;
	}

	public AddressHelper deleteAddress(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index+2)
				+ "]/td[7]/a/img"));
		click(By.xpath("//*[@id='content']/form[2]/input[2]"));
	    manager.navigateTO().gotoPage("home page");
	    rebuildCacheAddress();
		return this;
	}
	
	
	private SortedListOf<AddressDate> cachedAddress;

	public SortedListOf<AddressDate> GetContacts() {
		 
		    if (cachedAddress == null){
		    rebuildCacheAddress();
		    } 
		    return new SortedListOf<AddressDate>(cachedAddress);
	//	    return cachedAddress;
		
		}
	
	public void rebuildCacheAddress() {

		cachedAddress =  new SortedListOf<AddressDate>();
		manager.navigateTO().mainPage();;
//	    List<AddressDate> addrs = new ArrayList<AddressDate>();
		List<WebElement> table = driver.findElements(By.xpath(".//*[@id='maintable']/tbody/tr[position()>1 and position()!=last()]"));
					
		for (WebElement  td: table) {
//			AddressDate address = new AddressDate();
			String lastname = td.findElement(By.xpath(".//td[2]")).getText();
 			lastname =   replaceNullOrEmpty(lastname);
 			String fname = td.findElement(By.xpath(".//td[3]")).getText();
 			fname = replaceNullOrEmpty(fname);
            String email = td.findElement(By.xpath(".//td[4]")).getText();
            email = replaceNullOrEmpty(email);
            String home = td.findElement(By.xpath(".//td[5]")).getText();
            home = replaceNullOrEmpty(home);
            home=home.replaceAll("[ ]", "");
            cachedAddress.add(new AddressDate().withLastName(lastname).withFname(fname).withEmail(email).withHome(home));
			
		}
	
    }
//---------------------------------------------------------------------------------------------	
	
	private void submitFormCreateAddress() {
		driver.findElement(By.name("submit")).click();
		
	}

	private void gotoCreateAddress() {
		driver.findElement(By.linkText("add new")).click();
		
	}

	public void fillFormAddress(AddressDate addr , boolean formType) {
		if (addr.getFname() != null) {
			type(By.name("firstname"), addr.getFname());
		}
		if (addr.getLastname() != null) {
			type(By.name("lastname"), addr.getLastname());
		}
		if (addr.getAddress() != null) {
			type(By.name("address"), addr.getAddress());
		}
		if (addr.getHome() != null) {
			type(By.name("home"), addr.getHome());
		}
		if (addr.getMobile() != null) {
			type(By.name("mobile"), addr.getMobile());
		}
		if (addr.getWork() != null) {

			type(By.name("work"), addr.getWork());
		}
		if (addr.getEmail() != null) {

			type(By.name("email"), addr.getEmail());
		}
		if (addr.getEmail2() != null) {
			type(By.name("email2"), addr.getEmail2());
		}
		// Select sel = new Select(manager.driver.findElement(By.name("bday")));

		if (addr.getBday() != null) {
			if (!addr.getBday().equals(" ")) {
				selectByText(addr.getBday(), By.name("bday"));
			}
		}

		if (addr.getBmonth() != null) {
			if (!addr.getBmonth().equals(" ")) {
				selectByText(addr.getBmonth(), By.name("bmonth"));
			}
		}

		type(By.name("byear"), addr.getByear());

		if (formType==CREATION){
		}
		if (formType==MODIFICATION) {    
	             if (driver.findElements(By.name("new_group")).size()!=0) {
			     throw new Error("Group selector exist in form");
		 }  
	             
	 }
		
		
		// {
		// type(By.name("new_group"), addr.group);
		// }
		if (!addr.getAddress2().equals(" ") ) {
			type(By.name("address2"), addr.getAddress2());
		}
		if (!addr.getPhone2().equals(" ")) {
			type(By.name("phone2"), addr.getPhone2());
		}

	}

	public AddressHelper newAddressCreation() {
		click(By.name("add new"));
		return this;
	}
	


	public AddressHelper initmodifyaddress(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index+2)
				+ "]/td[7]/a/img"));
		return this; 
	}

	public AddressHelper updateAddressForm() {
		click(By.xpath(".//*[@id='content']/form[1]/input[11]"));
		return this;
	}
	
	public void selectDay(){
	
	}
	
	public void selectMonth(){
		
	}
	
    public void selectGroup(){
		
	}
	


	

	

}

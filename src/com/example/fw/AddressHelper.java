package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.AddressDate;


public class AddressHelper extends HelperBase {

	public AddressHelper(ApplicationManager manager) {
		super(manager);
	}

	public void fillFormAddress(AddressDate addr) {
		if (addr.fname != null) {
			type(By.name("firstname"), addr.fname);
		}
		if (addr.lastname != null) {
			type(By.name("lastname"), addr.lastname);
		}
		if (addr.address != null) {
			type(By.name("address"), addr.address);
		}
		if (addr.home != null) {
			type(By.name("home"), addr.home);
		}
		if (addr.mobile != null) {
			type(By.name("mobile"), addr.mobile);
		}
		if (addr.work != null) {

			type(By.name("work"), addr.work);
		}
		if (addr.email != null) {

			type(By.name("email"), addr.email);
		}
		if (addr.email2 != null) {
			type(By.name("email2"), addr.email2);
		}
		// Select sel = new Select(manager.driver.findElement(By.name("bday")));

		if (addr.bday != null) {
			if (addr.bday != " ") {
				selectByText(addr.bday, By.name("bday"));
			}
		}

		if (addr.bmonth != null) {
			if (addr.bmonth != " ") {
				selectByText(addr.bmonth, By.name("bmonth"));
			}
		}

		type(By.name("byear"), addr.byear);

		// if (addr.group != " ")
		// {
		// type(By.name("new_group"), addr.group);
		// }
		if (addr.address2 != " ") {
			type(By.name("address2"), addr.address2);
		}
		if (addr.phone2 != " ") {
			type(By.name("phone2"), addr.phone2);
		}

	}

	public void newAddressCreation() {
		click(By.name("add new"));
	}
	
	public void deleteAddress(int index) {
		// selectAddressByIndex(index);
		// click(By.xpath("//input[@name=''maintable']/tbody/tr["+index+"]/td[7]"));
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index+1)
				+ "]/td[7]/a/img"));
		click(By.xpath("//*[@id='content']/form[2]/input[2]"));

	}

	public void initmodifyaddress(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index+1)
				+ "]/td[7]/a/img"));

	}

	public void updateAddressForm() {
		click(By.xpath(".//*[@id='content']/form[1]/input[11]"));

	}
	
	public void selectDay(){
	
	}
	
	public void selectMonth(){
		
	}
	
    public void selectGroup(){
		
	}
	
	public List<AddressDate> GetAddress() {

		    List<AddressDate> addrs = new ArrayList<AddressDate>();
			List<WebElement> checkboxes = driver.findElements(By.xpath(".//*[@id='maintable']/tbody/tr/td[2]"));
			for (WebElement td : checkboxes) {
				AddressDate address = new AddressDate();
				String text = td.getText();
				text = replaceNull(text);
				address.lastname =   text;
				address.fname = replaceNull(address.fname);
				address.address = replaceNull(address.address);
				address.home = replaceNull(address.home);
				address.mobile = replaceNull(address.mobile);
				address.work = replaceNull(address.work);
				address.email = replaceNull(address.email);
				address.email2 = replaceNull(address.email2);
				address.bday = replaceNull(address.bday);
				address.bmonth = replaceNull(address.bmonth);
				address.byear = replaceNull(address.byear);
				address.groupdate = replaceNull(address.groupdate);
				address.address2 = replaceNull(address.address2);
				address.phone2 = replaceNull(address.phone2);
				addrs.add(address);
				
			}
			return addrs;
		
		
	}
	
	


}

package com.example.tests;



public class AddressData implements Comparable<AddressData> {
	private String lastname;
	private String fname;
	private String address;
	private String home;
	private String mobile;
	private String work;
	private String email;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	private String groupdate;
	private String address2;
	private String phone2;

	public AddressData() {

	}

	public AddressData( String lastname, String fname, String address,
			String home, String mobile, String work, String email,
			String email2, String bday, String bmonth, String byear,
			String groupdate, String address2, String phone2) {
		this.lastname = lastname;
		this.fname = fname;
    	this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.groupdate = groupdate;
		this.address2 = address2;
		this.phone2 = phone2;

	}


	

	@Override
	public int hashCode() {
		int result = 1;
		
		return result;
	}


	@Override
	public String toString() {
		return "AddressDate [lastname=" + lastname
				+ ",fname=" + fname + ",  address=" + this.address + ", home=" + home + ", mobile="
				+ mobile + ", work=" + work + ", email=" + email + ", email2="
				+ email2 + ", bday=" + bday + ", bmonth=" + bmonth + ", byear="
				+ byear + ", groupdate=" + groupdate + ", address2=" + address2
				+ ", phone2=" + phone2 + "]";
	}

	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressData other = (AddressData) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if ( (email.equals(" "))||(email.isEmpty())) {
		    if (other.email.isEmpty()||(other.email.equals(" ") ))
    		  	return true;
		} else if (!email.equals(other.email))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		
		} else if ( (fname.equals(" "))||(fname.isEmpty())) {
		     if (other.fname.isEmpty()||(other.fname.equals(" ")))
    		  	return true;
		} else if (!fname.equals(other.fname))
			return false;
//		if (home == null) {
//			if (other.home != null)
//				return false;
//		} else if ( (home.equals(" "))||(home.isEmpty())) {
//		     if (other.home.isEmpty()||(other.home.equals(" ")))
//	    		  	return true;
//		} else if (!home.equals(other.home))
//			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if( (lastname.equals(" "))||(lastname.isEmpty())) {
		     if (other.lastname.isEmpty()||(other.lastname.equals(" ")))
	    		return true;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public int compareTo(AddressData other) {
     
		int result = this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
		if (result == 0) result = this.fname.toLowerCase().compareTo(other.fname.toLowerCase());
		if (result == 0) result = this.home.toLowerCase().compareTo(other.home.toLowerCase());
		if (result == 0) result = this.email.toLowerCase().compareTo(other.email.toLowerCase());
        return result;
		
		
     	 
     
     
     
     
      
    
	}

	public AddressData withLastName(String lastname) {
		this.lastname = lastname;
		return this;
		
	}

	public AddressData withFname(String fname) {
		this.fname = fname;
		return this;
	}

	public AddressData withAddress(String address) {
		this.address = address;
		return this;
	}

	public AddressData withHome(String home) {
		this.home = home;
		return this;
	}

	public AddressData withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public AddressData withWork(String work) {
		this.work = work;
		return this;
	}

	public AddressData withEmail(String email) {
		this.email = email;
		return this;
	}

	public AddressData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public AddressData withbDay(String bday) {
		this.bday = bday;
		return this;
	}

	public AddressData withbMounth(String bmonth) {
		this.bmonth = bmonth;
		return this;
	}

	public AddressData withbYear(String byear) {
		this.byear = byear;
		return this;
	}

	public AddressData withGroupDate(String groupdate) {
		this.groupdate = groupdate;
		return this;
	}

	public AddressData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public AddressData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getBday() {
		return bday;
	}

	public void setBday(String bday) {
		this.bday = bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public void setBmonth(String bmonth) {
		this.bmonth = bmonth;
	}

	public String getByear() {
		return byear;
	}

	public void setByear(String byear) {
		this.byear = byear;
	}

	public String getGroupdate() {
		return groupdate;
	}

	public void setGroupdate(String groupdate) {
		this.groupdate = groupdate;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	
 

}

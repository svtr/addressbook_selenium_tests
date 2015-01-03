package com.example.tests;



public class AddressDate implements Comparable<AddressDate> {
	public String lastname;
	public String fname;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String groupdate;
	public String address2;
	public String phone2;

	public AddressDate() {

	}

	public AddressDate( String lastname, String fname, String address,
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
		final int prime = 31;
		int result = 1;
		
		return result;
	}

//	@Override
	//public boolean equals(Object obj) {
	//	if (this == obj)
	//		return true;
	//	if (obj == null)
	//		return false;
	//	if (getClass() != obj.getClass())
	//		return false;
	//	AddressDate other = (AddressDate) obj;
	//	if (lastname == null) {
	//		if (other.lastname != null)
	//	     return false;
	//	}
	//	if ( (lastname == " ")||(lastname.isEmpty())) {
	//	      if (other.lastname.isEmpty()||(lastname == " "))
	//	   	  return true;
	//	
	//	}     
	//	  else if (!lastname.equals(other.lastname))
	//		return false;
	//	return true;
	//}
	
	
	
	
	
	

	@Override
	public String toString() {
		return "AddressDate [lastname=" + lastname
				+ ",fname=" + fname + ",  address=" + address + ", home=" + home + ", mobile="
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
		AddressDate other = (AddressDate) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if ( (email == " ")||(email.isEmpty())) {
		    if (other.email.isEmpty()||(other.email == " "))
    		  	return true;
		} else if (!email.equals(other.email))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		
		} else if ( (fname == " ")||(fname.isEmpty())) {
		     if (other.fname.isEmpty()||(other.fname == " "))
    		  	return true;
		} else if (!fname.equals(other.fname))
			return false;
		if (home == null) {
			if (other.home != null)
				return false;
		} else if ( (home == " ")||(home.isEmpty())) {
		     if (other.home.isEmpty()||(other.home == " "))
	    		  	return true;
		} else if (!home.equals(other.home))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if( (lastname == " ")||(lastname.isEmpty())) {
		     if (other.lastname.isEmpty()||(other.lastname == " "))
	    		return true;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public int compareTo(AddressDate other) {
     
		int result = this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
		if (result == 0) result = this.fname.toLowerCase().compareTo(other.fname.toLowerCase());
		if (result == 0) result = this.home.toLowerCase().compareTo(other.home.toLowerCase());
		if (result == 0) result = this.email.toLowerCase().compareTo(other.email.toLowerCase());
        return result;
		
		
     	 
     
     
     
     
      
    
	}
	
	
 

}

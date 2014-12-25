package com.example.tests;

public class AddressDate implements Comparable<AddressDate> {
	public String fname;
	public String lastname;
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

	public AddressDate(String fname, String lastname, String address,
			String home, String mobile, String work, String email,
			String email2, String bday, String bmonth, String byear,
			String groupdate, String address2, String phone2) {
		this.fname = fname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.byear = byear;
		this.bmonth = bmonth;
		this.byear = byear;
		this.groupdate = groupdate;
		this.address2 = address2;
		this.phone2 = phone2;

	}

	@Override
	public String toString() {
		return "AddressDate [fname=" + fname + ", lastname=" + lastname
				+ ", address=" + address + ", home=" + home + ", mobile="
				+ mobile + ", work=" + work + ", email=" + email + ", email2="
				+ email2 + ", bday=" + bday + ", bmonth=" + bmonth + ", byear="
				+ byear + ", groupdate=" + groupdate + ", address2=" + address2
				+ ", phone2=" + phone2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((bday == null) ? 0 : bday.hashCode());
		result = prime * result + ((bmonth == null) ? 0 : bmonth.hashCode());
		result = prime * result + ((byear == null) ? 0 : byear.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((email2 == null) ? 0 : email2.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result
				+ ((groupdate == null) ? 0 : groupdate.hashCode());
		result = prime * result + ((home == null) ? 0 : home.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((phone2 == null) ? 0 : phone2.hashCode());
		result = prime * result + ((work == null) ? 0 : work.hashCode());
		return result;
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
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (bday == null) {
			if (other.bday != null)
				return false;
		} else if (!bday.equals(other.bday))
			return false;
		if (bmonth == null) {
			if (other.bmonth != null) {
				return false;
			}
		} else if (!bmonth.equals(other.bmonth)) {
			return false;
		}
		if (byear == null) {
			if (other.byear != null)
				return false;
		} else if (!byear.equals(other.byear))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (email2 == null) {
			if (other.email2 != null)
				return false;
		} else if (!email2.equals(other.email2))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (groupdate == null) {
			if (other.groupdate != null)
				return false;
		} else if (!groupdate.equals(other.groupdate))
			return false;
		if (home == null) {
			if (other.home != null)
				return false;
		} else if (!home.equals(other.home))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (phone2 == null) {
			if (other.phone2 != null)
				return false;
		} else if (!phone2.equals(other.phone2))
			return false;
		if (work == null) {
			if (other.work != null)
				return false;
		} else if (!work.equals(other.work))
			return false;
		return true;
	}

	@Override
	public int compareTo(AddressDate other) {

		return this.address.toLowerCase()
				.compareTo(other.address.toLowerCase());
	}

}

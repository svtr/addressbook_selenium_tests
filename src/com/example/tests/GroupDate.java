package com.example.tests;

public class GroupDate implements Comparable<GroupDate>{
	public String groupname;
	public String header;
	public String footer;

	public GroupDate() {
		
	}
	
	public GroupDate(String groupname, String header, String footer) {
		this.groupname = groupname;
		this.header = header;
		this.footer = footer;
	}

	@Override
	public String toString() {
		return "GroupDate [groupname=" + groupname + ", header=" + header + ",footer=" + footer + " ]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
	//	result = prime * result
	//			+ ((groupname == null) ? 0 : groupname.hashCode());
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
		GroupDate other = (GroupDate) obj;
		if (groupname == null) {
			if (other.groupname != null)
				return false;
		} else if (!groupname.equals(other.groupname))
			return false;
		return true;
	}

	@Override
	public int compareTo(GroupDate other) {

		
		return this.groupname.toLowerCase().compareTo(other.groupname.toLowerCase());
	}
	
	
}



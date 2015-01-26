package com.example.tests;

public class GroupData implements Comparable<GroupData>{
	private String id;
	private String groupname;
	private String header;
	private String footer;

	public GroupData() {
		
	}
	
	public GroupData(String groupname, String header, String footer) {
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
		int result = 1;

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
		GroupData other = (GroupData) obj;
		if (groupname == null) {
			if ((other.groupname != null)||(!other.groupname.equals("")))
				return false;
		} else if (!groupname.equals(other.groupname))
			return false;
		return true;
	}

	@Override
	public int compareTo(GroupData other) {

		
		return this.groupname.toLowerCase().compareTo(other.groupname.toLowerCase());
	}

	public GroupData withGroupName(String groupname) {
		this.groupname = groupname;
		return this;
	}
	
	public GroupData withId(String id) {
		this.id = id;
		return this;
	}


	public GroupData withHeader(String header) {
		this.header = header;
		return this;
	}

	public GroupData withFooter(String footer) {
		this.footer = footer;
		return this;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	
	
}



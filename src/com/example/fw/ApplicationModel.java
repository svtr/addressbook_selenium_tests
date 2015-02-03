package com.example.fw;

import java.util.List;

import com.example.tests.AddressData;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class ApplicationModel {
	

	private SortedListOf<GroupData> groups;
	private SortedListOf<AddressData> address;
	
	public SortedListOf<GroupData> getGroups(){
		return groups;
	}
	
	public SortedListOf<AddressData> getAddress(){
		return address;
	}
	
	public void setGroups(List<GroupData> groups){
		this.groups = new SortedListOf<GroupData>(groups);
	}
	
	public ApplicationModel addGroup(GroupData group) {
      groups.add(group);
      return this;
		
	}
	
	public ApplicationModel removeGroup(int index){
	    groups.remove(index);	
	    return this;
	}
	
	public ApplicationModel addAddress(AddressData adr) {
      address.add(adr);
      return this;
		
	}
	
	public ApplicationModel removeAddress(int index){
		address.remove(index);	
	    return this;
	}
	
	

}
 
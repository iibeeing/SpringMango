package com.mango.jtt.model;

import com.mango.jtt.system.entity.Searcher;

public class StudentSearchModel extends Searcher {
	private String name;
	private String address;
	private String friendName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	@Override
	public String toString() {
		return String.format(
				"StudentSearcher [name=%s, address=%s, friendName=%s]", name,
				address, friendName);
	}

}

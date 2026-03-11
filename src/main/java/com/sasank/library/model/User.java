package com.sasank.library.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private String userId;
	private List<String> issuedBookIds;

	public User(String name, String id) {
		this.name = name;
		this.userId = id;
		this.issuedBookIds = new ArrayList<>();
	}

	@Override
	public String toString() {
	    return "User{" +
	            "name='" + name + '\'' +
	            ", id='" + userId  +
	            '}';
	}

	
	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}
	
	public List<String> getIssuedBookIds() {
		return issuedBookIds;
	}
	
}

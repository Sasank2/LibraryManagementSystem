package com.sasank.library.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private String id;
	private List<String> issuedBookIds;
	
	public User(String name, String id) {
		this.name = name;
		this.id = id;
		this.issuedBookIds = new ArrayList<>();
	}
	
	@Override
	public String toString() {
	    return "User{" +
	            "name='" + name + '\'' +
	            ", id='" + id  +
	            '}';
	}
	
}

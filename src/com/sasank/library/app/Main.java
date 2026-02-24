package com.sasank.library.app;

import com.sasank.library.model.Book;
import com.sasank.library.model.User;

public class Main {
		

	public static void main(String[] args) {
		
		Book b =  new Book("1", "Design", "Reily");
		User u = new User("Sasank", "007");
		
		System.out.println(b.toString());
		System.out.println(u.toString());
	}

}

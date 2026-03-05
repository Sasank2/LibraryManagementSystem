package com.sasank.library.repository;

import java.util.*;
import com.sasank.library.model.Book;
import com.sasank.library.model.User;

public class LibraryRepository {
	
	private Map<String, Book> books = new HashMap<>();
	private Map<String, User> users = new HashMap<>();
	
	public void saveBook(Book book) {
		books.put(book.getId(), book);
	}
	
	public Book findBookbyId(String id) {
		return books.get(id);
	}
	
	public List<Book> getAllBooks() {
		return new ArrayList<>(books.values());
	}
	
	public boolean existBookById(String id) { // checks existence
		
		return books.containsKey(id);
	}
	
	public void saveUser(User user) {
		users.put(user.getUserId(), user);
	}
	
	public User findUserById(String id){
		return users.get(id);
	}
	
	public List<User> getAllUsers() {
		return new ArrayList<>(users.values());
	}
	
	public boolean existUserById(String id) {
		return users.containsKey(id);
	}
	
}

package com.sasank.library.service;

import java.util.List;

import com.sasank.library.exception.LibraryException;
import com.sasank.library.model.Book;
import com.sasank.library.model.BookStatus;
import com.sasank.library.model.User;
import com.sasank.library.repository.LibraryRepository;

public class LibraryService {
	
	private LibraryRepository repository;
	private static final int MAX_LIMIT = 3;
	
	public LibraryService(LibraryRepository repository) {
		this.repository = repository;
	}
	
	public void addBook(String bookId, String title, String author) {
		if(bookId == null || bookId.isBlank()) {
			throw new LibraryException("Book ID cannot be empty");
		}
		if(title == null || title.isBlank()) {
			throw new LibraryException("Title cannot be empty");
		}
		if(author == null || author.isBlank()) {
			throw new LibraryException("author name cannot be empty");
		}
		if(repository.existBookById(bookId)) {
			throw new LibraryException("Duplicate book ID");
		}
			Book book = new Book(bookId, title, author);
			repository.saveBook(book);
	}
	
	public void registerUser(String name, String userId) {
		
		if(name == null || name.isBlank()) {
			throw new LibraryException("Name cannot be empty");
		}
		if(userId == null || userId.isBlank()) {
			throw new LibraryException("User ID cannot be empty");
		}
		
		if(repository.existUserById(userId)) {
			throw new LibraryException("Duplicate user ID");
		}else {
			User user = new User(name, userId);
			repository.saveUser(user);
		}
		
	}
	
	public void issueBook(String bookId, String userId) {
		if(bookId == null || bookId.isBlank()) {
			throw new LibraryException("Book ID cannot be empty");
		}
		
		if(userId == null || userId.isBlank()) {
			throw new LibraryException("User ID cannot be empty");
		}
		
		Book book = repository.findBookbyId(bookId);
		
		if(book == null) {
			throw new LibraryException("No Book found");
		}
		
		User user = repository.findUserById(userId);
		
		if(user == null) {
			throw new LibraryException("User not found");
		}
		
		if(book.getStatus() == BookStatus.ISSUED) {
			throw new LibraryException("Book not available right now");
		}
		
		if(user.getIssuedBookIds().size() >= MAX_LIMIT) {
			throw new LibraryException("User exceeded limit");
		}
		
		book.setStatus(BookStatus.ISSUED);
		book.setIssuedToUserId(userId);
		user.getIssuedBookIds().add(bookId);
		
	}
	
	public void returnBook(String bookId, String userId) {
		
		if(userId == null || userId.isBlank()) {
			throw new LibraryException("User ID cannot be empty");
		}
		
		if(bookId == null || bookId.isBlank()) {
			throw new LibraryException("Book ID cannot be empty");
		}
		
		Book book = repository.findBookbyId(bookId);
		
		if (book == null)
	        throw new LibraryException("Book not found");
		
		if(book.getStatus() == BookStatus.AVAILABLE) {
			throw new LibraryException("Book supposed to be unavailable");
		}
		
		if(!book.getIssuedToUserId().equals(userId)){
			throw new LibraryException("This book was not issued to this user");
		}
		
		User user = repository.findUserById(userId);
		
		if (user == null) {
	        throw new LibraryException("Issuing user not found");
	    }
		
		book.setStatus(BookStatus.AVAILABLE);
		book.setIssuedToUserId(null);
		user.getIssuedBookIds().remove(bookId);
		
	}
	
	public List<Book> getAllBooks(){
		
		return repository.getAllBooks();
	}
	
	public List<User> getAllUsers(){
		return repository.getAllUsers();
	}


}

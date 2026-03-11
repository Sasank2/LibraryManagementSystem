package com.sasank.library.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sasank.library.dto.BookRequest;
import com.sasank.library.dto.IssueBook;
import com.sasank.library.dto.ReturnBook;
import com.sasank.library.dto.UserRequest;
import com.sasank.library.exception.LibraryException;
import com.sasank.library.model.Book;
import com.sasank.library.model.User;
import com.sasank.library.service.LibraryService;

@RestController // This class handles REST requests.
@RequestMapping("/api")
public class LibraryController {
	
	private final LibraryService service;
	
	public LibraryController(LibraryService service) {
		this.service = service;
		
	}
	
	@PostMapping("/books")
	public ResponseEntity<String> handleAddBook(@RequestBody BookRequest request){
		
		service.addBook(
				request.getBookId(),
				request.getTitle(),
				request.getAuthor());
		return new ResponseEntity<>(
				"Book added successfully",
				HttpStatus.CREATED);
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<String> handleRegisterUser(
			@RequestBody UserRequest request) {
		
		service.registerUser(
				request.getName(),
				request.getUserId());
		return new ResponseEntity<>(
				"User registered successfully",
				HttpStatus.CREATED);
	}
	
	@PostMapping("/issue")
	public ResponseEntity<String> handleIssueBook(
			@RequestBody IssueBook issue) {
		
		service.issueBook(
				issue.getBookId(),
				issue.getUserId()
				);
		return new ResponseEntity<>(
				" Book issued to user " + issue.getUserId(),
				HttpStatus.OK);
				
	}
	
	@PostMapping("/return")
	public ResponseEntity<String> handleReturnBook(
			@RequestBody ReturnBook returnBook) {
		
		service.returnBook(
				returnBook.getBookId(),
				returnBook.getUserId());
		return new ResponseEntity<>(
				" Book issued to user " + returnBook.getBookId(),
				HttpStatus.OK);
		
	}
	
	@GetMapping("/books")
	public List<Book> handleViewBooks() {
		return  service.getAllBooks();
	}
	
	@GetMapping("/users")
	public List<User> handleViewUsers() {
		return service.getAllUsers();
	}
}

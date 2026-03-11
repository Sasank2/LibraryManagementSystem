package com.sasank.library.app;

import java.util.List;
import java.util.Scanner;

import com.sasank.library.exception.LibraryException;
import com.sasank.library.model.Book;
import com.sasank.library.model.User;
import com.sasank.library.repository.LibraryRepository;
import com.sasank.library.service.LibraryService;

public class ConsoleUI {
	LibraryRepository repo = new LibraryRepository();
	LibraryService service = new LibraryService(repo);
	
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		boolean running = true;
		
		while(running) {
			printMainMenu();
			
			System.out.println(" Enter yout choice");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1 :
				sc.nextLine();
				handleAddBook();
				break;
			case 2 :
				handleRegisterUser();
				break;
			case 3 :
				handleIssueBook();
				break;
			case 4 :
				handleReturnBook();
				break;
			case 5 :
				handleViewBooks();
				break;
			case 6 :
				handleViewUsers();
				break;
			case 7 :
				System.out.println("Thank you for visiting");
				running = false;
			}
		}
	}
	
	
	private void printMainMenu() {

	    System.out.println();
	    System.out.println("======================================");
		System.out.println("         	DIGITAL LIBRARY         ");
	    System.out.println("======================================");
	    System.out.println("1. Add Book");
	    System.out.println("2. Register User");
		System.out.println("3. Issue Book");
		System.out.println("4. Return Book");
		System.out.println("5. View All Books");
		System.out.println("6. View All Users");
		System.out.println("7. Exit");
		System.out.println("======================================");
		}
	
	private void handleAddBook() {
		System.out.println(" Enter Book ID");
		String bookId = sc.nextLine();
		System.out.println(" Enter Book name");
		String name = sc.nextLine();
		System.out.println(" Enter Author name");
		String author = sc.nextLine();
		try {
			service.addBook(bookId, name, author);
			System.out.println(" Book added successfully");
		}
		catch (LibraryException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	private void handleRegisterUser() {
		System.out.println(" Enter member name");
		String name = sc.nextLine();
		System.out.println(" Enter UserId");
		String userId = sc.nextLine();
		try {
			service.registerUser(name, userId);
			System.out.println(" User registered successfully");
		}
		catch (LibraryException e){
			System.out.println(e.getMessage());
		}
	}
		private void handleIssueBook() {
			System.out.println(" Enter Book Id");
			String bookId = sc.nextLine();
			System.out.println(" Enter UserId");
			String userId = sc.nextLine();
			try {
				service.issueBook(bookId, userId);
				System.out.println(" Book issued to user " + userId);
			}
			catch (LibraryException e){
				System.out.println(e.getMessage());
			}
		}
		private void handleReturnBook() {
			System.out.println(" Enter Book Id");
			String bookId = sc.nextLine();
			System.out.println(" Enter User Id");
			String userId = sc.nextLine();
			try {
				service.returnBook(bookId, userId);
				System.out.println(" Book returned with id "+ bookId );
			}
			catch (LibraryException e){
				System.out.println(e.getMessage());
			}
		}
		
		private void handleViewBooks() {
			List<Book> books = service.getAllBooks();
			if(books.isEmpty()) {
				System.out.println("No books available ");
				return;
			}
			for(Book book : books) {
				System.out.println(book);
			}
		}
		private void handleViewUsers() {
			List<User> users = service.getAllUsers();
			if(users.isEmpty()) {
				System.out.println("No users found ");
				return;
			}
			for(User user :users) {
				System.out.println(user);
			}
		}
		
		
}

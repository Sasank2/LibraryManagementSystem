package com.sasank.library.app;

import com.sasank.library.model.Book;
import com.sasank.library.model.User;
import com.sasank.library.repository.LibraryRepository;
import com.sasank.library.service.LibraryService;

public class Main {
		

	public static void main(String[] args) {
		
		ConsoleUI UI = new ConsoleUI();
		UI.mainMenu();
	}

}

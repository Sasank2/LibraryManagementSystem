package com.sasank.library.model;

public class Book {
	
	private String id;
	private String title;
	private String author;
	private BookStatus status;
	private String issuedToUserId;
	
	public Book(String id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	    this.status = BookStatus.AVAILABLE;
		issuedToUserId = null;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public BookStatus getStatus() {
		return status;
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}
	public String getIssuedToUserId() {
	    return issuedToUserId;
	}

	public void setIssuedToUserId(String issuedToUserId) {
	    this.issuedToUserId = issuedToUserId;
	}
	
	@Override
	public String toString() {
	    return "Book{" +
	            "id='" + id + '\'' +
	            ", name='" + title + '\'' +
	            ", author='" + author + '\'' +
	            ", status=" + status +
	            '}';
	}
	
}

package com.anand.binding;

public class Quote {

	private int id;
	private String quote;
	private String author;
	public Quote() {
       System.out.println("inside Quote constructor");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Quote [id=" + id + ", quote=" + quote + ", author=" + author + "]";
	}
	
	
}

package com.anand.binding;

public class Quotes {

	private int id;
	private String quote;
	private String author;
	
	public Quotes() {
        System.out.println("0 parameter Quotes");
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
		return "Quotes [id=" + id + ", quote=" + quote + ", author=" + author + "]";
	}
	
	
}

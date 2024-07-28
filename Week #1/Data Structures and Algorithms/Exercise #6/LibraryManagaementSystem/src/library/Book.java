package library;

public class Book {
	private String BookId;
	private String Title;
	private String Author;
	
	public Book(String BookId, String Title, String Author) {
		this.BookId = BookId;
		this.Title = Title;
		this.Author = Author;
	}
	
	public String getbookId() {
		return BookId;
	}
	
	public void setbookId(String BookId) {
		this.BookId = BookId;
	}
	
	public String gettitle() {
		return Title;
	}
	
	public void settitle(String Title) {
		this.Title = Title;
	}
	
	public String getauthor() {
		return Author;
	}
	
	public void setauthor(String Author) {
		this.Author = Author;
	}
	
	@Override
	public String toString() {
		return "Book ID = " + BookId + " Title = " + Title + " Author = " + Author;
	}
}

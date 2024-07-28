package library;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
	private Book[] books;
	private int size;
	
	public Main(int capacity) {
		books = new Book[capacity];
		size=0;
	}
	
	public void add(Book book) {
		if(size < books.length) {
			books[size++] = book;
		}
	}
	
	public Book linearSearch(String t) {
		for (Book book : books) {
			if(book != null && book.gettitle().equalsIgnoreCase(t)) {
				return book;
			}
		}
		return null;
	}
	
	public Book binarySearch(String t) {
		Arrays.sort(books,0,size,Comparator.comparing(Book::gettitle));
		int left = 0;
		int right = size - 1;
		while(left<=right) {
			int mid = (left+right)/2;
			int temp = books[mid].gettitle().compareToIgnoreCase(t);
			if(temp == 0) return books[mid];
			else if (temp<0) left = mid + 1;
			else right = mid - 1;
		}
		return null;
	}
	
	public static void main(String[] args) {
		Main l = new Main(5);
		l.add(new Book("B1","Harry Potter and the Sorcerer's Stone","J.K Rowling"));
		l.add(new Book("B2","The Immortals of Meluha","Amish Tripathi"));
		l.add(new Book("B3","Harry Potter and the Goblet of Fire","J.K Rowling"));
		l.add(new Book("B4","Harry Potter and the Chamber of Secrets","J.K Rowling"));
		
		System.out.println("Linear Search:");
		Book b1 = l.linearSearch("The Immortals of Meluha");
		System.out.println(b1 != null ? b1 : "Book not found");
		
		System.out.println("\nBinary Search:");
		Book b2 = l.binarySearch("Harry Potter and the Goblet of Fire");
		System.out.println(b2 != null ? b2 : "Book not found");
	}
}

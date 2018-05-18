package playstore;

public class Book extends Reading {

	private double Price = 0;
	private String[] Author_Name;
//constructors
	public Book(String iD, String application_Name, double price, String Publisher, String Genre, int No_of_Pages,
			String[] Author_Name) {
		super(iD, application_Name, price, Publisher, Genre, No_of_Pages);
		this.Author_Name = Author_Name;

	}

	
	public Book(String iD, String application_Name, String Publisher, String Genre, int No_of_Pages,
			String[] Author_Name) {
		super(iD, application_Name, Publisher, Genre, No_of_Pages);
		this.Author_Name = Author_Name;

	}

	public String[] getAuthorName() {
		return Author_Name;
	}

}
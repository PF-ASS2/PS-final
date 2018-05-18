package playstore;

public abstract class Reading extends Content {

	private double Price = 0;
	private String Publisher;
	private String Genre;
	private int No_of_Pages;

	// constructors
	public Reading(String iD, String application_Name, double price, String Publisher, String Genre, int No_of_Pages) {
		super(iD, application_Name, price);
		this.Publisher = Publisher;
		this.Genre = Genre;
		this.No_of_Pages = No_of_Pages;
	}

	public Reading(String iD, String application_Name, String Publisher, String Genre, int No_of_Pages) {
		super(iD, application_Name);
		this.Publisher = Publisher;
		this.Genre = Genre;
		this.No_of_Pages = No_of_Pages;
	}
//variable modifier
	public String getGenre() {
		return Genre;
	}

}

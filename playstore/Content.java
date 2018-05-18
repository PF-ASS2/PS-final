package playstore;

import java.util.ArrayList;
import java.util.List;

public abstract class Content {

	protected List<Comment> Review = new ArrayList<Comment>();

	private Reading reading;
	private Book book;

	private String ID;
	private String Application_Name;

	private int No_of_Downloads = 0;
	private double Price = 0;

	public Content() {
	}

	// constructor to take ID, name and price of app
	public Content(String iD, String application_Name, double price) {
		super();
		ID = iD;
		Application_Name = application_Name;
		Price = price;
	}

	// another constructor for free apps
	public Content(String iD, String application_Name) {
		super();
		ID = iD;
		Application_Name = application_Name;
	}
// variable getters
	public String getApplication_Name() {
		return Application_Name.toString();
	}

	public double getPrice() {
		return Price;
	}

	public String getId() {
		return this.ID.toString();
	}

	public void Increase_NoD_by1() {
		this.No_of_Downloads += 1;
	}

	public void printAllReview() {
		System.out.println("Reviews for the game " + this.Application_Name);
		for (Comment a : this.Review) {
			System.out.println(a.getUsr() + a.getUsrComment());
			a.display("\t");
			System.out.println();
		}
	}

	public void addReviews(Comment a) {

		this.Review.add(a);
		System.out.println(a.getusrname()+"add review on "+this.getApplication_Name()+" : "+a.getUsrComment());
	}

	public String getGenre() {
		return reading.getGenre();
	}

	public String[] getAuthorName() {
		return reading.getAuthorName();
	}
}

package playstore;

public class Magazine extends Reading {
	
	private double Price = 0;
	String Title_of_the_Main_Feature;
	// constructors
	public Magazine(String iD, String application_Name, double price, String Publisher,String Genre, int No_of_Pages,String Title_of_the_Main_Feature) {
		super(iD,application_Name,price,Publisher,Genre,No_of_Pages);
		this.Title_of_the_Main_Feature = Title_of_the_Main_Feature;

	}

	public Magazine(String iD, String application_Name, String Publisher,String Genre, int No_of_Pages,String Title_of_the_Main_Feature) {
		super(iD,application_Name,Publisher,Genre,No_of_Pages);
		this.Title_of_the_Main_Feature = Title_of_the_Main_Feature;

	}
	
	
}
package playstore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

//COSC2531 Programming Fundamentals,Sem 2,2018*!!!!!!!!!!!!!!!!!!IMPORTANT!!!!!!!!!!!!!!!!!!This is a sample main method that checks the funtionalities required in the assignment 2. This file will NOT compile unless you write all the required java classes,along with their attributes and the methods.

public class PlayStore {
	// Student to do: Add the necessary attributes and methods
	public Hashtable<String, Content> storeContent = new Hashtable<String, Content>();
	// public List<Content> storeContent = new ArrayList<Content>();
	public List<User> usrDetails = new ArrayList<User>();

	private String game[] = { "G" };
	private String book[] = { "RB" };
	private String mag[] = { "RM" };
	private String all[] = { "", "G", "RB", "RM" };
	private String cName;

	public void addContents(Content a) {
		// grab key and content name details
		String iD = a.getId();
		String cName = a.getApplication_Name();

		if (a instanceof Game) {

			this.storeContent.put(iD, a);

			System.out.println("Game: " + cName + " for "+((Game) a).getO().getType()+" added to the PlayStore.");
		} else if (a instanceof Book) {

			this.storeContent.put(iD, a);

			System.out.println("Book: " + cName + " added to the PlayStore.");
		} else if (a instanceof Magazine) {

			this.storeContent.put(iD, a);

			// print out book added
			System.out.println("Magazine: " + cName + " added to the PlayStore.");
		}
	}
// add user
	public void addUsers(User r) {

		String uName = r.getUsrName();
		this.usrDetails.add(r);

		System.out.println("User "+uName + " has joined the PlayStore");
	}

	public void showReadingOfGenre(String n) {
		System.out.println();
		for (Content c : storeContent.values()) {
			String name = c.getApplication_Name();
			if (c instanceof Book) {
				String novel = c.getGenre();
				if (novel == n) {
					String[] a = c.getAuthorName();
					System.out.println(
							"The book " + '"' + name + '"' + " is a " + n + " authored by " + Arrays.toString(a));
				}
			}
			if (c instanceof Magazine) {
				String mag = c.getGenre();
				if (mag == n) {
					System.out.println("The magazine " + '"' + name + '"' + " is a " + n + " magazine.");
				}
			}
		}
		System.out.println();
	}
// show different types of contents based on input
	public void showAllContents(String[] media) {

		if (media[0] == "G") {
			System.out.println("Games in the PlayStore:");
		} else if (media[0] == "RB") {
			System.out.println("Books in the PlayStore:");
		} else if (media[0] == "RM") {
			System.out.println("Magazines in the PlayStore:");
		} else {
			System.out.println("Everything in the PlayStore:");
		}
		for (Entry<String, Content> c : storeContent.entrySet()) {
			if (c.getKey().startsWith(media[0])) {
				this.cName = c.getValue().getApplication_Name();
				// System.out.println(cName);
				if (c.getValue() instanceof Game) {
					System.out.println("Game: " + cName + ", ");
				} else if (c.getValue() instanceof Book) {
					System.out.println("Book: " + cName + ", ");
				} else if (c.getValue() instanceof Magazine) {
					// print out book added
					System.out.println("Magazine: " + cName + ", ");
				}
			}
		}
	}


	public static void main(String[] args) {
		PlayStore admin = new PlayStore();
		// Game game = new Game();
		// Reading reading = new Book();
		// Magazine magazine = new Magazine();
		// adding new readings

		String[] authors = { "L. Tolstoy" };
		Book b1 = new Book("RB1", "War and Peace", 12, "The Russian Messenger", "Novel", 1225, authors);
		String[] authors2 = { "F. Scott Fitzgerald" };
		Book b2 = new Book("RB2", "The great gatsby", 10, "Charles Scribner's Sons", "Novel", 180, authors2);
		String[] authors3 = { "Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein" };
		Book b3 = new Book("RB3", "Introduction to algorithms", 100, "MIT Press", "Computer Science", 1312, authors3);
		Magazine m1 = new Magazine("RM4", "Forbes", 8, "Forbes Media", "Business", 50, "World's richest under 30");

		admin.addContents(b1);
		admin.addContents(b2);
		admin.addContents(b3);
		admin.addContents(m1);

		// adding new games
		OS os1 = new OS("Android", 4);
		OS os2 = new OS("iOS", 10);
		OS os3 = new OS("Android", 3);
		Game g1 = new Game("G1", "Pokemon", 5, false, os1);
		Game g2 = new Game("G2", "Pokemon", 5, false, os2);
		Game g3 = new Game("G3", "MineCraft", 2, true, os1);

		admin.addContents(g1);
		admin.addContents(g2);
		admin.addContents(g3);

		// adding new users
		User u1 = new User("u1", "John Doe", "0412000", 120, os1);
		User u2 = new User("u2", "Jane Doe", "0412001", 120, os1);
		User u3 = new User("u3", "Dave Roe", "0412002", 100, os2);
		User u4 = new User("u4", "Diane Roe", "0412003", 50, os3);

		admin.addUsers(u1);
		admin.addUsers(u2);
		admin.addUsers(u3);
		admin.addUsers(u4);
		
		// Users are buying contents

		u1.buyContent(b1);
		u1.buyContent(b3);
		u4.buyContent(g1);
		u1.buyContent(m1);

		// some users becoming premium and then buying contents

		u4.becomePremium();
		u4.buyContent(m1);
		u2.becomePremium();
		u2.buyContent(g2);
		u2.buyContent(g1);

		// showing contents bought by the user u2
		u2.AllContentsBought();

		// showing all contents in the PlayStore
		 //admin.showAllContents(admin.book);
		 //admin.showAllContents(admin.game);
		// admin.showAllContents(admin.mag);
		admin.showAllContents(admin.all);

		// showing all reading type of objects with the genre 
		admin.showReadingOfGenre("Novel");

		// Student to do: call a method to show all games. What should be the
		// parameters // of that //method? See Section 2, functionality 7

		/* I really enjoy talking to myself
		Comment cm = new Comment(u1, "Pokemon is timeless, who doesn't like Pokemon!");
		g1.addReviews(cm);
		Comment cmr1 = new Comment(u2,
				"Really? You run around in imaginary fields hunting for imaginary animals...lame.");
		cm.addReply(cmr1);
		Comment cmr2 = new Comment(u1, "Nah, a game doesn't stick around for 20 years if it's crap");
		cmr1.addReply(cmr2);
		Comment cmr3 = new Comment(u2, "Yea, but I just find it boring.");
		cmr2.addReply(cmr3);
		Comment cm2 = new Comment(u3, "Does anyone else find it crashes all the time?");
		g1.addReviews(cm2);
		Comment cm2r1 = new Comment(u4, "Not me, maybe you have a dodgy phone.");
		cm2.addReply(cm2r1);
		Comment cm2r2 = new Comment(u3, "Really?? It's unplayable for me.");
		cm2r1.addReply(cm2r2);
		Comment cm2r3 = new Comment(u1, "Time to upgrade your iPhone...lols.");
		cm2r2.addReply(cm2r3);
		*/
		
		 Comment cmnt = new Comment(u1, "This is a fantastic game!");
		 g1.addReviews(cmnt);
		 Comment r1 = new Comment(u2, "I never liked this game!");
		 cmnt.addReply(r1);
		 Comment r2 = new Comment(u1, "Really??");
		 r1.addReply(r2);

		 Comment cmnt2 = new Comment(u3, "The game crashes frequently.");
		 g1.addReviews(cmnt2);


		// showing all reviews including the replies on object g1
		g1.printAllReview();

	}
}

package playstore;

import java.util.ArrayList;

//make return objects immutable --- look into this

public class User {

	//variables
	private String Id;
	private String Name;
	private String Phone_Number;
	private int Balance = 0;
	private OS o;
	private boolean Ispremium = false;
	private ArrayList<Content> ContentBought = new ArrayList<Content>();
	// private User [] usrDetails = new User [3];

	//constructors
	public User(String id, String name, String phone_Number, int balance, OS o) {
		super();
		Id = id;
		Name = name;
		Phone_Number = phone_Number;
		Balance = balance;
		this.o = o;
	};

	public User(String id, String name, String phone_Number, OS o) {
		super();
		Id = id;
		Name = name;
		Phone_Number = phone_Number;
		this.o = o;
	};

	public String getUsr() {
		String usrDetails = "User " + "(" + this.Id + "), " + this.Name + ";  ";
		return usrDetails;
	}

	public String getUsrName() {
		return Name.toString();
	}

	//become premium method
	public void becomePremium() {
		try {
			//check balance 
			int balance = this.Balance - 100;
			if (balance < 0) {
				throw new BalanceInsufficientException(this.Name + " can't become premium due to insufficient balance");
			} else {
				this.Ispremium = true;
				this.Balance = balance;
				System.out.println(this.Name + " You are Premium now");
			}
		} catch (BalanceInsufficientException e) {
			System.out.println(e.getMessage());
			return;
		}

	}

	public void buyContent(Content c) {
		try {
          //check if user is premium, and premium have 20% discount
			double realprice;
			if (this.Ispremium == true) {
				realprice = 0.8 * c.getPrice();
			} else {
				realprice = c.getPrice();
			}
			;
        // if it's a game, check os version and type
			if (c instanceof Game) {

				if (!this.o.getType().equals(((Game) c).getO().getType())) {
					throw new OsIncompatibleException(
							this.Name + " can't buy "+((Game) c).returnnameandos()+ " :your OS is not compatible with the game required OS\n");
				} else if (this.o.getVersion() < ((Game) c).getO().getVersion())

				{
					throw new OsVersionIncompatibleException(
							this.Name + " can't buy "+((Game) c).returnnameandos()+" :Your OS Version is not compatible with game required OS Version\n");
				}
			}
			// check if balance is enough to buy content
			if (this.Balance - realprice < 0) {
				throw new BalanceInsufficientException("You don't have enough balance\n");
			} else {
                  // check balance 
				this.Balance -= realprice;
				ContentBought.add(c);
				c.Increase_NoD_by1();
				if (c instanceof Game) {System.out.println( this.Name + " just bought " + ((Game) c).returnnameandos() + "\n");}
				else System.out.println( this.Name + " just bought " + c.getApplication_Name() + "\n");
			}

		} catch (BalanceInsufficientException f) {
			System.out.println(f.getMessage());

			return;
		} catch (OsIncompatibleException e) {
			System.out.println(e.getMessage());
			return;
		} catch (OsVersionIncompatibleException e) {
			System.out.println(e.getMessage());
			return;
		}

	}
// output everything in arraylist
	public void AllContentsBought() {
		System.out.println(this.Name + " total purchase history.");
		for (Content c : ContentBought) {
			if (c instanceof Game) {System.out.println(  ((Game) c).returnnameandos());}
			else
			System.out.println(c.getApplication_Name());
		}
		System.out.println();
	}

}

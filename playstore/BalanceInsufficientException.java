package playstore;
//user defined exception
public class BalanceInsufficientException extends Exception {

	public BalanceInsufficientException() {};
	public BalanceInsufficientException(String m) {
		super(m);// call "Exception(String message)" constructor 
	};
}

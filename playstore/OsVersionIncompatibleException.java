package playstore;
//user defined exception
public class OsVersionIncompatibleException extends Exception {
	
	public OsVersionIncompatibleException() {};
	public OsVersionIncompatibleException( String s) {
		super(s);// call "Exception(String message)" constructor 
	};

}

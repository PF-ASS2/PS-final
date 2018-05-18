package playstore;

//user defined exception
public class OsIncompatibleException extends Exception {

	public OsIncompatibleException() {};
	public OsIncompatibleException( String s) {
		super(s);// call "Exception(String message)" constructor 
	};
}

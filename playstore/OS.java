package playstore;

public class OS {

	private String Type;
	private int Version;
// variable getters
	public String getType() {
		return Type;
	}

	public int getVersion() {
		return Version;
	}
// constructors
	public OS(String type, int version) {

		Type = type;
		Version = version;
	}

}

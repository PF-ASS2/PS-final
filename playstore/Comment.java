package playstore;

import java.util.ArrayList;
import java.util.List;

public class Comment {

	protected List<Comment> reply = new ArrayList<Comment>();

	private String user;
	private String usrComment;
    private User u;
	public Comment() {

	}

	public Comment(User usrDetails, String usrComs) {

		this.user = usrDetails.getUsr();
		this.usrComment = usrComs;
		this.u=usrDetails;
	}

	public String getUsr() {
		return this.user;
	}
	public String getusrname() {
		return u.getUsrName();
	}

	public String getUsrComment() {
		return this.usrComment;
	}
// addreply method
	public void addReply(Comment r) {

		this.reply.add(r);
		System.out.println(r.getusrname()+" relied "+" : "+r.getUsrComment());

	}
// display all reply
	public void display(String t) {
		String tab = t;
		for (Comment r : reply) {
			System.out.println(tab + r.user + r.usrComment);
			tab += "\t";
			r.display(tab);
		}
	}
}

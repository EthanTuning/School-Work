package course;

public class student{
	private String firstName;
	private String lastName;
	private long id;
	private String email;
	
	public student(String firstName, String lastName, long id, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.email = email;
	}
	
	@Override
	public String toString(){
		return "First name: "+this.firstName+
			   "\nLast name: "+this.lastName+
			   "\nID: "+this.id+
			   "\nEmail: "+this.email+"\n";
	}
}
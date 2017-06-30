package course;

public class studentFactory{
	public static student createStudent(String first, String last, long id, String email){
		return new student(first, last, id, email);
	}
}

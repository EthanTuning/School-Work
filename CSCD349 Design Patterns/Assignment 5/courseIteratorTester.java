import course.course;
import course.student;
import course.studentFactory;
import java.util.Iterator;

public class courseIteratorTester{
	public static void main(String [] args){
		course myCourse = new course();
		myCourse.addStudent(studentFactory.createStudent("Ethan","Tuning",212312,"etuning5@hotmail.com"));
		myCourse.addStudent(studentFactory.createStudent("Other","Guy",123123,"otherguy@mail.com"));
		myCourse.addStudent(studentFactory.createStudent("John","Doe",634545,"anon.net"));
		myCourse.addStudent(studentFactory.createStudent("Jane","Doe",956856,"anon.net"));
		
		System.out.println("\nIteration using enhanced for loop:\n");
		
		for(student stu: myCourse){
			System.out.println(stu);
		}
		
		System.out.println("\nIteration using regular for loop:\n");
		
		Iterator<student> it = myCourse.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
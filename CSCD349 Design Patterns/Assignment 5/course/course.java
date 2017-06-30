package course;

import java.util.ArrayList;
import java.util.Iterator;

public class course implements Iterable<student>{
	private ArrayList<student> students;
	
	public course(){
		this.students = new ArrayList<student>();
	}
	
	public void addStudent(student student){
		this.students.add(student);
		System.out.println("Student has been added.");
	}
	
	class courseIterator implements Iterator<student>{
		private int curr = -1;
		
		@Override
		public boolean hasNext(){
			try{
				curr++;
				return students.get(curr) != null;
			}catch(IndexOutOfBoundsException e){
				return false;
			}
		}

		@Override
		public student next(){
			return students.get(curr);
		}	
	}

	@Override
	public Iterator<student> iterator(){
		return new courseIterator();
	}
}
import java.util.LinkedList;

public class Hashtable {
	private class HashtableRecord{
		private Object key;
		private Object value;

		public HashtableRecord() {
			this.key = null;
			this.value = null;
		}

		public HashtableRecord(Object inKey, Object inData) {
			this.key = inKey;
			this.value = inData;
		}

		/* Equality can be based on key alone because there can't be
		 * 2 nodes with the same key in the table */
		public boolean equals(Object obj) {
			if (obj instanceof HashtableRecord) {
				HashtableRecord node = (HashtableRecord)obj;
				return this.key.equals(node.key);
			}
			else {
				return false;
			}
		}

		public String toString() {
			return "Key: ["+this.key+"] Value: ["+this.value+"]";
		}
	}
	//
	//
	private final int tableSize = 100;
	private int numElements;
	private Object [] table;
	
	//constructor
	public Hashtable(int realSize) {
		this.table = new Object[realSize];
		this.numElements = 0;
	}
	
	public Hashtable() {
		this.table = new Object[this.tableSize];
		this.numElements = 0;
	}
	
	private int hash(Object key) {

		/* Start with a base, just so that it's not 0 for empty strings */
		int result = 42; //start at hard coded base

		String inputString = key.toString().toLowerCase();
		//System.out.println("hash string is:" + inputString + "\n");

		char [] characters = inputString.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			char currentChar = characters[i];

			if (currentChar == 'a' || currentChar == 'b' || currentChar == 'c' ||
					currentChar == 'd' || currentChar == 'e' || currentChar == 'f') {
				result += Integer.parseInt(""+currentChar, 16);
			}

			int j = (int)currentChar;
			//System.out.println("j = " + j );
			result += j;
		}

		return (result % this.table.length);
	}

	public void add(Object key, Object data) {
		if (data == null || key == null) {
			System.err.println("ERROR: Either the key or the data are null");
			return;
		}

		// If trying to add duplicate keys, that means 
		// we like to update the value associated with that existing key.
		// We first delete the existing mapping, then insert a new record that key.
		if (this.contains(key)) {
			remove(key);
		}

		// Find out where in our array should the new item goes 
		int position = this.hash(key);

		// If nothing exists in the position, create a new linked list there 
		if (this.table[position] == null) {
			this.table[position] = new LinkedList<HashtableRecord>();
		}

		// Add to the linked list in the appropriate position
		((LinkedList<HashtableRecord>)this.table[position]).add(new HashtableRecord(key, data));
		this.numElements++;
	}
	
	public void add(Object [] keys, Object [] inputData) {
		for (int i = 0; i < inputData.length; i++) {
			this.add(keys[i], inputData[i]);
		}
	}

	//return type is different from the standard Map interface.
	public void remove(Object key) {
		int hashVal = this.hash(key);

		if (this.table[hashVal] != null) {
			HashtableRecord node = new HashtableRecord();
			node.key = key; //in order to use the equals() method in HashtableNode

			if (((LinkedList<HashtableRecord>)this.table[hashVal]).indexOf(node) > -1) {
				((LinkedList<HashtableRecord>)this.table[hashVal]).remove(node);
				if( ((LinkedList<HashtableRecord>)this.table[hashVal]).size() == 0 )
					this.table[hashVal] = null;
	
				this.numElements--;
			}
		}
	}

	public void remove(Object [] keys) {
		for (int i = 0; i < keys.length; i++) {
			this.remove(keys[i]);
		}
	}

	public String toString() {
		String buffer = "";

		buffer += "{\n";
		for (int i = 0; i < this.table.length; i++) {
			if (this.table[i] != null) {
				buffer  = buffer +  "\t" + (LinkedList)this.table[i] + "\n" ;
			}
		}
		buffer += "}";
		return buffer;
	}

	public int getNumElements() {
		return this.numElements;
	}

	public boolean contains(Object key) {
		boolean result = false;
		int hash = this.hash(key);
		
		if (this.table[hash] != null) {
			HashtableRecord node = new HashtableRecord();
			node.key = key;
			if (((LinkedList<HashtableRecord>)this.table[hash]).indexOf(node) > -1) {
				result = true;
			}
		}
		return result;
	}
	
	public Object get(Object key) {
		Object result = null;
		int hash = hash(key);
		
		if(this.table[hash] != null){
			HashtableRecord node = new HashtableRecord();
			node.key = key;
			
			if(((LinkedList<HashtableRecord>)this.table[hash]).equals(node)){
				result = this.table[hash];
			}
		}
		return result;
	}
	
	public static void main(String argv[]){
		Hashtable myhash = new Hashtable();
		
		//test of strings
		/*
		System.out.println("Inital hash table is: \n" + myhash);
		myhash.add("smith", 30);
		myhash.add("john", 10);
		System.out.println("After two adds, hashtalbe is: \n" + myhash);
		myhash.add("green", 10);
		myhash.add("green", 60); //this will be added successfully, updating existing record.
		System.out.println("After four adds, hashtalbe is: \n" + myhash);
		
		myhash.remove("green");
		System.out.println("After remove green, hashtalbe is: \n" + myhash);
		*/
		
		System.out.println("Inital hash table is: \n" + myhash);
		myhash.add(11.5f, "smith");
		myhash.add(100.9f, "john");
		System.out.println("After two adds, hashtalbe is: \n" + myhash);
		myhash.add(3.4, "green");
		myhash.add(3.4, "white"); //this successfully updated the existing record with key = 3.4
		System.out.println("After total four adds, hashtalbe is: \n" + myhash);
		
		myhash.remove(3.4);
		System.out.println("After remove 3.4, hashtalbe is: \n" + myhash);
		
		
	}

}

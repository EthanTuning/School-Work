
public class GetTester {

	public static void main(String[] args) {
		Hashtable myhash = new Hashtable();
		
		myhash.add(11, "abcde");
		myhash.add(10, "abced");
		myhash.add(3, "edcba");
		myhash.add(5, "white"); //this successfully updated the existing record with key = 3.4
		System.out.println("After total four adds, hashtalbe is: \n" + myhash);
		
		Object result = myhash.get(5);
		System.out.println(result);
		
	}

}

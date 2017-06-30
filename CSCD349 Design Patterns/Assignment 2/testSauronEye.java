
public class testSauronEye{

	public static void main(String[] args){
		eyeOfSauron eye = new eyeOfSauron();
		badGuy saruman = new badGuy(eye, "Saruman");
		badGuy witchKing = new badGuy(eye, "Witch King");
		eye.setEnemies(5, 2, 5, 6);
		eye.setEnemies(6, 1, 1, 4);
		witchKing.defeated();
		eye.setEnemies(1, 1, 0, 2);
	}
}

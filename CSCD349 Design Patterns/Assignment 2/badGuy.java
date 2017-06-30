import java.util.Observable;
import java.util.Observer;

public class badGuy implements Observer{

	private String name;
	private eyeOfSauron eye;
	
	public badGuy(eyeOfSauron eye, String name){
		this.name = name;
		this.eye = eye;
		this.eye.addObserver(this);
	}
	
	public void defeated(){
		this.eye.deleteObserver(this);
		System.out.println("I am " + this.name + " and I am now dead!");
	}
	
	@Override
	public void update(Observable o, Object arg){
		eye = (eyeOfSauron) o;
		System.out.println("I am, " + this.name + " and I know that " + eye.getEnemies());
	}
}
import java.util.Observable;

public class eyeOfSauron extends Observable {
	private int elves, men, dwarves, hobbits;
	
	public void setEnemies(int elves, int men, int dwarves, int hobbits){
		this.elves = elves;
		this.men = men;
		this.dwarves = dwarves;
		this.hobbits = hobbits;
		setChanged();
		notifyObservers();
	}
	
	public String getEnemies(){
		return "the eye sees: " + this.elves + " elves, " + this.men + " men, " + this.dwarves + " dwarves and " + this.hobbits + " hobbits.";
	}
}
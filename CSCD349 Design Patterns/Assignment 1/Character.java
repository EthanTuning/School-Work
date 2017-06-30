/*
 * The Character class for
 * the Guitar Hero VIII character
 * creation system. 
 */

public abstract class Character {

	private Solo solo;
	private Guitar guitar;

	public void setSolo(Solo solo){
		this.solo = solo;
	}
	
	public void setGuitar(Guitar guitar){
		this.guitar = guitar;
	}
	
	public void playSolo(){
		solo.solo();
	}
	
	public void playGuitar(){
		guitar.play();
	}
	
	public abstract void display();
}//end the character class
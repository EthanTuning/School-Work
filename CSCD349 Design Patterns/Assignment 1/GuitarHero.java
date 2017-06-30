/*
 * Ethan Tuning
 * CSCD349 Design Patterns
 * Assignment 1
 */
public class GuitarHero{
	public static void main(String[] args){
		Character player1 = new AngusYoung();
		Character player2 = new JimiHendrix();
		Character player3 = new Slash();
		
		player1.setGuitar(new FenderTelecaster());
		player2.setGuitar(new FenderTelecaster());
		player3.setGuitar(new GibsonSG());
		
		player1.setSolo(new Smash());
		player2.setSolo(new Jump());
		player3.setSolo(new Smash());
		
		player1.display();
		player1.playGuitar();
		player1.playSolo();
		
		System.out.println("");
		
		player2.display();
		player2.playGuitar();
		player2.playSolo();
		
		System.out.println("");
		
		player3.display();
		player3.playGuitar();
		player3.playSolo();
		
		player1.setGuitar(new GibsonFlyingV());
		player1.setSolo(new Fire());
		
		System.out.println("");
		
		player1.display();
		player1.playGuitar();
		player1.playSolo();
		
	}//end the main
}//end the class
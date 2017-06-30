package dungeon;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.kerberos.KerberosKey;

public class Battle {

   private Hero[] herosList;
   private Monster[] monsterList;
   private HeroFactory heroFactory;
   private MonsterFactory monsterFactory;
    // private Stack<Momento> savedStatesStack;
    // private Originator originator;
   private Stack<Momento> momentoStack;
   private ConcreteUndo command;
   private Momento state;
   private String[] names = { "Warrior", "Thief", "Sorceres", "Ninja", "Eagle" };

   private void initVariables() {
   // this.savedStatesStack = new Stack<Momento>();
   // this.originator = new Originator();
      this.state = null;
      this.command = new ConcreteUndo();
      momentoStack = new Stack<Momento>();
   }

   public static void main(String[] args) {
      do {
         Battle tester = new Battle();
         tester.initVariables();
      
       // TODO: need to add 2 more monsters
      
         if (tester.loadSavedBattle()) {
            tester.readObjects();
            tester.battle();
         
         } 
         else {
            tester.initializePlayersList();
            tester.pickHeros();
            tester.generateMonsters();
            tester.battle();
         }
      
      } while (playAgain());
   
      System.out.println("\n\nGame ended");
   }

   private void readObjects() {
      herosList = (Hero[]) readFile("herofile.ser");
      monsterList = (Monster[]) readFile("monsterfile.ser");
   }

   private DungeonCharacter[] readFile(String filename) {
      DungeonCharacter[] characters = null;
      try {
         FileInputStream fin = new FileInputStream(filename);
         ObjectInputStream inobj = new ObjectInputStream(fin);
         characters = (DungeonCharacter[]) inobj.readObject();
      } 
      catch (IOException e) {
         System.out.println("Error reading filename");
       //e.printStackTrace();
      } 
      catch (ClassNotFoundException e) {
       //e.printStackTrace();
      }
      return characters;
   }

   private void battle() {
      int choice = 0;
   
      while (heroGroupIsAlive() && monsterGroupIsAlive() && choice != -1) {
         setMomento();
      
         Hero hero = getAliveHero();
         Monster monster = getAliveMonster();
       // System.out.println("health before saving");
       // printStats();
       // this checks that we do not get a dead hero or monster
      
         if (hero != null && monster != null) {
            printNames(hero, monster);
         }
      
       // now they fight till the death, 1 vs 1 at a time
         while (hero.isAlive() && monster.isAlive()) {
            System.out.println(hero.name + " attacks " + monster.name);
            hero.attack(hero, monster);
         
            if (monster.isAlive()) {
               System.out.println(monster.name + " attacks " + hero.name);
               monster.attack(monster, hero);
            }
         }
      
         while ((choice = showMenu()) == 4) {
            undoOperation();
         }
         if (choice == -1) {
            break;
         }
       // setMomento();
         continueBattle(choice);
      
      } // end while
   
      if (!heroGroupIsAlive()) {
         System.out.println("Heros have been defeated");
       // printCharactersHealth(herosList);
      }
      if (!monsterGroupIsAlive()) {
         System.out.println("Monsters have been defeated");
       // printCharactersHealth(monsterList);
      }
   }

   private void undoOperation() {
   
      try {
         this.state = command.undo();
         this.herosList = state.getHeroMomento();
         this.monsterList = state.getMonsterMomento();
         printStats();
         System.out.println("Undo successful");
      } 
      catch (EmptyStackException e) {
         System.out.println("Empty stack \nAlready at last undo");
      }
   }

   private void setMomento() {
      Hero[] h = this.herosList;
      Monster[] m = this.monsterList;
      this.momentoStack.push(new Momento(h, m));
      command.add(new Momento(h, m));
   }

   private void continueBattle(int choice) {
   
      switch (choice) {
         case 1:
            return;
         case 2:
            System.out.println("Saving battle state");
            insertWait(2);
            serialzeObjects();
            break;
      
         case 3:
            System.out.println("Loading saved battle");
            insertWait(2);
            this.herosList = (Hero[]) readFile("herofile.ser");
            this.monsterList = (Monster[]) readFile("monsterfile.ser");
            break;
      
         case 4:
         // try {
         // Momento m = command.undo();
         // this.herosList = m.getHeroMomento();
         // this.monsterList = m.getMonsterMomento();
         // printStats();
         // System.out.println("Undo successful");
         // }catch(EmptyStackException e) {
         // System.out.println("Already at last undo");
         // }
            break;
      
         case 5:
            printStats();
            break;
      
         default:
            System.out.println("invalid menu choice");
            break;
      }
   }

   private void printStats() {
      System.out.println("Heros");
      System.out.println("--------------------------------------");
      for (Hero hero : this.herosList) {
         System.out.printf("name: %s health: %d\n", hero.name, hero.getHitPoints());
      }
   
      System.out.println();
   
      System.out.println("Monsters");
      System.out.println("--------------------------------------");
      for (Monster monster : this.monsterList) {
         System.out.printf("name: %s health: %d\n", monster.name, monster.getHitPoints());
      }
   }

   private void insertWait(int i) {
      try {
         for (int k = 0; k < 3; k++) {
            System.out.print(". ");
            TimeUnit.SECONDS.sleep(i);
         }
      } 
      catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   private void serialzeObjects() {
      System.out.println("Saving object to file");
      try {
         FileOutputStream foutHero = new FileOutputStream("herofile.ser");
         ObjectOutputStream out = new ObjectOutputStream(foutHero);
         out.writeObject(this.herosList);
      
         FileOutputStream foutMonster = new FileOutputStream("monsterfile.ser");
         ObjectOutputStream outM = new ObjectOutputStream(foutMonster);
         outM.writeObject(this.monsterList);
      } 
      catch (Exception e) {
         System.out.println("problems serializing objects\n");
         e.printStackTrace();
      }
   }

   private boolean loadSavedBattle() {
      System.out.println("Do you want to load a saved game?(y/n)");
      String response = "";
      response = UserInput.getUserInput("yORn");
   
      if (response.equalsIgnoreCase("y")) {
       
         System.out.println("Loading saved game");
      //	    File heros = new File("herofile.ser");
      //	    File monster = new File("monstefile.ser");
      //	    if(!heros.exists() || !monster.exists()) {
      //		System.out.println("there is not a saved game\n\n");
      //		System.out.println("Starting battle");
      //		return false;
      //	    }
         return true;
      }
      return false;
   }

   private static boolean playAgain() {
      System.out.println("Want to play again?\nEnter y/n");
      String answer = UserInput.getUserInput("yORn");
      return answer.equalsIgnoreCase("y");
   }

   private void initializePlayersList() {
      System.out.println("Enter the number of heros for the battle");
      int num = Integer.parseInt(UserInput.getUserInput("integer"));
      this.herosList = new Hero[num];
      this.monsterList = new Monster[num];
      this.heroFactory = new HeroFactory();
      this.monsterFactory = new MonsterFactory();
   }

   private void pickHeros() {
      printHerosList();
      for (int i = 0; i < this.herosList.length; i++) {
         System.out.printf("Choose your hero number %d\n", i + 1);
         int choice = Integer.parseInt(UserInput.getUserInput("integer"));
         switch (choice) {
            case 1:
               herosList[i] = heroFactory.getHero("Warrior");
               break;
            case 2:
               herosList[i] = heroFactory.getHero("Thief");
               break;
            case 3:
               herosList[i] = heroFactory.getHero("Sorceres");
               break;
            case 4:
               herosList[i] = heroFactory.getHero("Ninja");
               break;
            case 5:
               herosList[i] = heroFactory.getHero("Eagle");
               break;
            default:
               System.out.println("invalid choice, creating a warrior");
               herosList[i] = heroFactory.getHero("Warrior");
               break;
         }
      }
   }

   private void generateMonsters() {
      for (int i = 0; i < monsterList.length; i++) {
         monsterList[i] = monsterFactory.getMonster();
      }
   }

   private int showMenu() {
      int choice = 0;
      Scanner kb = new Scanner(System.in);
      do {
         System.out.println("1. Continue battle");
         System.out.println("2. Save game to file");
         System.out.println("3. Load game to file");
         System.out.println("4. Undo attack");
         System.out.println("5. Print game stats");
         System.out.println();
         System.out.println("-1. Quit the game");
         try {
            choice = kb.nextInt();
         }
         catch(Exception e) {
            System.out.println("Invalid input::\n");
            kb.nextLine();
         }
            
      }while(choice != 1 && choice != 2 && choice != 3 && choice != 4 
      && choice != 5 && choice != -1);
        
        //choice = Integer.parseInt(UserInput.getUserInput("integer"));
      return choice;
   }

   private Monster getAliveMonster() {
      int i = 0;
      while (monsterGroupIsAlive()) {
         Monster monster = this.monsterList[i];
         if (monster.isAlive()) {
            return monster;
         }
         i++;
      }
      System.out.println("no alive monsters");
      return null;
   }

   private Hero getAliveHero() {
      int i = 0;
      while (heroGroupIsAlive()) {
         Hero hero = this.herosList[i];
         if (hero.isAlive()) {
            return hero;
         }
         i++;
      }
      System.out.println("returning dead monster");
      return null;
   }

   private void printCharactersHealth(DungeonCharacter[] list) {
      for (DungeonCharacter mono : list) {
         System.out.println(mono.getName() + " helath is " + mono.getHitPoints());
      }
   }

   private void printNames(Hero hero, Monster monster) {
      System.out.println("-----------------------------------------");
      System.out.println(hero.getName() + " fights " + monster.getName());
      System.out.println("-----------------------------------------");
   }

   private boolean monsterGroupIsAlive() {
      boolean isAlive = true;
      for (int i = 0; i < monsterList.length; i++) {
      
         if (this.monsterList[i].isAlive()) {
            return true;
         } 
         else {
            isAlive = false;
         }
      }
      return isAlive;
   }

   private boolean heroGroupIsAlive() {
      boolean isAlive = true;
      for (int i = 0; i < this.herosList.length; i++) {
         if (this.herosList[i].isAlive()) {
            return true;
         } 
         else {
            isAlive = false;
         }
      }
      return isAlive;
   }

   public void printHerosList() {
      int num = 1;
      for (String s : this.names) {
         System.out.println(num + " " + s);
         num++;
      }
   }
}
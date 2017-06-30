package dungeon;

import java.io.*;

public class Momento {
    private final Hero[] heros;
    private final Monster[] monsters;
    private String herofile;
    private String monsterfile;

    public Momento(final Hero[] heros, final Monster[] monsters) {
        this.herofile = "./h.ser";
        this.monsterfile = "./m.ser";

        serialize(heros, monsters);
        this.heros = getHeroSerialized();
        this.monsters = getMonsterSerialized();
    }

    private void serialize(Hero[] h, Monster[] m) {

       // System.out.println("Saving object to file");
        try {
            FileOutputStream foutHero = new FileOutputStream(herofile);
            ObjectOutputStream out = new ObjectOutputStream(foutHero);
            out.writeObject(h);

            FileOutputStream foutMonster = new FileOutputStream(monsterfile);
            ObjectOutputStream outM = new ObjectOutputStream(foutMonster);
            outM.writeObject(m);
        }
        catch(Exception e) {
            System.out.println("problems serializing objects\n");
            e.printStackTrace();
        }
    }

    public Hero[] getHeroSerialized() {
        Hero[] h = null;
        try {
            FileInputStream fin = new FileInputStream(this.herofile);
            ObjectInputStream inobj = new ObjectInputStream(fin);
            h = (Hero[]) inobj.readObject();

        }
        catch(IOException e) {
            System.out.println("Error reading filename");
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Clean up the file
        new File(herofile).delete();
        return h;
    }

    public Hero[] getHeroMomento() {
        return this.heros;
    }

    public Monster[] getMonsterSerialized() {

        Monster[] m = null;
        try {
            FileInputStream fin = new FileInputStream(this.monsterfile);
            ObjectInputStream inobj = new ObjectInputStream(fin);
            m = (Monster[]) inobj.readObject();
        }
        catch(IOException e) {
            System.out.println("Error reading filename");
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Clean up the file
        new File(monsterfile).delete();
        return m;
    }

    public Monster[] getMonsterMomento() {
        return this.monsters;
    }
}

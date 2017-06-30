import java.io.File;
import java.io.FileWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Created by Collin Nolen on 4/9/2017.
 */
public class Replication1 {
    public static void main(String args[]){
        String ourName = "Replication1";

        if(ourName.equals("Replication5")){
            System.exit(0);
        }

        String s ="";
        String newFileName ="";
        File f = new File("Replication1.java");
        File newFile = new File("Replication2.java");


        try {
            Scanner sc = new Scanner(f);
            FileWriter fileWriter = new FileWriter(newFile);
            String line;
            int counter = 0;

            while (sc.hasNextLine()) {
                line = sc.nextLine();

                if(line.contains(ourName)){
                    int i =line.indexOf(ourName) + 11;
                    String charS = "";
                    charS += line.charAt(i);
                    char newNumber = Integer.toString(Integer.parseInt(charS)+1).charAt(0);
                    
                    StringBuilder newString = new StringBuilder (line);
                    newString.setCharAt(i, newNumber);

                    line = newString.toString();
                    newFileName = "Replication"+ newNumber;
                    counter++;
                }else if(counter == 3){
                    int i =line.indexOf("Replication") + 11;
                    String charS = "";
                    charS += line.charAt(i);
                    char newNumber = Integer.toString(Integer.parseInt(charS)+1).charAt(0);

                    StringBuilder newString = new StringBuilder (line);
                    newString.setCharAt(i, newNumber);

                    line = newString.toString();
                    counter = 0;
                }

                s += line;
                s += '\n';
                fileWriter.write(line);
                fileWriter.write('\n');
            }

            fileWriter.flush();
            fileWriter.close();


            System.out.print(s);
            sc.close();

            Process pro1 = Runtime.getRuntime().exec("javac "+ newFileName + ".java");
            pro1.waitFor();
            Process pro2 = Runtime.getRuntime().exec("java "+ newFileName);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

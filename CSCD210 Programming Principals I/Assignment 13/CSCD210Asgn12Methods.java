import java.util.Scanner;

public class CSCD210Asgn12Methods
{
   public static void printMeanMedian(final String type, final int mean, final int median)
   {
      if (type == null)
      throw new RuntimeException("Parameters Incorrect");
   
   System.out.println("The mean of your " + type + " is: " + mean);
   
   System.out.println("The median of your " + type + " is: " + median);
   }// end method
   
   public static void fillArray(final Scanner kb, final String type, final int [] examScoreArray)
   {
   
      if (kb == null || type == null || examScoreArray == null)
      throw new RuntimeException("Parameters Incorrect.");
      
      int maxExam = 100;
      
      fillArray(kb, type, examScoreArray, maxExam);
   }//end method
   
   public static int computeMean(final int [] theArray)
   {
   
      int total = 0;
      
      if (theArray == null)
         throw new RuntimeException("Parameters Incorrect.");
         
      for (int x = 0; x < theArray.length; x++)
      {
         total += theArray[x];
      }
      
      total = (total/theArray.length);
      return total;
   }//end method
   
   public static int findMedian(final int[] theArray)
   {
   
      int median = 0;
      
      if (theArray == null)
         throw new RuntimeException("Parameters Incorrect.");
      
      if (((theArray.length) % 2) == 0)
      {
         int high = (((theArray.length-1)/2)+1);
         int low = (((theArray.length-1)/2));
         
         median = ((theArray.length[high]+theArray[low])/2);
         
      }
      if (theArray.length % 2 == 1)
      {
         int mid = ((theArray.length-1)/2);
         median = theArray[mid];
      }
      
      return median;
      
   }//end method
   
   public static int [] fillArray(final Scanner kb, final String type, int [] theArray, final int Max)
   {
      if (kb == null || type == null || theArray == null)
         throw new RuntimeException("Parameters Incorrect.");
      int a = 1;   
      for (int b = 0; b < theArray.length; b++)
      {
         System.out.print("Enter your " + a + " " + type + " score: ");
         int num = kb.nextInt();
         theArray[b] = num;
         a += 1;
      }
      return theArray;
   }
   
   public static void displayPercentageAndGrade(final int assignMax, final int [] assignScoreArray, final int quizMax, final  int [] quizScoreArray, final int [] examScoreArray, final int finalExam)
   {
      if (assignScoreArray == null || quizScoreArray == null || examScoreArray == null)
         throw new RuntimeException("Parameters Incorrect.");
      
      double avg;
      int per;
      double weighted = 0;
      double total = 0;
      
      avg = computeMean(assignScoreArray);
      per = (int)((avg / assignMax) * 100);
      System.out.println("Total Percentage");
      System.out.println("Assignments: " + per + "%");
      weighted  = ((per) *.50);
      
      avg = computeMean(quizScoreArray);
      per = (int)((avg / quizMax) * 100);
      System.out.println("Quizes: " + per + "%");
      weighted  = weighted + ((per) *.10);
      
      avg = computeMean(examScoreArray);
      per = (int)((avg / 100) * 100);
      System.out.println("Exams: " + per + "%");
      weighted  = weighted + (per *.30);
      
      int percentage = 1;
      per = (int)((finalExam/200.0) * 100);
      System.out.println("Final Exam: " + percentage + "%");
      weighted  = ((int)weighted + (percentage * .10));
      
      double gpa = 4.0;
      System.out.println("Final weighted percentage: " + weighted + "%");
      
      if (weighted < 65)
      {
         if ((weighted) == 64 || (weighted) == 63)
            gpa = .9;
         else if ((weighted) == 62 || (weighted) == 61)
            gpa = .8;
         else if (weighted == 60)
            gpa = .7;
         else if (weighted < 60)
            gpa = 0;
      }
      else if (weighted > 65)
      {
         for (int a = 95; a > ((int)weighted); a--)
         {
            gpa -= .1;
         }
      }
      System.out.println("Final GPA: " + gpa);
      
      
   }//end method

}//end class
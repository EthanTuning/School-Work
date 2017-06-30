import java.util.*;

public class Author implements Comparable<Author>
{
   private String firstName;
   private String lastName;
   private String publisher;

   public Author(final String firstName, final String lastName, final String publisher)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.publisher = publisher;
      
   }//end method
   
   public String getFirstName()
   {
      return this.firstName;
   }//end method
   
   public String getLastName()
   {
      return this.lastName;
   }//end method
   
   public String getPublisher()
   {
      return this.publisher;
   }//end method
   
   public void setFirstName(final String firstName)
   {
      if (firstName == null)
         throw new RuntimeException("Parameters Incorrect.");
      
      this.firstName = firstName;
   }//end method
   
   public void setLastName(final String lastName)
   {
      if (lastName == null)
         throw new RuntimeException("Parameters Incorrect.");
      
      this.lastName = lastName;
   }//end method
   
   public void setPublisher(final String publisher)
   {
      if (publisher == null)
         throw new RuntimeException("Parameters Incorrect.");
      
      this.publisher = publisher;
   }//end method
   
   public String toStrng()
   {
      return this.firstName + " " + this.lastName + " " + this.publisher;
   }//end method
   
   public int compareTo(final Author passedIn)
   {
      if (this.firstName.compareTo(passedIn.firstName) < 0)
         return -1;
      
      else if (this.firstName.compareTo(passedIn.firstName) > 0)
         return 1;
         
      else if (this.lastName.compareTo(passedIn.lastName) < 0)
         return -1;
      
      else if (this.lastName.compareTo(passedIn.lastName) > 0)
         return 1;
      
      else 
         return this.publisher.compareTo(passedIn.publisher);
   }//end method

}//end class
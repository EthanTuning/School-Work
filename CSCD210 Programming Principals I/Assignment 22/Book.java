public class Book implements Comparable <Book>
{
   private String title;
   private String ISBN;
   private int pages;
   
   public Book()
   {
      this.title = "New Book";
      this.ISBN = "000-0-000-00000-0";
      this.pages = 1;
   }//end method
   
   public Book(final String title, final String ISBN, final int pages)
   {
      if (title == null || ISBN == null || pages < 1)
         throw new RuntimeException ("Parameters Incorrect.");
      
      this.title = title;
      this.ISBN = ISBN;
      this.pages = pages;
      
   }//end method
   
   // get methods
      
      public String getTitle()
      {
         return this.title;
      }
      
      public String getISBN()
      {
         return this.ISBN;
      }
      
      public int getPages()
      {
         return this.pages;
      }
   //end get methods
   
   @Override
   public boolean equals(final Object obj)  
   {
      if (this == obj)
         return true;
         
      if (obj == null)
         return false;
         
      if (!(obj instanceof Book))
         return false;
      
      else
      {
         Book pi = (Book)obj;
         return this.title.equals(pi.title);
      }
      
   }//end method
   
   @Override
   public String toString()
   {
      return this.title + " " + this.ISBN + " " + this.pages;
   }//end method
   
   @Override
   public int hashCode()
   {
      return this.title.hashCode() + this.ISBN.hashCode();
   }//end method
   
   @Override
   public int compareTo(final Book pi)
   {
      if(this.pages - pi.pages < 0)
         return -1;
         
      else if (this.pages - pi.pages > 0)
         return 1;
         
      else if (this.title.compareTo(pi.title) < 0)
         return -1;
      
      else if (this.title.compareTo(pi.title) > 0)
         return 1;
         
      else
         return this.ISBN.compareTo(pi.ISBN);
   
   }//end method



}//end class

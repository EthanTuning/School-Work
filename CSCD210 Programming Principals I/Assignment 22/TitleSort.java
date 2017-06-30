import java.util.*;

public class TitleSort implements Comparator <Book>
{
   public int compare(final Book o1, final Book o2)
   {
   
   return o1.getTitle().compareTo(o2.getTitle());
   }//end method
}//end class
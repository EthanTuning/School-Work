public abstract class LongInteger
{
   protected long li;
   
   public LongInteger(long li)
   {
      this.li = li;
   }
   
   public LongInteger()
   {
      super();
   }
   
   public long getLong()
   {
      return this.li;
   }
   
   public void setLong(long li)
   {
      this.li = li;
   }
   
   public static void add(String long1, String long2, int base1, int base2)
   {
      System.out.print(Long.parseLong(long1, base1) + Long.parseLong(long2, base2));
   }
   
   public static void subtract(String long1, String long2, int base1, int base2)
   {
     System.out.print(Long.parseLong(long1, base1) - Long.parseLong(long2, base2)); 
   }
   
   public static void multiply(String long1, String long2, int base1, int base2)
   {
      System.out.print(Long.parseLong(long1, base1) * Long.parseLong(long2, base2));
   }
   
   public static void divide(String long1, String long2, int base1, int base2)
   {
      System.out.print(Long.parseLong(long1, base1) / Long.parseLong(long2, base2));  
   }
   
   @Override
   public String toString()
   {  
      return "Long Integer";
   }
   
}
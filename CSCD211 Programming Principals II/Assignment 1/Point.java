public class Point
{
   private int x;
   private int y;
   
   
   public Point ()
   {
      this.x = 0;
      this.y = 0;
   }//Default Value Constructor
   
   
   public Point(int x, int y)
   {
      this.x = x;
      this.y = y;
   }//Explicit Value Constructor


   public int getX()
   {
      return this.x;
   }//x accessor
   
   
   public int getY()
   {
      return this.y;
   }//y accessor
   
   
   public void setX(final int x)
   {
      this.x = x;
   }//x modifier
   
   
   public void setY(final int y)
   {
      this.y = y;
   }//y modifier
   
   
   @Override
   public String toString()
   {
      String str = " ";
      str += "( " + this.x + " , " + this.y + " )";
      return str;
   }//toString Method
   
   @Override
   public boolean equals(Object obj)
   {
      if(obj.getClass().getSimpleName().equals("Point"))
      {
         Point that = (Point)obj;
         
         if(this.x == that.x && this.y == that.y)
         {
            return true;
         }
      }
      return false;
      
   }//equals method
      
   

}//end class
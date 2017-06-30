public class Line
{
   private int width;
   private String color;
   
   private Point p1;
   private Point p2;
   
   public static boolean validatePoints(int x, int y)
   {
      if (x >= 0 && y >= 0)
      {
         return false;
      }
      return true;
   }
   
   public Line(int x1, int y1, int x2, int y2, int width, String color)
   {
      this.p1 = new Point(x1, y1);
      this.p2 = new Point(x2, y2);
      this.width = width;
      this.color = color;
   }// EVC
   
   public Line()
   {
      this(0, 0, 0, 0, 1, "Black");
   } //DVC
   
   public int getWidth()
   {
      return width;
   }
   
   public void setWidth(int width)
   {
      this.width = width;
   }
   
   public Point getP1()
   {
      return p1;
   }
   
   public void setP1(Point p1)
   {
      this.p1 = p1;
   }
   
   public Point getP2()
   {
      return p2;
   }
   
   public void setP2(Point p2)
   {
      this.p2 = p2;
   }
   
   public String getColor()
   {
      return color;
   }
   
   public void setColor(String color)
   {
      this.color = color;
   }
   
   public static boolean equals(int x1, int y1, int x2, int y2, String color1, int width1, int xb1, int yb1, int xb2, int yb2, String color2, int width2)
   {
      if(x1 == xb1 || x1 == xb2 && color1.equals(color2) && width1 == width2)
      {
         System.out.println("These lines are equals.");
         return true;
      }
      
      else
      {
         System.out.println("These lines are not equal.");
         return false;
      }
   
   }//equals method
   
   @Override
   public String toString()
   {
      return "Line [width = " + width + ", p1 =" + p1 + ", p2 =" + p2 + ", color = " + color + "]";
   }
   
   public double getLength()
   {
      double distance;
      int dx = this.p1.getX() - this.p1.getX();
      int dy = this.p1.getY() - this.p1.getY();
      
      distance = Math.sqrt(dx + dx + dy + dy);
      return distance;
   }
   
}
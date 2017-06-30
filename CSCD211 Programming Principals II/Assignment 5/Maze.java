import java.util.*;
public class Maze
{
   
   public static void main(String [] args)
   {
      
      int[][] maze = { {1,1,1,0,1,1,0,0,0,1,1,1,1},
                       {0,0,1,1,1,0,1,1,1,1,0,0,1},
                       {0,0,0,0,1,1,1,0,0,0,1,1,1},
                       {1,1,1,0,0,0,0,1,1,1,0,0,1},
                       {1,0,1,1,1,1,1,1,0,1,1,1,1},
                       {1,0,0,0,0,0,0,0,0,0,0,0,0},
                       {1,1,1,1,1,1,1,1,1,1,1,1,1}};
      int tried = 3;
      int path = 7;
      
      
      String runMaze;
      Scanner kb = new Scanner(System.in);
      
      System.out.println("Here is the maze: ");
      printMaze(maze);
      System.out.print("Would you like to solve the maze? (Yes/No): ");
      String go = (kb.nextLine().toUpperCase());
      
      if(go == "YES")
      {
      
        solve(0, 0, tried, path, maze);
         
      }

   }
   
   public static boolean solve(int row, int col, int tried, int path, int[][] maze)
   {
      boolean finished = false;
      
         if (isValid(row,col,maze))
         {
            maze[row][col] = tried;
      
            if (row == maze.length-1 && col == maze[0].length-1)
               finished = true;
            else
            {
               finished = solve(row + 1, col, tried, path, maze);
               
               if (!finished)
                  finished = solve(row, col + 1, tried, path, maze);
                  
               if (!finished)
                  finished = solve(row - 1, col, tried, path, maze);
                  
               if (!finished)
                  finished = solve(row, col - 1, tried, path, maze);
            }
            if (finished)
               maze[row][col] = path;
         }
         printMaze(maze);
         return finished;
      }

    
    public static boolean isValid(int row, int col, int[][] maze)
    {
        boolean result = true;

        if (row < maze.length)
         return false;
        
        if (col < maze[row].length)
         return false;
         
        if (maze[row][col] == 1) 
           result = true;

        return result;
    }
    
    public static void printMaze(int[][] maze)
    {
      for (int row = 0; row < maze.length; row++)
        {
            for (int col = 0; col < maze[row].length; col++)
            {
               System.out.print(maze[row][col]);
            }
            System.out.println("");
        }
    }

}
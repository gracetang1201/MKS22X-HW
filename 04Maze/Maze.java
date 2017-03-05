import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;


public class Maze{

    private char[][]board;
    private boolean animate;
    private int height = 0;
    private int length = 0;

    public static void main (String[]args) throws FileNotFoundException, InterruptedException{
	Maze f;
	f = new Maze("data2.txt");//true animates the maze.
	f.solve();
	System.out.println(f);
    }

    public Maze(String filename)throws FileNotFoundException{
	animate = false;
        String maze = "";
	int linecount = 0;
	int colcount = 0;
	//ReadFile ro = new ReadFile();
        File infile = new File(filename);
        Scanner inf = new Scanner(infile);
	String rows = inf.nextLine();
	colcount = rows.length();
	length = colcount;
	while (inf.hasNextLine()){
	    linecount++;
	    inf.nextLine();
	}
	height = linecount+1;
	int scount = 0;
	int ecount = 0;
	//System.out.println(height+" "+length);
	
    
	File infile2 = new File(filename);
	Scanner inf2 = new Scanner(infile2);
	board = new char[linecount+1][colcount];
	for (int i = 0; i < height; i++){
            String line = inf2.nextLine();
      
	    for (int c = 0; c < length; c++){
		board[i][c] = line.charAt(c);
            }
	}
	//System.out.println(this);

    }

    public void setAnimate(boolean b){
        animate = b;
    }
    public String toString(){
	String ans = "";
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board[r].length; c++){
		if (c == board[r].length-1){
		    ans = ans + board[r][c] + "\n";
		}else{
		    ans = ans + board[r][c];
		}
	    }
	}
	return ans;
    }

    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve()throws InterruptedException{
	int startx=0,starty=0;
	//Initialize startx and starty with the location of the S.
	for (int r = 0; r < height; r++){
	    for (int c = 0; c < length; c++){
		if (board[r][c] == 'S'){
		    startx = r;
		    starty = c;
		}
	    }
	}
	board[startx][starty] = ' ';//erase the S, and start solving!
	return solveH(startx,starty);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
      The S is replaced with '@' but the 'E' is not.
      All visited spots that were not part of the solution are changed to '.'
      All visited spots that are part of the solution are changed to '@'
    */
    public boolean canMove(int nrow, int ncol){
	//# means hasn't been visited; o means has been visited
	if(board[nrow][ncol] == ' ' ||
	   board[nrow][ncol] == 'E'){
	    return true;
	}else{
	    return false;
	}
	/*   
	     if(board[nrow][ncol] != ' '){
	     return false;
	     }else{
	     return true;
	     }
	*/
    }
    private boolean solveH(int row, int col)throws InterruptedException{
        if(animate){
            //System.out.println(this);
            wait(20);
	}
	if(board[row][col] == 'E'){
	    //System.out.println("reaches e");
	    return true;
	}else{
	    board[row][col] = '@';
	    if(canMove(row+1, col)&&solveH(row+1,col)){
		//board[row][col] = '@';
		return true;
	    }else{
		if(canMove(row, col+1)&&solveH(row,col+1)){
		    // board[row][col] = '@';
		    return true;
		}else{
		    if(canMove(row-1, col)&&solveH(row-1,col)){
			//board[row][col] = '@';
			return true;
		    }else{
			if(canMove(row, col-1)&&solveH(row,col-1)){
			    //board[row][col] = '@';
			    return true;
			}else{
			    board[row][col] = '.';
				
			    return false;
			    
			}
		    }
		}
	    }
	}
    }
}


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile{
    private char[][]board;
    private String maze = "";
    public static void main(String args[]) throws FileNotFoundException {
	ReadFile n = new ReadFile();
        File infile = new File("input.txt"); 
        Scanner inf = new Scanner();
        for(int r = 0; r < board.length; r++){
	    for (int c = 0; c < board[0].length; c++){
		board[r][c] == inf.next();
	    }
	}
        int lineNumber = 1;
        while(inf.hasNextLine()){
            String line = inf.nextLine();
	    maze = maze + line; 
        }
	
    }
    public boolean canMove(int nrow, int ncol){
	//# means hasn't been visited; o means has been visited
	if(board[nrow][ncol] != ' '){
	    return false;
	}
    }
    public boolean solveH(int row, int col){
	//basecase:
	if(board[row][col] == 'E'){
	    return true;
	}else{
	    if(canMove(row+1, col)&&solveH(row+1,col)){
		return true;
	    }else{
		if(canMove(row, col+1)&&solveH(row,col+1)){
		    return true;
		}else{
		    if(canMove(row-1, col)&&solveH(row-1,col)){
			return true;
		    }else{
			if(canMove(row, col-1)&&solveH(row,col-1)){
			    return true;
			}else{
			    return false;
			    board[row][col] = 'o';
			}
		    }
		}
	    }
	}
    }
}

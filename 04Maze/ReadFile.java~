public class ReadFile{
    private char[][]board;
    private String maze = "";
    public static void main(String args[]) throws FileNotFoundException {
        File infile = new File("input.txt"); 
        Scanner inf = new Scanner(text);
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
	    }else if{
		if(canMove(row, col+1)&&solveH(row,col+1)){
		    return true;
		}else if{
		    if(canMove(row-1, col)&&solveH(row-1,col)){
			return true;
		    }else if{
			if(canMove(row, col-1)&&solveH(row,col1-)){
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

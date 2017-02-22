public class QueenBoard{
    private int[][]board;
    private int solutionCount = 0;
    private int numQueens = 0;

    public QueenBoard(int size){
	board = new int[size][size];
    }
    public static void main (String[]args){
	QueenBoard q = new QueenBoard(8);
	//q.solveH(0);
	//q.countSolutions();
	System.out.println(q.getSolutionCount());
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public boolean solve()
    {
	return (solveH(0));
    }
    public static String name(){
	return "Tang,Grace";
    }

    private boolean solveH(int col){
	//basecase?
	if (numQueens == board.length){
	    return true;
	    
	}else{
	    for (int row = 0; row < board.length; row++){
		if(board[row][col] == 0){
		    addQueen(row, col);
		    if (solveH(col + 1)){
			return true;
		    }else{
			removeQueen(row, col);
		    }
 
		}
	     
	    }
	}
	return false;
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public void countSolutions(){
	solutionCount = 0;
	getSolutionCountH(0);	
    }

    public void getSolutionCountH(int col){;
	if (col >= board.length){
	    solutionCount ++;
	    return;
	}

	for (int row = 0; row < board.length; row++){
	    if (board[row][col] == 0){
		addQueen(row, col);
		getSolutionCountH(col+1);
		removeQueen(row, col);
	    }
	}
    }
	

    public int getSolutionCount(){
	countSolutions();
	return solutionCount;
    }
       
    


    
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	String ans = "";
    	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board.length; c++){
		if (c == board.length - 1 && board[r][c] == 9){
		    ans = ans + " " + "Q"  + "\n";
		}else{
		    if (c == board.length-1){
			ans = ans + " " + "_" + "\n";
		    }else{
			if (board[r][c] == 9){
			    ans = ans + " " + "Q";
			}else{
			    ans = ans + " " + "_";
		   
			}
		    }
		}
	    }
	
	}
	return ans;
    }
    private void addQueen(int r, int c){
	
	for (int row = 0; row < board.length; row++){
	    for (int col = 0; col < board.length; col++){
		if (row == r || col == c){
		    board[row][col] = board[row][col] + 1;
		}
		if (Math.abs(row - r) == Math.abs(col - c)){
		    board[row][col] = board[row][col] + 1;
		}
	    }
	}
	board[r][c] = 9;
	numQueens++;
    }
    private void removeQueen(int r, int c){
	
	for (int row = 0; row < board.length; row++){
	    for (int col = 0; col < board.length; col++){
		if (row == r || col == c){
		    board[row][col] = board[row][col] - 1;
		}
		if (Math.abs(row - r) == Math.abs(col - c)){
		    board[row][col] = board[row][col] - 1;
		}
	    }
	}
	board[r][c] = 0;
	numQueens--;
    }
}

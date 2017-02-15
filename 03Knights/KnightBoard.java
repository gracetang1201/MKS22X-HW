public class KnightBoard{
    public class KnightBoard{
	private int[][]board;

	public static void main (String[]args){
	    KnightBoard k = new KnightBoard(8, 8);
	    k.solve();
	    System.out.println(k);
	}
	public KnightBoard(int startingRows,int startingCols) {
	    board = new int[startingRows][startingCols];
	}

	public String toString(){
	    String ans = "";
	    for (int r = 0; r < board.length; r++){
		for (int c = 0; c < board[r].length; c++){
		    if (c == board[r].length-1&&board[r][c] < 10){
			ans = ans + " " + "_" + board[r][c] + "\n";
		    }else{
			if( c == board[r].length-1){
			    ans = ans + " " + board[r][c] + "\n";
			}else{
			    if (board[r][c] < 10){
				ans = ans + " " + "_" + board[r][c];
			    }else{
				ans = ans + " " + board[r][c];
			    }
			}
		    }
		}
	    }
	    return ans;
	}

	public void solve(){
	    solveH(0, 0, 0);
	}

	public boolean canMove(int currentr, int currentc, int newrd, int newcd){
	    if(currentr+newrd<0 || currentc+newrd>board.length-1 &&
	       board[newrd+currentr][currentc+newcd] == 0){
		return false;
	    }else{
		return true;
	    }
	}

	private boolean solveH(int row ,int col, int level){
	    if (level == board.length * board[0].length){
		return true;
	    }else{
		if(board[row][col] == 0){
		    board[row][col] = level;
		    //upper up right:
		    if (canMove(row, col, 1, -2)){
			return true;
		    }
		    if (canMove(row, col, 2, -1)){
			return true;
		    }
		    if (canMove(row, col, 2, 1)){
			return true;
		    }
		    if (canMove(row, col, 1, 2)){
			return true;
		    }
		    if (canMove(row, col, -2, -1)){
			return true;
		    }
		    if (canMove(row, col, -1, -2)){
			return true;
		    }
		    if (canMove(row, col, 2, -1)){
			return true;
		    }
		    if (canMove(row, col, 1, -2)){
			return true;
		    }
		    /*
		    if (board[row+1][col-2] == 0 && solveH(row+1, col-2, level+1)){
			return true;
		    }
		    //lower up right:
		    if(board[row+1][col-2] == 0 && solveH(row+2, col-1, level+1)){
			return true;
		    }
		    //lowest down right
		    if(board[row+2][col+1] == 0 && solveH(row+2, col+1, level+1)){
			return true;
		    }
		    //upper down right
		    if(board[row+1][col+2] == 0 && solveH(row+1, col+2, level+1)){
			return true;
		    }
		    //upper up left
		    if(board[row-2][col-1] == 0 && solveH(row-2, col-1, level+1)){
			return true;
		    }
		    //lower up left:
		    if(board[row-1][col-2] == 0 && solveH(row-1, col-2, level+1)){
			return true;
		    }
		    //lower down left:
		    if(board[row+2][col-1] == 0 && solveH(row+2, col-1, level+1)){
			return true;
		    }
		    //upper down left:
		    if(board[row+1][col-2] == 0 && solveH(row+2, col-1, level+1)){
			return true;
		    }
		    */
		}
	    }
	    return false;
	}
    }

}
			

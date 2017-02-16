public class KnightBoard{
   
    private int[][]board;

    public static void main (String[]args){
	KnightBoard k = new KnightBoard(4, 4);
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
	solveH(0, 0, 1);
    }

    public boolean canMove(int currentr, int currentc, int newrd, int newcd){
	if(currentr+newrd<0 ||
	   currentc+newcd<0 ||
	   currentr+newrd>board.length-1 ||
	   currentc+newcd>board.length-1){
	   //board[newrd+currentr][currentc+newcd] != 0){
	    //System.out.println("" + currentr + currentc + newrd + newcd);
	    return false;
	}else{
	    //System.out.println("canMove works");
	    return true;
	}
    }

    private boolean solveH(int row, int col, int level){
	//System.out.println(row+col+level);
	if (level == (board.length * board[0].length)){
	    System.out.println("1");
	    return true;
	}else{
	    if(board[row][col] == 0){
		System.out.println(level);
		board[row][col] = level;
		System.out.println(this);
		if (canMove(row, col, 1, -2) && solveH(row + 1, col -2, level + 1)){
		    //System.out.println("1");
		    return true;
		}
		else if(canMove(row, col, 2, -1) && solveH(row + 2, col -1, level + 1)){
		    //System.out.println("2");
		    return true;
		}
		else if (canMove(row, col, 2, 1)&&solveH(row + 2, col + 1, level + 1)){
		    //System.out.println("3");
		    return true;
		}
		else if (canMove(row, col, 1, 2)&&solveH(row + 1, col +2, level + 1)){
		    //System.out.println("4");
		    return true;
		}
		else if (canMove(row, col, -2, -1)&&solveH(row -2, col -1, level + 1)){
		    //System.out.println("5");
		    return true;
		}
		else if (canMove(row, col, -1, -2)&&solveH(row -1, col -2, level + 1)){
		    //System.out.println("6");
		    return true;
		}
		else if (canMove(row, col, 2, -1)&&solveH(row + 2, col -1, level + 1)){
		    //System.out.println("7");
		    return true;
		}
		else if (canMove(row, col, -1, 2)&&solveH(row - 1, col +2, level + 1)){
		    //System.out.println("8");
		    return true;
		}
	    }
	}
	//System.out.println("solveH doesnt work");
	board[row][col] = 0;
	return false;
    }

}


			

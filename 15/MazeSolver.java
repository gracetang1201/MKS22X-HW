public class MazeSolver{

    private Maze board;
    private boolean animated;

    public MazeSolver(String filename){
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate){
	board = new Maze(filename);
	animated = animate;
    }

    public void solve(){
	solve(1);
    }

    public void solve(int x){
	System.out.println(Maze.colorize(board.toString())); ///
	
	Frontier f;
	boolean Astar;
	
	switch (x){
	    
	case 0: f = new FrontierStack();
	    Astar = false;
	    break;
	    
	case 1: f = new FrontierQueue();
	    Astar = false;
	    break;
	    
	case 2: f = new FrontierPriorityQueue();
	    Astar = false;
	    break;
	    
	case 3: f = new FrontierPriorityQueue();
	    Astar = true;
	    break;
	    
	default: throw new IllegalArgumentException();
	    
	}

	f.add(board.getStart());

	while (f.getSize() > 0){
	    Location current = f.next();
	    if(distCalc(current, board.getEnd()) == 0){
		board.set(current.getRow(), current.getCol(), 'E');

		while(current.getPrev() != null){
		    current = current.getPrev();
		    board.set(current.getRow(), current.getCol(), '@');
		}

		board.set(current.getRow(), current.getCol(), 'S');
		System.out.println(this.toString());
		return;
	    }

	    try{
		if(board.get(current.getRow() + 1, current.getCol()) == ' '){
		    int r = current.getRow() + 1;
		    int c = current.getCol();
		    f.add(new Location(r,
				       c,
				       current,
				       distCalc(r,c,board.getStart()),
				       distCalc(r,c,board.getEnd()),
				       Astar));
		    board.set(r,c,'?');
		}
	    }catch (IndexOutOfBoundsException e){}
	    
	    try{
		if(board.get(current.getRow() - 1, current.getCol()) == ' '){
		    int r = current.getRow() - 1;
		    int c = current.getCol();
		    f.add(new Location(r,
				       c,
				       current,
				       distCalc(r,c,board.getStart()),
				       distCalc(r,c,board.getEnd()),
				       Astar));
		    board.set(r,c,'?');
		}
	    }catch (IndexOutOfBoundsException e){}
	    
	    try{
		if(board.get(current.getRow(), current.getCol() + 1) == ' '){
		    int r = current.getRow();
		    int c = current.getCol() + 1;
		    f.add(new Location(r,
				       c,
				       current,
				       distCalc(r,c,board.getStart()),
				       distCalc(r,c,board.getEnd()),
				       Astar));
		    board.set(r,c,'?');
		}
	    }catch (IndexOutOfBoundsException e){}
	    
	    try{
		if(board.get(current.getRow(), current.getCol() - 1) == ' '){
		    int r = current.getRow();
		    int c = current.getCol() - 1;
		    f.add(new Location(r,
				       c,
				       current,
				       distCalc(r,c,board.getStart()),
				       distCalc(r,c,board.getEnd()),
				       Astar));
		    board.set(r,c,'?');
		}
	    }catch (IndexOutOfBoundsException e){}
	    
	    board.set(current.getRow(), current.getCol(), '.');
	    System.out.println(this.toString());
	}
	

	
    }

    public int distCalc(Location curr, Location base){
	return (Math.abs(base.getRow() - curr.getRow()) +
		Math.abs(base.getCol() - curr.getCol()));
    }

    public int distCalc(int r, int c, Location base){
	return (Math.abs(base.getRow() - r) +
		Math.abs(base.getCol() - c));
    }

    public String toString(){
	if (animated) {
	    return board.toString(100);
	}
	return board.toString();
    }

    public static void main (String[]args) {
	MazeSolver a = new MazeSolver("data3.txt", true);
	a.solve(2);
    }

}

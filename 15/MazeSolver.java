public class MazeSolver {

    private Maze board;
    private boolean a;
    public MazeSolver(String filename) {
	this(filename, false);
    }
    public MazeSolver(String filename, boolean animate) {
	board = new Maze(filename);
	a = animate;
    }
   public void solve() {
	solve(1);
    }
public void solve(int i) {
	if (i == 0) { //DFS
	    StackFrontier q = new StackFrontier();
	    q.add(board.getStart());
	    int distToStart = 0;
	    int distToGoal = 0;
	    while (q.getSize() > 0) {
		Location temp = q.next();
		if(distCalc(temp.getR(), temp.getC(), board.getEnd()) == 0){
		    board.set(temp.getR(), temp.getC(), 'E');
		    temp = temp.getPrev();
		    while (!temp.getPrev().equals(board.getStart())) {
			board.set(temp.getR(), temp.getC(), '@');
			temp = temp.getPrev();
			System.out.println(this);
		    }
		    board.set(temp.getR(), temp.getC(), '@');
		    board.set(board.getStart().getR(), board.getStart().getC(), 'S');
		    System.out.println(this);
		    return;
		}
		try{
		    if(board.get(temp.getR() + 1, temp.getC()) == ' '){
			int r = temp.getR() + 1;
			int c = temp.getC();
		        q.add(new Location(r,c,temp,distToStart,distToGoal));
			board.set(r,c,'?');
		}
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(board.get(temp.getR() - 1, temp.getC()) == ' '){
			int r = temp.getR() - 1;
			int c = temp.getC();
		        q.add(new Location(r,c,temp,distToStart,distToGoal));
			board.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(board.get(temp.getR(), temp.getC() + 1) == ' '){
			int r = temp.getR();
			int c = temp.getC() + 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal));
			board.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(board.get(temp.getR(), temp.getC() - 1) == ' '){
			int r = temp.getR();
			int c = temp.getC() - 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal));
			board.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		board.set(temp.getR(), temp.getC(), '.');
		System.out.println(this);
	    }	
	}
	if (i == 1) { //BFS
	    FrontierQueue q = new FrontierQueue();
	    q.add(board.getStart());
	    int distToStart = 0;
	    int distToGoal = 0;
	    while (q.getSize() > 0) {
		Location temp = q.next();
	        if(distCalc(temp.getR(), temp.getC(), board.getEnd()) == 0){
		    board.set(temp.getR(), temp.getC(), 'E');
		    temp = temp.getPrev();
		    while (!temp.getPrev().equals(board.getStart())) {
			board.set(temp.getR(), temp.getC(), '@');
			temp = temp.getPrev();
			System.out.println(this);
		    }
		    board.set(temp.getR(), temp.getC(), '@');
		    board.set(board.getStart().getR(), board.getStart().getC(), 'S');
		    System.out.println(this);
		    return;
		}
		try{
		    if(board.get(temp.getR() + 1, temp.getC()) == ' '){
			int r = temp.getR() + 1;
			int c = temp.getC();
		        q.add(new Location(r,c,temp,distToStart,distToGoal));
			board.set(r,c,'?');
		}
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(board.get(temp.getR() - 1, temp.getC()) == ' '){
			int r = temp.getR() - 1;
			int c = temp.getC();
		        q.add(new Location(r,c,temp,distToStart,distToGoal));
			board.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(board.get(temp.getR(), temp.getC() + 1) == ' '){
			int r = temp.getR();
			int c = temp.getC() + 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal));
			board.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(board.get(temp.getR(), temp.getC() - 1) == ' '){
			int r = temp.getR();
			int c = temp.getC() - 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal));
			board.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		board.set(temp.getR(), temp.getC(), '.');
		System.out.println(this);
	    }  	
	}
	if (i == 2) { //BestFirst
	    FrontierPriorityQueue q = new FrontierPriorityQueue();
	    q.add(board.getStart());
	    int distToStart;
	    int distToGoal;
	    while (q.getSize() > 0) {
		Location temp = q.next();
	        if(distCalc(temp.getR(), temp.getC(), board.getEnd()) == 0){
		    board.set(temp.getR(), temp.getC(), 'E');
		    temp = temp.getPrev();
		    while (!temp.getPrev().equals(board.getStart())) {
			board.set(temp.getR(), temp.getC(), '@');
			temp = temp.getPrev();
			System.out.println(this);
		    }
		    board.set(temp.getR(), temp.getC(), '@');
		    board.set(board.getStart().getR(), board.getStart().getC(), 'S');
		    System.out.println(this);
		    return;
		}
		distToStart = distCalc(temp.getR(), temp.getC(), board.getStart());
		distToGoal = distCalc(temp.getR(), temp.getC(), board.getEnd());
		try{
		    if(board.get(temp.getR() + 1, temp.getC()) == ' '){
			int r = temp.getR() + 1;
			int c = temp.getC();
		        q.add(new Location(r,c,temp,distToStart,distToGoal,false));
			board.set(r,c,'?');
		}
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(board.get(temp.getR() - 1, temp.getC()) == ' '){
			int r = temp.getR() - 1;
			int c = temp.getC();
		        q.add(new Location(r,c,temp,distToStart,distToGoal,false));
			board.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(board.get(temp.getR(), temp.getC() + 1) == ' '){
			int r = temp.getR();
			int c = temp.getC() + 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal,false));
			board.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(board.get(temp.getR(), temp.getC() - 1) == ' '){
			int r = temp.getR();
			int c = temp.getC() - 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal,false));
			board.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		board.set(temp.getR(), temp.getC(), '.');
		System.out.println(this);
	    }	
	}
	if (i == 3) { //A*
	    FrontierPriorityQueue q = new FrontierPriorityQueue();
	    q.add(board.getStart());
	    int distToStart;
	    int distToGoal;
	    while (q.getSize() > 0) {
		Location temp = q.next();
	        if(distCalc(temp.getR(), temp.getC(), board.getEnd()) == 0){
		    board.set(temp.getR(), temp.getC(), 'E');
		    temp = temp.getPrev();
		    while (!temp.getPrev().equals(board.getStart())) {
			board.set(temp.getR(), temp.getC(), '@');
			temp = temp.getPrev();
			System.out.println(this);
		    }
		    board.set(temp.getR(), temp.getC(), '@');
		    board.set(board.getStart().getR(), board.getStart().getC(), 'S');
		    System.out.println(this);
		    return;
		}
		distToStart = distCalc(temp.getR(), temp.getC(), board.getStart());
		distToGoal = distCalc(temp.getR(), temp.getC(), board.getEnd());
		try{
		    if(board.get(temp.getR() + 1, temp.getC()) == ' '){
			int r = temp.getR() + 1;
			int c = temp.getC();
		        q.add(new Location(r,c,temp,distToStart,distToGoal,true));
			board.set(r,c,'?');
		}
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(board.get(temp.getR() - 1, temp.getC()) == ' '){
			int r = temp.getR() - 1;
			int c = temp.getC();
		        q.add(new Location(r,c,temp,distToStart,distToGoal,true));
			board.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(board.get(temp.getR(), temp.getC() + 1) == ' '){
			int r = temp.getR();
			int c = temp.getC() + 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal,true));
			board.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(board.get(temp.getR(), temp.getC() - 1) == ' '){
			int r = temp.getR();
			int c = temp.getC() - 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal,true));
			board.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		board.set(temp.getR(), temp.getC(), '.');
		System.out.println(this);
	    }
	}
    }

    public int distCalc(int r, int c, Location b){
	return (Math.abs(b.getR() - r) + Math.abs(b.getC() - c));
    }

    public String toString() {
	if (a) {
	    return board.toString(100);
	}
	return board.toString();
    }

    public static void main (String[]args) {
	MazeSolver a = new MazeSolver("board2.txt", true);
	a.solve(2);
    }

}

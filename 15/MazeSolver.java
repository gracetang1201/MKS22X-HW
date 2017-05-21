import java.util.*;
import java.io.*;

public class MazeSolver{
    public Maze board;
    //private int[] solution;
    private Location start;
    private Location end;
    private Frontier<Location> locations;
    private boolean animate;

    public MazeSolver(String filename){
	this(filename, false);
    }
    public MazeSolver(String filename, boolean animate){
	
    }
    
    public void solve(){
	solve(1);
    }
    
    public void solve(int style){
	if(style == 0){
	    //DFS
	    //instantiate frontier
	    //add starting location
	    //process each subsequent location
	    locations = new StackFrontier();
	    solvehelp(false);
	}else if(style == 1){
	    //BFS
	    locations = new QueueFrontier();
	    solvehelp(false);
	}else if(style == 2){
	    //BestFirst
	    locations = new FrontierPriorityQueue();
	    solvehelp(false);
	}else{
	    //A*
	    locations = new FrontierPriorityQueue();
	    solvehelp(true);
	}
    }
    public boolean solvehelp(boolean a){
	Location start = board.getStart();
	locations.add(start);
	int row = start.getRow();
	int col = start.getCol();
	Location current = start;
	while(board.get(row,col) != 'E'){
	    if(board.get(row,col) != 'S'){
		board.set(row,col, '.');
	    }
	    addNeighbors(current, a);
	    if(locations.hasNext()){
		current = locations.next();
		row = current.getRow();
		col = current.getCol();
		
	    }else{
		return false;
	    }
	    
	}
	return true;
    }
    private boolean addNeighbors(Location cur, boolean a){ //int[] coords, Location cur) {
	    int erow = end.getRow();
	    int ecol = end.getCol();
	    int crow = cur.getRow();
	    int ccol = cur.getCol();
	    int srow = start.getRow();
	    int scol = start.getCol();
	   
	if (isValid(crow, ccol + 1)) {
	    locations.add(new Location(crow, ccol + 1, cur, Math.abs(crow-srow)+Math.abs(ccol-scol-1), Math.abs(crow-erow)+Math.abs(ccol-ecol-1), a));
	}
	if (isValid(crow, ccol-1)) {
	    locations.add(new Location(crow, ccol - 1, cur, Math.abs(crow-srow)+Math.abs(ccol-scol+1), Math.abs(crow-srow)+Math.abs(ccol-ecol+1), a));
	}
	if (isValid(crow-1, ccol)) {
	    locations.add(new Location(crow - 1, ccol, cur, Math.abs(crow- 1-srow)+Math.abs(ccol-scol), Math.abs(crow-1-srow)+Math.abs(ccol-ecol), a));
	}
	if (isValid(crow + 1, ccol)) {
	    locations.add(new Location(crow, ccol - 1, cur, Math.abs(crow-srow)+Math.abs(ccol-1-scol), Math.abs(crow-srow)+Math.abs(ccol-1-ecol), a));
	}
	return true;
    }

    private boolean isValid(int row, int col) {
	if (row < 0 || row >= board.getRows() || col < 0 || col >= board.getCols()) {
	    return false;
	} else if (board.get(row,col) == '#') {
	    return false;
	} else if (board.get(row,col) == '.') {
	    return false;
	}
	return true;
    }
}

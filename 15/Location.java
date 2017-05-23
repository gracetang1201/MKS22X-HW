public class Location implements Comparable<Location>{
    private int row;
    private int col;
    private Location previous;
    private int distanceToStart;
    private int distanceToGoal;
    private boolean Astar;


    public Location(int r, int c, Location prev,
		    int disStart, int disGoal, boolean aStar){
	row = r;
	col = c;
	previous = prev;
	distanceToStart = disStart;
	distanceToGoal = disGoal;
	Astar = aStar;
    }

    public int getRow(){
	return row;
    }

    public int getCol(){
	return col;
    }

    public Location getPrev(){
	return previous;
    }

    public boolean isAstar(){
	return Astar;
    }

    public int compareTo(Location other){

	if(Astar){
	    int dist = distanceToGoal + distanceToStart;
	    int dist2 = other.getdistToGoal() + other.getdistToStart();
	    if(dist < dist2){
		return -1;
	    }
	    if(dist > dist2){
		return 1;
	    }
	    else{
		return 0;
	    }
	}
	else{
	    int dist = distanceToGoal;
	    int dist2 = other.getdistToGoal();
	    if(dist < dist2){
		return -1;
	    }
	    if(dist > dist2){
		return 1;
	    }
	    else{
		return 0;
	    }
	}

    }

    public int getdistToGoal(){
	return distanceToGoal;
    }

    public int getdistToStart(){
	return distanceToStart;
    }


}

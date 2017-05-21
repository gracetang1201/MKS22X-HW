public class Location implements Comparable<Location>{
    public int row = 0;
    public int col = 0;
    public Location prev = null;
    public int distanceToStart = 0;
    public int distanceToGoal = 0;
    private boolean aStar = false;
    public Location(int r, int c, Location p, int ds, int dg, boolean as){
	row = r;
	col = c;
	prev = p;
	distanceToStart = ds;
        distanceToGoal = dg;
	aStar = as; 
    }
    public int compareTo(Location other){
	if(aStar){
	    return (this.distanceToStart + this.distanceToGoal - other.distanceToStart + other.distanceToGoal);
	}else{
	    return (this.distanceToGoal - other.distanceToGoal);
	}
    }
    public int getRow(){
	return row;
    }
    public int getCol(){
	return col;
    }

    
}

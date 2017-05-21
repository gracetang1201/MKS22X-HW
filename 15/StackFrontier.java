import java.util.*;
public class StackFrontier implements Frontier<Location>{
    public Stack<Location> locations = null;
    public void add(Location l){
	locations.push(l);
    }
    public Location next(){
	return locations.pop();
    }
    public boolean hasNext(){
	return !locations.isEmpty();
    }
}

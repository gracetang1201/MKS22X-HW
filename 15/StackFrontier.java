import java.util.*;
public class StackFrontier implements Frontier<Location>{
    public Stack<Location> locations = null;
    public int size = 0;
    public void add(Location l){
	locations.push(l);
	size++;
    }
    public Location next(){
	size--;
	return locations.pop();
	
    }
    public int getSize(){
        return size;
    }
}

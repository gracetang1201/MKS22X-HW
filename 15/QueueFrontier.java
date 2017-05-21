import java.util.*;
public class QueueFrontier implements Frontier<Location>{
    public LinkedList<Location> locations;
    public QueueFrontier(){
	locations = new LinkedList<Location>();
    }
    public void add(Location l){
	locations.add(l);
    }
    public Location next(){
	return locations.remove();
    }
    public boolean hasNext(){
	return !locations.isEmpty();
    }
}

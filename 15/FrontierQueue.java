import java.util.*;

public class FrontierQueue implements Frontier{
    
    private LinkedList<Location> locations;
    public int size;

    public FrontierQueue(){
	locations = new LinkedList<Location>();
	size = 0;
    }
    
    public void add(Location x){
	locations.add(x);
	size += 1;
    }

    public Location next(){
	size -= 1;
	return locations.removeFirst();
    }

    public int getSize(){
	return size;
    }


}

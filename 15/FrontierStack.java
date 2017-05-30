import java.util.*;

public class FrontierStack implements Frontier{
    
    private Stack<Location> locations;
    public int size;

    public FrontierStack(){
	locations = new Stack<Location>();
	size = 0;
    }
    
    public void add(Location x){
	locations.push(x);
	size += 1;
    }

    public Location next(){
	size -= 1;
	return locations.pop();
    }

    public int getSize(){
	return size;
    }


}

import java.util.ArrayDeque;

public class FrontierQueue implements Frontier<Location> {
  private ArrayDeque<Location> locations;
    private int size = 0;

  public FrontierQueue() {
    locations = new ArrayDeque<Location>();
    size = 0;
  }

  public void add(Location loc) {
    locations.add(loc);
    size++;
  }

  public Location next() {
      size--;
    return locations.remove();
    
  }

  public int getSize() {
    return size;
  }
}

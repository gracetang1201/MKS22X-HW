public interface Frontier<Location>{
    public void add(Location l);
    public Location next();
    public boolean hasNext();
}

public class Deque{
    private String[]arr;
    private int start;
    private int end;
    public Deque{
	arr = new String[10];
	start = 0;
	end = 0;
	
    }
    public void addFirst(String wadd){
	int index = Math.floorMod(start-1, arr.length);
	arr[index] = wadd;
	start = index;
    }
    public void addLast(String wadd){
	if(size = arr.length){
	    String[]newarr = new String[arr.length*2];
	    for(int i = 0; i < arr.length; i++){
		newarr[i] = arr[i];
	    }
	    arr = newarr;
	}else{
	    
	}
    }
    
}

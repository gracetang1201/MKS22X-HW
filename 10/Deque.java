import java.util.*;
public class Deque{
    private String[]arr;
    private int start;
    private int end;
    private int size;

    public Deque(){
	arr = new String[10];
	//start = 0;
	//end = 0;
	size = 0;
	
    }
    public void grow(){
	String[]newarr = new String[arr.length*2];
	int i = start;
	int i2 = 0;
	while(i!=end){
	    newarr[i2] = arr[i];
	    i = (i+1)%(arr.length);
	    i2++;
	}
	newarr[i2]=arr[end];
	start=0;
	end = i2;
	arr=newarr;
    }
    public void addFirst(String wadd){
	/*
	if(size == 0){
	    start = 0;
	    end = 0;
	    arr[0] = wadd;
	    size++;
	    return;
	}  
	if (size == arr.length){
	    grow();
	    start = arr.length-1;
	    //arr[start] = wadd;
	    //size++;
	}else{
	    
	    start = Math.floorMod(start-1, arr.length);
	    //arr[index] = wadd;
	    //start = index;
	    //size++;
	}
	arr[start] = wadd;
	size++;
	*/
	if(size == arr.length){
	    grow();
	}
	start = (arr.length + start - 1)%(arr.length);
	if(size == 0){
	    start = 0;
	    end = 0;
	}
	arr[start] = wadd;
	size++;
    }
    public void addLast(String wadd){
	/*
	if(size == 0){
	    arr[0] = wadd;
	    start = 0;
	    end = 0;
	    size++;
	    return;
	}
	if(size == arr.length){
	    grow();
	    end = size;
	}else{
	    end = Math.floorMod(end+1, arr.length);
	}
	arr[end] = wadd;
	size++;
	*/
	if(size == arr.length){
	    grow();
	}
	end = (end+1)%(arr.length);
	if(size == 0){
	    start = end = 0;
	}
	arr[end] = wadd;
	size++;
    }
    public String removeFirst(){
	/*
	String ans = arr[start];
	start = Math.floorMod(start+1, arr.length);
	size--;
	return ans;
	*/
	if(size == 0){
	    throw new NoSuchElementException();
	}
	String ans = arr[start];
	start = (start+1)%(arr.length);
	size--;
	return ans;
	
    }
    public String removeLast(){
	/*
	String ans = arr[end];
	end = Math.floorMod(end - 1, arr.length);
	size--;
	return ans;
	*/
	if(size == 0){
	    throw new NoSuchElementException();
	    
	}
	String ans = arr[end];
	end = (arr.length + end - 1)%(arr.length);
	size--;
	return ans;
    }
    public String getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}else{
	    return arr[start];
	}
    }
    public String getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}else{
	    return arr[end];
	}
    }
    public String toString(){
	int i = start;
	String ans = "";
	
	while(i!=end){
	    ans += arr[i] + " ";
	    i = (i+1)%(arr.length);
	}
	ans += arr[end];

	return ans;
	
	/*
	for(int in = 0; in < arr.length; in++){
	    ans += arr[in];
	}
	return ans;
	*/
    }
    public static void main(String[]args){
	Deque example = new Deque();
	
	example.addFirst("5");
	example.addFirst("4");
	example.addFirst("3");
	example.addFirst("2");
	example.addFirst("1");
	example.addLast("2");
	example.addLast("3");
	example.addLast("4");
	example.addLast("9");
	example.addLast("10");
	example.addLast("11");
	
	System.out.println(example.getFirst());
	System.out.println(example.getLast());
	//example.removeFirst();
	//System.out.println(example);
	
    }
    
}

import java.util.*;

public class FrontierPriorityQueue implements Frontier{

    public Location[] heap = new Location[10];
    int lastindex; //THIS IS THE INDEX YOU ARE ADDING TO/ THE FIRST OPEN INDEX
    boolean isMax;
    
   
    public FrontierPriorityQueue(){
	lastindex = 1;
	isMax = true;
    }
    public FrontierPriorityQueue(boolean b){
	isMax = b;
	lastindex = 1;
    }
    public Location peek(){
	return heap[1];
    }
    public void add(Location newstr){
	if(lastindex == heap.length){
	    grow();
	}
	heap[lastindex] = newstr;
	
	int temp = lastindex;
	if(isMax){
	    while(temp != 1){
		//System.out.println(temp);
		if(heap[temp].compareTo(heap[temp/2]) >= 1){
		    swap(temp, temp/2);
		}
		temp = temp/2;
	    }
	}else{
	    while(temp != 1){
		//System.out.println(temp);
		if(heap[temp].compareTo(heap[temp/2]) <= -1){
		    swap(temp, temp/2);
		}
		temp = temp/2;
	    }
	}

	lastindex++;
    }
    public int getSize(){
	return lastindex;
    }
    public Location next(){
	/*
	  heap[1] = heap[lastindex-1];
	  heap[lastindex-1] = null;
	  int temp = 1;
	
	  while(temp < lastindex / 2){
	  int s = heap[temp*2].compareTo(heap[temp*2+1]);
	  if(s >= 1){
	  if(heap[temp].compareTo(heap[temp*2])<=-1){
	  swap(temp, temp*2);
	  }
	  temp = temp *2;
	  }else if(s <= -1){
	  System.out.println(temp);
	  System.out.println(temp*2+1);
	  if(heap[temp].compareTo(heap[temp*2+1])<=-1){
	  swap(temp, temp*2+1);
	  }
	  temp = temp*2+1;
	  }
	  }
	*/
	Location ans = heap[1];
	heap[1] = heap[lastindex-1];
	
	heap[lastindex-1] = null;
	int temp = 1;
	lastindex--;
	//	System.out.println("this is the last index" + lastindex);
	/*
	  if(heap.length == 2 && !isMax && heap[1] > heap[2]){
	  swap(1, 2);
	  }
	*/
	
	if(isMax){
	    while(temp < lastindex / 2){
		//int s = heap[temp*2].compareTo(heap[temp*2+1]);
		//if(s <= -1){
		if(heap[temp].compareTo(heap[temp*2])<=-1){
		    swap(temp, temp*2+1);
		    //}
		}else{ //if(s >= 1){
	    
		    if(heap[temp].compareTo(heap[temp*2+1])<=-1){
			swap(temp, temp*2);
		    }
		}
		temp = temp*2;
	    }
	}else{
	    while(temp < lastindex / 2){
		//int s = heap[temp*2].compareTo(heap[temp*2+1]);
		if(heap[temp*2].compareTo(heap[temp*2+1]) >= 1){
	    
		    if(heap[temp].compareTo(heap[temp*2+1])>=-1){
			swap(temp, temp*2+1);
			//temp = temp * 2 + 1;
		    }
		}else{
		    if(heap[temp].compareTo(heap[temp*2])>=-1){
			swap(temp, temp*2);
			//temp *= 2;
		    }
		}
		temp = temp*2;
		
	    }
	}
	return ans;
	
    }
    public void swap(int  in1, int in2){
	Location temp = heap[in1];
	heap[in1] = heap[in2];
	heap[in2] = temp;
    }
    public void grow(){
        Location[]temp = new Location[heap.length*2];
	for(int i = 0; i < heap.length; i++){
	    temp[i] = heap[i];
	}
	heap = temp;
    }


}

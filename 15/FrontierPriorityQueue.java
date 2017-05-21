public class FrontierPriorityQueue implements Frontier<Location>{
    public PriorityQueue locations = new PriorityQueue(false);
    public boolean hasNext(){
	if(locations.heap.length == 0){
	    return false;
	}else{
	    return true;
	}
    }
    public void add(Location l){
	locations.add(l);
    }
    public Location next(){
	return locations.remove();
	
    }













//INNER CLASS PRIORITYQUEUE______________________________________________
public class PriorityQueue{
    public Location[] heap = new Location[10];
    int lastindex; //THIS IS THE INDEX YOU ARE ADDING TO/ THE FIRST OPEN INDEX
    boolean isMax;
    
    public PriorityQueue(){
	lastindex = 1;
	isMax = true;
    }
    public PriorityQueue(boolean b){
	isMax = b;
	lastindex = 1;
    }
    /*
    public String toString(){
	String ans = "";
	for(int i = 0; i < heap.length; i++){
	    ans += heap[i] + " ";
	}
	return ans;
    }
    */
    public Location peek(){
	return heap[1];
    }
    public void add(Location newstr){
	if(lastindex == heap.length){
	    grow();
	}
	//System.out.println(lastindex);
	heap[lastindex] = newstr;
	
	int temp = lastindex;
	if(isMax){
	    while(temp != 1){
		//System.out.println(temp);
		if(heap[temp].compareTo(heap[temp/2]) >= 1){
		    //System.out.println(heap[temp]);
		    //System.out.println(heap[temp/2] + "------");
		    swap(temp, temp/2);
		}
		temp = temp/2;
	    }
	}else{
	    while(temp != 1){
		//System.out.println(temp);
		if(heap[temp].compareTo(heap[temp/2]) <= -1){
		    //System.out.println(heap[temp]);
		    //System.out.println(heap[temp/2] + "------");
		    swap(temp, temp/2);
		}
		temp = temp/2;
	    }
	}

	lastindex++;
    }

    public Location remove(){
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
	//boolean b=false;
	if(!isMax){
	    //while(!b){
	    //b=true;
	   
		while(temp <= lastindex/2){
		     if (heap[temp*2+1] == null) {
		    if(heap[temp].compareTo(heap[temp*2])>=-1) {
		swap(temp, temp*2);
		break;
		    }
		}
		    //int s = heap[temp*2].compareTo(heap[temp*2+1]);
		    if(heap[temp*2].compareTo(heap[temp*2+1])>=1){                                   //s >= -1){
			if(heap[temp].compareTo(heap[temp*2+1])>=1){
			   
			    swap(temp, temp*2+1);
			    //b=false;
			}
		    }else{ //if(s <= 1){
	    
			if(heap[temp].compareTo(heap[temp*2])>=1){
			    
			    swap(temp, temp*2);
			    //b=false;
			
			}
		    }
		    temp = temp*2;
		
	    }
	    
	    
	}else{
	    while(temp < lastindex / 2){
		
		int s = heap[temp*2].compareTo(heap[temp*2+1]);
		if(s >= 1){
		    if(heap[temp].compareTo(heap[temp*2])>=-1){
			swap(temp, temp*2);
		    }
		}else if(s <= -1){
	    
		    if(heap[temp].compareTo(heap[temp*2+1])>=-1){
			swap(temp, temp*2+1);
		    }
		}
		temp = temp*2;
	    }
	}
	return ans;
    }
    public void swap(int in1, int in2){
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
//INNER CLASS PRIORITYQUEUE______________________________________________
}

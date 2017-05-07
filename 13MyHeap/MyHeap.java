public class MyHeap{
    public String[] heap = new String[10];
    int lastindex; //THIS IS THE INDEX YOU ARE ADDING TO/ THE FIRST OPEN INDEX
    boolean isMax;
    
    public static void main(String[]args){
	MyHeap m = new MyHeap();
	MyHeap b = new MyHeap(false);
	m.add("A");
	m.add("B");
	m.add("C");
	m.add("D");
	m.add("E");
	System.out.println(m);
	b.add("A");
	b.add("B");
	b.add("C");
	b.add("D");
	b.add("E");
	System.out.println(b);
	
	
    }
    public MyHeap(){
	lastindex = 1;
	isMax = true;
    }
    public MyHeap(boolean b){
	isMax = b;
	lastindex = 1;
    }
    public String toString(){
	String ans = "";
	for(int i = 0; i < heap.length; i++){
	    ans += heap[i] + " ";
	}
	return ans;
    }
    public String peek(){
	return heap[1];
    }
    public void add(String newstr){
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
		}else{
		    System.out.println("Did not swap" + temp);
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
		}else{
		    System.out.println("Did not swap" + temp);
		}
		temp = temp/2;
	    }
	}

	lastindex++;
    }
    public String remove(){
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
	String ans = heap[1];
	heap[1] = heap[lastindex-1];
	
	heap[lastindex-1] = null;
	int temp = 1;
	lastindex--;
	if(!isMax){
	    while(temp < lastindex / 2){
		int s = heap[temp*2].compareTo(heap[temp*2+1]);
		if(s >= 1){
		    if(heap[temp].compareTo(heap[temp*2+1])<=-1){
			swap(temp, temp*2+1);
		    }
		}else if(s <= -1){
	    
		    if(heap[temp].compareTo(heap[temp*2])<=-1){
			swap(temp, temp*2);
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
	    
		    if(heap[temp].compareTo(heap[temp*2+1])<=-1){
			swap(temp, temp*2+1);
		    }
		}
		temp = temp*2;
	    }
	}
	return ans;
    }
    public void swap(int in1, int in2){
	String temp = heap[in1];
	heap[in1] = heap[in2];
	heap[in2] = temp;
    }
    public void grow(){
	String[]temp = new String[heap.length*2];
	for(int i = 0; i < heap.length; i++){
	    temp[i] = heap[i];
	}
	heap = temp;
    }
}

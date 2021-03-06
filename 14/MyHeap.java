public class MyHeap{
    public Integer[] heap = new Integer[10];
    int lastindex; //THIS IS THE INDEX YOU ARE ADDING TO/ THE FIRST OPEN INDEX
    boolean isMax;
    
    public static void main(String[]args){
	MyHeap m = new MyHeap(true);
	MyHeap a = new MyHeap(false);
	m.add(1);
	m.add(2);
	m.add(3);
	m.add(4);
	m.add(5);
	m.add(6);
	m.add(7);
	
	//====
	a.add(5);
	a.add(7);
	a.add(9);
	a.add(11);
	a.add(13);
	//System.out.println(m);
	System.out.println(a);
	//m.remove();
	a.remove();
	//System.out.println(m);
	System.out.println(a);
	
	
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
    public Integer peek(){
	return heap[1];
    }
    public void add(Integer newstr){
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

    public Integer remove(){
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
	Integer ans = heap[1];
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
		if(heap[temp*2] > heap[temp*2+1]){
	    
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
    public void swap(int in1, int in2){
	Integer temp = heap[in1];
	heap[in1] = heap[in2];
	heap[in2] = temp;
    }
    public void grow(){
	Integer[]temp = new Integer[heap.length*2];
	for(int i = 0; i < heap.length; i++){
	    temp[i] = heap[i];
	}
	heap = temp;
    }
}

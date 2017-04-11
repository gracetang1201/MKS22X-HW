import java.util.*;
public class MyLinkedList implements Iterable<Integer>{
    public static void main(String[]args){
	MyLinkedList m = new MyLinkedList();
	//LNode l = new LNode(1);
	m.add(0, 10);
	m.add(1, 5);
	//m.add(1, 4);
	//m.add(0, 4);
	//m.add(5);
	//System.out.println("should be 3:");
	//System.out.println(m.get(1));
	m.set(0, 100000000);
	//System.out.println("should be 3");
	//System.out.println(m.indexOf(5));
	//m.remove(1);
	System.out.println(m.iterator().hasNext());
	System.out.println(m.size());
	System.out.println(m);
    }
    //----------------------------- INNER CLASS LNODE
    private class LNode{
	LNode next,prev;
	int value;
	public LNode(int value){
	    this.value=value;
	}
	public String toString(){
	    return value+"";
	}
    }
    //---------------------------- INNER CLASS LNODE
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //---------------------------- INNER CLASS MLLI
    public class MLLI implements Iterator<Integer>{
	private int index;
	private MyLinkedList mll; 

	public MLLI(MyLinkedList m, int i){
	    index = i;
	    mll = m;
	}

	public Integer next(){
	    return mll.getNode(index).next.value;
	}

	public boolean hasNext(){
	    if (mll.getNode(index).next != null){
		return true;
	    }
	    return false;
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
	
    }
    //---------------------------INNER CLASS MLLI

    LNode start;
    int size = 0;
    LNode end;

    public MyLinkedList(){
	size = 0;
	start = null;
	end = null;
    }

    public Iterator<Integer> iterator(){
	MLLI m = new MLLI(this, 0);
	return m;
    }
    public int size(){
	return size;
    }

    
    private LNode getNode(int in){
	LNode n = start;
	for(int i = 0; i < in; i++){
	    n = n.next;
	}
	return n;
    }



    public String toString(){
	String ans = "[";
	for(int i = 0; i < size; i++){
	    if(i == size - 1){
		ans += getNode(i).value + "]";
	    }else{
		ans += getNode(i).value + ", ";
	    }
	}
	return ans;
	//[1, 2, 3] empty: [];
    }

    public boolean add(int val){
	LNode n = new LNode(val);
	add(size-1, val);
	return true;
    }

    public int get(int index){
	if(index >= size || index < 0){
	    throw new IndexOutOfBoundsException("you can't get from negative position or outside list");
	}
	LNode n = null;
	n = getNode(index);
	return n.value;
    }

    public int set(int index, int newValue){
	if(index >= size || index < 0){
	    throw new IndexOutOfBoundsException("you can't set negative position or outside list");
	}
	int ans = getNode(index).value;
	getNode(index).value = newValue;
	return ans;
    }

    public int indexOf(int value){
	for(int i = 0; i < size; i++){
	    if (get(i) == value){
		//ans = i;
		return i;
	    }
	}
	return -1;
    }

    public int remove(int index){
	if(index > size || index< 0){
	    throw new IndexOutOfBoundsException("you can't remove from negative position or outside list");
	}

	int ans = getNode(index).value;
	
	if(index == 0){
	    start = start.next;
	    start.prev = null;   
	}else if(index == size - 1){
	    end = end.prev;
	    end.next = null;
	}else{
	    LNode l = getNode(index);
	    l.prev.next = l.next;
	    l.next.prev = l.prev;
	}
	size--;
	return ans;
    }

    public void add(int pos,int val){
	if(pos > size || pos < 0){
	    throw new IndexOutOfBoundsException("you can't add to negative position or outside list");
	}
	//first element to be added:
	LNode n = new LNode(val);
	if(size == 0){
	    start = n;
	    end = n;
	    //size++;
	}else if(pos == 0){ //add to beginning
       
	    start.prev = n;
	    n.next = start;
	    start = n;
	}else if(pos == size){ //add to end
	   
	    end.next = n;
	    n.prev = end;
	    end = n;
	}else{ // add to middle of list
	    
	    
	    n.prev = getNode(pos - 1);
	    n.next = getNode(pos);
	    getNode(pos).prev = n;
	    getNode(pos-1).next = n;
	}
	size++;
    }


}

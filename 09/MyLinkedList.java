public class MyLinkedList{
    public static void main(String[]args){
	MyLinkedList m = new MyLinkedList();
	//LNode l = new LNode(1);
	m.add(0, 2);
	m.add(1, 3);
	m.add(2, 4);
	m.add(5);
	//System.out.println("should be 3:");
	//System.out.println(m.get(1));
	m.set(0, 99999999);
	//System.out.println("should be 3");
	//System.out.println(m.indexOf(5));
	m.remove(1);
	System.out.println(m);
    }
    LNode start;
    int size = 0;
    //------------------------------LNODE INNER CLASS-------------------
    class LNode{
	int value = 0;
	LNode next = null;
	public LNode(int val){
	    value = val;
	    next = null;
	}
	public LNode(int val, LNode n){
	    value = val;
	    next = n;
	}
	/*
	public LNode getNext(){
	    return next;
	}
	
	public String toString(){
	    String ans = value;
	    return ans;
	}
	*/
    }
    //------------------------------LNODE INNER CLASS-------------------
    public MyLinkedList(){
	size = 0;
	start = null;
    }
    
    public void add(int pos, int val){
	//first element to be added:
	LNode n = new LNode(val);
	if(size == 0){
	    start = n;
	    //size++;
	}else if(pos == 0){ //add to beginning
	    n.next = start;
	    start = n;
	}else if(pos == size -1){ //add to end
	    getNode(size - 1).next = n;
	}else{ // add to middle of list
	    getNode(pos-1).next = n;
	    n.next = getNode(pos);
	}
	size++;
    }
    public int size(){
	return size;
    }

    public boolean add(int val){
	LNode n = new LNode(val);
	//n.value = val;
	//add(size-1, val);
	//getNode(size-1).next = n;
	add(size-1, val);
	return true;
    }
    public int set(int index, int newValue){
	int ans = getNode(index).value;
	getNode(index).value = newValue;
	return ans;
	/*
	LNode change = new LNode();
	for(int i = 0; i < index, i++){
	    change = change.next;
	}
	*/
	
    }

    public String toString(){
	String ans = "";
	for(int i = 0; i < size; i++){
	    ans += getNode(i).value + " ";
	}
	return ans;
    }
    
    public LNode getNode(int in){
	LNode n = start;
	for(int i = 0; i < in; i++){
	    n = n.next;
	}
	return n;
    }
    public int get(int index){
	/*
	LNode n = start;
	for(int i = 0; i < in; i++){
	    n = n.next;
	}
	*/
	LNode n = null;
	n = getNode(index);
	return n.value;
    }
    public int indexOf(int value){
	//int ans = -1;
	for(int i = 0; i < size; i++){
	    if (get(i) == value){
		//ans = i;
		return i;
	    }
	}
	return -1;
	
    }
    public int remove(int index){
	int ans = getNode(index).value;
	getNode(index - 1).next = getNode(index + 1);
	return ans;
    }

    
}

public class RunningMedian{
    public MyHeap a = new MyHeap(true); //max
    public int sizea = 0;
    public MyHeap b = new MyHeap(false); //min
    public int sizeb = 0;

    public static void main(String[]args){
	RunningMedian r = new RunningMedian();
	r.add(1);
	r.add(2);
	r.add(3);
	r.add(4);
	r.add(5);
	r.add(7);
	r.add(9);
	r.add(11);
	r.add(13);
	r.add(15);
	//r.add(11);
	//r.add(13);
	//System.out.println(r.a);
	//System.out.println(r.b);
	System.out.println(r.getMedian());
	///System.out.println(r.a);
	//System.out.println(r.b);
	    
    }

    public RunningMedian(){
    }

    public void add(int newadd){
	if(sizeb == 0 && sizea == 0){
	    a.add(newadd);
	    sizea++;
	}else{
	    if(newadd >= getMedian()){
		b.add(newadd);
		sizeb++;
	    }else if(newadd < getMedian()){
		a.add(newadd);
		sizea++;
	    }
	}
	
    }
    public double getMedian(){
	double res = 0.0;
	//System.out.println("" + sizea + " " + sizeb);
	if(sizea - sizeb == 1){
            //System.out.println("sizea - sizeb == 1");
	    res = a.peek();
	}else if(sizeb - sizea == 1){
	    //System.out.println("sizeb - sizea == 1");
	    res = b.peek();
	}else if(sizeb == sizea){
	    //System.out.println("sizeb == sizea");
	    res = ((a.peek() + b.peek())/2);
	}else if(sizea - sizeb > 1){
	    //System.out.println("sizea - sizeb > 1");
	    int tempa = a.remove();
	    sizea--;
	    b.add(tempa);
	    sizeb++;
	    //System.out.println("sizea is " + (sizea - sizeb) + " greater than sizeb");
	    res = ((a.peek() + b.peek())/2);

	}else if(sizeb - sizea > 1){
	    //System.out.println("sizeb - sizea > 1");
	    int tempb =b.remove();
	    sizeb--;
	    a.add(tempb);
	    sizea++;
	    res = ((a.peek() + b.peek())/2);

	}
	return res; 
    }
}

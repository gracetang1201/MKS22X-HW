import java.util.*;
public class Quick{
    public static void main(String[]args){
	int[]ary = {10, 5,5,5,55,5,5,5,55,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,55, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        //qsh(ary, 0 , ary.length-1);
	System.out.println(toString(ary));
    }
    public static int part( int[]data, int start, int end ){
	//returns the ending pivotposition
	//END IS EXCLUSIVE
	//choose a random pivot:
	Random r = new Random();
	//System.out.println(end-start);
	int pivotpos = r.nextInt(end - start) + start; //position of pivot
      	//System.out.println(pivotpos + "pivotpos");
 

	//swap pivot and the first number:
	int pivotnum = data[pivotpos];
	data[pivotpos] = data[0];
	data[0] = pivotnum;
	pivotpos = 0;
	
	for(int i = 1; i < data.length; i++){
	    if(data[i] < pivotnum){
		int temp = data[i];
		data[i] = 0;;
		for(int move = i-1; move >= pivotpos; move--){
		    data[move+1] = data[move];
		}
		data[pivotpos] = temp;
		pivotpos++;
	    }
	}
	return pivotpos;
    }
    public static int partition(int[]data, int start, int end, int k){
	//exclusive end:
	int pivotposition = part(data, 0, data.length);
	if(pivotposition == k){
	    return data[k];
	}else{
	    if(pivotposition >= k){
		return partition(data, pivotposition + 1, data.length, k);
	    }else{
		return partition(data, 0, pivotposition, k);
	    }
	}
    }

    public static int quick(int[] data, int k){
	return partition(data, 0, data.length, k);
    }

    public static String toString(int[]ary){
	String ans = "";
	for(int n = 0; n < ary.length; n++){
	    ans += ary[n] + ",";
	}
	return ans;
    }

    public static int[] newpartition(int[]a, int start, int end){
	int[] ans = new int[2];
	Random r = new Random();
	int vpos = r.nextInt(end - start) + start;
	int vvalue = a[vpos];
	int i = start;
	int lt = start;
	int gt = end;
	while(i <= gt){
	    if(a[i] == vvalue){
		i++;
	    }
	    else if(a[i] < vvalue){
		swap(a, i, lt);
		lt++;
		i++;
	    }
	    else{
		swap(a, i, gt);
		gt--;
	    }
	}
	ans[1] = lt;
	ans[1] = gt;
	return ans;
    }

    public static void QuickH(int[]a, int start, int end){
	/*
	  if(end<=start){
	  return;
	  }else{
	  int i = part(data, start, end);
       
	    
	  System.out.println(i + "pivotposition");
	  for(int n = 0; n < data.length; n++){
	  System.out.println(data[n]);
	  }
	  
	  //qsh(data, 0, i);
	  qsh(data, start+1, end);
	  //qsh(data, i+1, data.length);
	  qsh(data, start, end-1);
	  }
	*/
	if(start < end){
	    int lt = newpartition(a, start, end)[0];
	    int gt = newpartition(a, start, end)[1];
	    qsh(a, start, lt-1);
	    qsh(a, gt+1, end);
	
	}
    
    }
    public static void quicksort(int[]ary){
	QuickH(ary, 0, ary.length-1);
    }
    public int void quickselect(int[]ary, int k){
	quicksort(ary);
	return ary[k];
    }
    /*
    public static void newQuick(int[]a){
	int i = 0;
	int lt = 1;
	int gt = a.length - 1;
	int hi = gt;
	Random r = new Random();
	//System.out.println(end-start);
	int v = r.nextInt(a.length); //position of pivot
      	//System.out.println(pivotpos + "pivotpos");
	//swap pivot and the first number:
	int pivotnum = a[v];
	a[v] = a[0];
	a[0] = pivotnum;
	v = 0;
	int lo = a[0];
	while( i <= gt){
	    if (a[i] == v){
		i++;
	    }else if(a[i] < v){
		swap (a, i, lt);
		lt++;
		i++;
	    }else{
		swap(a, i, gt);
	    }
	}
    }
    */

    public static void swap(int[]a, int b, int c){
	int temp = a[b];
	a[b] = a[c];
	a[c] = temp;
    }
    
    
    
}

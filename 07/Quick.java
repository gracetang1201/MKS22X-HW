import java.util.*;
public class Quick{
    public static void main(String[]args){
	int[]ary = { 2, 10, 15, 23, 0,  5};
        qsh(ary, 0, ary.length);
	System.out.println(toString(ary));
    }
    public static int part( int[]data, int start, int end ){
	//returns the ending pivotposition
	//END IS EXCLUSIVE
	//choose a random pivot:
	Random r = new Random();
	System.out.println(end-start);
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

    public static void qsh(int[]data, int start, int end){
	if(end<=start){
	    return;
	}else{
	    int i = part(data, start, end);
	    /*
	      System.out.println(i + "pivotposition");
	      for(int n = 0; n < data.length; n++){
	      System.out.println(data[n]);
	      }
	    */
	    //qsh(data, 0, i);
	    qsh(data, start+1, end);
	    //qsh(data, i+1, data.length);
	    qsh(data, start, end-1);
	}
    }
    
    
    
}

import java.util.*;
public class Quick{
    public static void main(String[]args){
	int[]ary = { 2, 10, 15, 23, 0,  5};
	System.out.println(quickselect1(ary, 5));
    }
    public static int part( int[]data, int start, int end ){
	
	//choose a random pivot:
	Random r = new Random();
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
    
    
    
}

import java.util.*;
import java.io.*;

public class Quickselect{
    public static void main(String[]args){
	int[]data = {1, 3, 5, 4, 6, 9};
	Quickselect q = new Quickselect();
	System.out.println(q.part(data, 0, 5));
    }
    public int part(int[] data, int start, int end){
	Random r = new Random();
	ArrayList<Integer> temp = new ArrayList<Integer>();
	
	for(int index = 0; index < data.length; index++){
	    temp.add(data[index]);
	}

	//int pivot = start + (end-start)*();
	int pivotpos = r.nextInt(end-start) + start;
	System.out.println("pivot:" + pivotpos);
	for(int i = start; i < end+1; i++){
	    int t = temp.get(i);
	    if(temp.get(i) > temp.get(pivotpos)){
		
		temp.remove(i);
		temp.add(t);
	    }else{
		temp.remove(i);
		temp.add(0, t);
	    
	    }
	}
	System.out.println("--------");
	for(int i = 0; i < data.length; i++){
	    System.out.println(temp.get(i));
	}
	System.out.println("--------");
	return pivotpos;

    }
}


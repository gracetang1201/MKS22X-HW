import java.util.*;
public class Quick1{


    public static void main (String[]args){
	int[]ary = {10, 5,5,5,55,5,5,5,55,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,55, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        
	//System.out.println(toString(ary));
	int[]ary1 = new int[100];
	for(int i = 0; i < ary1.length; i++){
	    ary1[i] = (int)(Math. random() * 50 + 1);
	}
	quicksort(ary1);
System.out.println(Arrays.toString(ary1));

    }
    public static int[] part(int[] a, int start, int end){
	Random r = new Random();
	int pivot = r.nextInt(end - start) + start;
	int value = a[pivot];
	//System.out.println(pivot);
	//System.out.println(value);
	int i = start;
	int lt = start;
	int gt = end;
	while(i <= gt){
	    if(a[i] == value){
		i++;
	    }
	    else if(a[i] < value){
		swap(a, i, lt);
		lt++;
		i++;
	    }
	    else{
		swap(a, i, gt);
		gt--;
	    }
	}
	int[] temp = new int[2];
	temp[0] = lt;
	temp[1] = gt;
	//System.out.println(Arrays.toString(temp));
	//System.out.println(Arrays.toString(a));
	return temp;
    }

    public static void quicksort(int[] a){
	quickHelp(a, 0, a.length - 1);
    }

    public static void quickHelp(int[] a, int start, int end){
	if(start >= end){
	    return;
	}
	int[] temp = part(a, start, end);
	int low = temp[0];
	int high = temp[1];
	quickHelp(a, start, low - 1);
	quickHelp(a, high + 1, end);	
    }

    public static int quickSelect(int[] a, int k){
	quicksort(a);
	return a[k];
    }

    public static void swap(int[] a, int b, int c){
        int temp = a[b];
	a[b] = a[c];
	a[c] = temp;
    }


}

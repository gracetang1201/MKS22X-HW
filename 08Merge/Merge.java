public class Merge{
    public static void main(String[]args){
	int[]ary1 = {1};
	int[]ary2 = {0};
	int[]ary3 = {};
	int[]ary4 = {1, 9, 7, 4, 3, 5, 6, 10, 11};
	//Merge(ary1, ary2);
	//System.out.println(toString(Merge(ary1, ary2)));
	System.out.println(toString(sorthelper(ary4)));
    }
    public static String toString(int[]arr){
	String ans = "";
	for(int i = 0; i < arr.length; i++){
	    ans += arr[i];
	}
	return ans;
    }
    public static int[] Merge(int[]a, int[]b){
	int ai = 0;
	int bi = 0;
	int counter = 0;
	int[]ans = new int[a.length + b.length];
	while(counter != ans.length){
	    if(ai > a.length-1){
		for(int i = bi; i < b.length; i++){
		    ans[counter] = b[i];
		    counter++;
		}
	    }
	    else if (bi > b.length-1){
		for(int i = ai; i < a.length; i++){
		    ans[counter] = a[i];
		    counter++;
		}
	    }
	    else if (a[ai] < b[bi]){
		ans[counter] = a[ai];
		counter++;
		ai++;
	    }else{
		ans[counter] = b[bi];
		counter++;
		bi++;
	    }
	}
	return ans;
	
    }
    public static int[] sorthelper(int[]a){
	if (a.length == 1){
	    return a;
	}else{
	    int[] ary1 = new int[a.length / 2];
	    int[] ary2 = new int[a.length - ary1.length];
	    for(int i = 0; i < ary1.length; i++){
		ary1[i] = a[i];
	    }
	    for(int i = a.length/2; i < a.length; i++){
		ary2[i-a.length/2] = a[i];
	    }
	    return Merge(sorthelper(ary1), sorthelper(ary2));
			     
	
    }
}
}

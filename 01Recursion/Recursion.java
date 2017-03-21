public class Recursion{
    public static void main(String[]args){
	System.out.println(sqrt(0.0));
    }
    public static String name(){
	return "Tang,Grace";
    }
    public static boolean closeEnough(double a, double b){
	if (b < 0){
	    throw new IllegalArgumentException("you can't squareroot a negative");
	}
	if (Math.abs(a - b)/a <= 0.00000000001){
	    return true;
	}else{
	    return false;
	}
    }
    public static double sqrt(double n){
	if(n==0.0){
	    return 0.0;
	}
	if(n<0){
	    throw new IllegalArgumentException("you can't squareroot a negative");
	}
	
	return squareroot(n, n/2);
    }
    public static double squareroot(double n, double guess){
	if(n<0){
	    throw new IllegalArgumentException("you can't squareroot a negative");
	}
	if(closeEnough(n, guess*guess)){
	    return guess;
	}else{
	    return squareroot(n, ((n/guess)+guess)/2 );
	}
    }
}

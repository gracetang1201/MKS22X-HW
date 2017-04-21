import java.util.Stack;
public class evaluation{
    public static boolean isOp(String s){
	String operators = "+/-*";
	return(operators.indexOf(s) > -1);
    }
    public static double apply(String op, String e, String f){
	/*	if (op.equals("+")){
		return a + b
		}
		if (op.equals("*")){
		return a * b
		}
		if (op.equals("/")){
		return a / b
		}
		if (op.equals("-")){
		return a - b
		}
	*/
	
	double a = Double.parseDouble(f);
	double b = Double.parseDouble(e);
	double answer = 0.0;
	switch ("/-*+".indexOf(op)){
	case 0: answer = a / b;
	    break;
	case 1: answer = a - b;
	    break;
	case 2: answer = a * b;
	    break;
	case 3: answer = a + b;
	    break;
	    
	}
	return answer;
    }
    public static double eval(String s){
	String[]tokens = s.split(" ");
	Stack nums = new Stack();
	for(String token: tokens){
	    if(isOp(token)){
		nums.push(Double.toString(apply(token, (String)nums.pop(), (String)nums.pop())));
	    }else{
		nums.push(token);
	    }
	}
	return Double.parseDouble((String)nums.pop());
	
    }
    public static void main(String []args){
	/*
	System.out.println(isOp("+"));
	System.out.println(isOp(" "));
	System.out.println(isOp("1"));
	System.out.println(isOp("/"));
	System.out.println(apply("+", "1", "2"));
	*/
	System.out.println(eval("11 3 - 4 + 2.5 *"));
    }
}

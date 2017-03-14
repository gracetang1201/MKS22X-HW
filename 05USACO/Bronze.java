import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
 
public class Bronze{
   
    public int[][] elevations;
 
    public Bronze(){
        
    }
   
    public static void main(String[] args) {
       
 
        int[][] twoD = {{28, 25, 20, 32, 34, 36},
			{27, 25, 20, 20, 30, 34},
			{24, 20, 20, 20, 20, 30},
			{20, 20, 14, 14, 20, 20}};
	Bronze n = new Bronze();
	try{
	    System.out.println(n.Bronze("makelake.in"));
	    //System.out.println(n);
	    //toString(elevations);
	}catch (FileNotFoundException e){
	}
	
        //Stompers a = new Stompers(twoD);
       
        //System.out.println(toString(a.elevations));
        //a.stomp(1, 4, 4);
        //System.out.println(toString(a.elevations));
 
    }
    public String name(){
	return "Grace Tang 6";
    }
    public int Bronze(String filename) throws FileNotFoundException{
	
	
        File f = new File(filename);
        Scanner s = new Scanner(f);
	int ro = s.nextInt();
	//System.out.println(ro);
	int co = s.nextInt();
	//System.out.println(co);
        elevations = new int[ro][co];
        int el = s.nextInt();
	//System.out.println(el);
        int nc = s.nextInt();

        for(int r = 0; r < elevations.length; r++){
            for (int c = 0; c < elevations[r].length; c++){
                elevations[r][c] = s.nextInt();
            }
        }
	
	for (int z = 0; z <= nc; z++){
	    while(s.hasNextInt()){
		stomp(s.nextInt(), s.nextInt(), s.nextInt());
	    }
	}
	for (int i = 0; i < elevations.length; i++){
	    for (int x = 0; x < elevations[i].length; x++){
		if(elevations[i][x] >= el){
		    elevations[i][x] = 0;
		}else{
		    elevations[i][x] = el - elevations[i][x];
		}
	    }
	}
	int vol = 0;
	for(int r = 0; r < elevations.length; r++){
	    for(int c = 0; c < elevations[r].length; c++){
		vol = vol + elevations[r][c];
	    }
	}
	return vol*72*72;
    }
    /*
    public static String toString(int[][] twoDArray){
        String o = "";
        for (int[] row : twoDArray) {
            for (int e : row){
                o += e;
                o += " ";
            }
            o += "\n";
        }
        return o;
    }
    */
    public String toString(){
	String ans = "";
	for(int r = 0; r < elevations.length; r++){
	    for(int c = 0; c < elevations[r].length; c++){
		if(c == elevations[r].length-1){
		    ans = ans + " " + elevations[r][c] + "\n";
		}else{
		    ans = ans + " " + elevations[r][c];
	    }
	    
	}
    }
	return ans;
    }
    public void stomp(int row, int col, int depth){
	/*
	try{
	    importFile("file.txt");
	}catch (FileNotFoundException e){
	}
	*/
        int biggest = 0;
        for (int findRow = row - 1; findRow < row + 2; findRow++){
            for (int findCol = col - 1; findCol < col + 2; findCol++){
                if (elevations[findRow][findCol] > biggest){
                    biggest = elevations[findRow][findCol];
                }
            }  
        }
        for (int findRow = row - 1; findRow < row + 2; findRow++){
            for (int findCol = col - 1; findCol < col + 2; findCol++){
                if (elevations[findRow][findCol] > biggest - depth){
                    elevations[findRow][findCol] = biggest - depth;
                }
            }
        }
	
    }
 
 
 
}

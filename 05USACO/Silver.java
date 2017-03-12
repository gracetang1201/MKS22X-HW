import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Silver{
    private int[][]land;
    private int[][]land1;
    private static int startx, starty, endx, endy, seconds;
    public static void main(String[]args){
	Silver s = new Silver();
	s.importFile("file1.txt");
	System.out.println(s);
	System.out.println(s.solve());
	System.out.println(s);
    }
    
    public void importFile(String filename){
	File f = new File(filename);
	Scanner s = null;
	//Scanner c = null;
	try{
	   s = new Scanner(f);
	   //c = new Scanner(f);
	}catch (FileNotFoundException e){
	    System.out.println("file not found");
	}
	
	int ro = s.nextInt();
	//System.out.println(ro);
	int co = s.nextInt();
	seconds = s.nextInt();
	System.out.println(seconds);
	land = new int[ro][co];
	land1 = new int[ro][co];
	String spacer = s.nextLine();
	
	for(int i = 0; i < ro; i++){
	    String l = s.nextLine();
	    for(int in = 0; in < l.length(); in++){
		if(l.charAt(in) == '.'){
		    land[i][in] = 0;
		    land1[i][in] = 0;
		}else{
		    land[i][in] = -1;
		    land1[i][in] = -1;
		}
	    }
	}
	
	startx = s.nextInt()-1;
	starty = s.nextInt()-1;
	endx = s.nextInt()-1;
	endy = s.nextInt()-1;
	System.out.println("" + startx + starty + endx + endy);

	//DO STUFF HERE:
	land[startx][starty] = 1;
	land1[startx][starty] = 1;
	
    }

    public int move(int row, int col){
	int count = land[row][col];
	//land[row][col] = 0;
	if(!(land[row][col] == -1)){
	    if(land[row][col] == 0){
		if(row - 1 >= 0 && !(land[row-1][col]== -1)){
		    count += land[row-1][col];
		    //land[row-1][col] += land[row][col];
		}
		if (row + 1 < land.length && !(land[row+1][col] == -1)){
		    count += land[row+1][col];
		    //land[row+1][col] += land[row][col];
		}
		if (col - 1 >= 0 && !(land[row][col-1] == -1)){
		    count += land[row][col-1];
		    //land[row][col-1] += land[row][col-1];
		}
		if(col+1<land[0].length && !(land[row][col+1] == -1)){
		    count += land[row][col+1];
		    //land[row][col+1] += land[row][col+1];
		}
		
	    }else{
		land1[row][col] = 0;
	    }
	    
	}
	return count;
    }



    public int solve(){
	int time = 1;
	//for(int time = 1; seconds==time; time++){
	    while(time<=seconds){
	    for(int r = 0; r < land.length; r++){
		for(int c = 0; c < land[0].length; c++){
		    if(!(land[r][c] == 0)){
			land1[r][c] = move(r, c);
		    }else{
			    
			land1[r][c] = -1;
		    }
		    if(!(land[r][c] == -1)){
			if(land[r][c] == 0){
			    land1[r][c] = move(r, c);
			}else{
			    land1[r][c] = 0;
			}
		    }else{
			land1[r][c] = -1;
		    }
		    //land1[row][col] = 0;
		}
	    }
	    time++;
	}
	//return land1[endx][endy];  
	
	return land1[endx][endy];  
	
    }
    //return land1[endx][endy];
    

    public String toString(){
	String ans = "";
	for(int r = 0; r < land1.length; r++){
	    for(int c = 0; c < land1[r].length; c++){
	
		if(c == land1[r].length-1){
		   
		    ans = ans + " " + land1[r][c] + "\n";
		}else{
		    ans = ans + " " + land1[r][c];
		}
	    
	    }
	}
	/*
	for(int r = 0; r < land1.length; r++){
	    for(int c = 0; c < land1[r].length; c++){
	
		if(c == land1[r].length-1){
		   
		    ans = ans + " " + land1[r][c] + "\n";
		}else{
		    ans = ans + " " + land1[r][c];
		}
	    
	    }
	}
	*/
	return ans;
    }
}

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class usaco{
    private int[][]land;
    private static int startx, starty, endx, endy, seconds;
    private int[][]land1;
    private int[][] elevations;

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
	//System.out.println(seconds);
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
	//System.out.println("" + startx + starty + endx + endy);

	//DO STUFF HERE:
	land[startx][starty] = 1;
	land1[startx][starty] = 1;
	
    }
    public String name(){
	return "Grace Tang 6";
    }

   public int move(int r, int c){
	int total = 0;
	//land1[r][c] = land[r+1][c] + land[r-1][c] + land[r][c+1] + land[r][c-l];
	if(r-1 >= 0 && land[r-1][c] != -1){
	    total += land[r-1][c];
	}
	if(r+1 < land.length && land[r+1][c] != -1){
	    total += land[r+1][c];
	}
	if(c-1 >= 0 && land[r][c-1] != -1){
	    total += land[r][c-1];
	}
	if(c+1 < land[0].length && land[r][c+1] != -1){
	    total += land[r][c+1];
	}
	return total; 
    }
    public int silver(String filename){
	importFile(filename);
	for (int steps = 0; steps < seconds; steps++){
	    for(int r = 0; r < land.length; r++){
		for(int c = 0; c < land[r].length; c++){
		    if(land[r][c] != -1){
			land1[r][c] = move(r, c);
		    }else{
			land1[r][c] = -1;
		    }
		}
	    }
	    for(int r = 0; r < land.length; r++){
		for(int c = 0; c < land[r].length; c++){
		    land[r][c] = land1[r][c];
		}
	    }
	    
	}
	return land1[endx][endy];
    }
    
    /*
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

	return ans;
    }
    */
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
    */
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

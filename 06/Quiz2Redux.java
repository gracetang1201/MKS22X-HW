import java.util.*;
public class Quiz2Redux{  
    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */
    public static void main(String[]args){
	System.out.println(combinations("kji"));
    }
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	words.add("");
	help( words, s, 0);
	Collections.sort(words);
	return words;
    }
  
    private static void help( ArrayList<String> words, String s, int i){
	int len = words.size();
	if(i > s.length() -1){
	    return;
	}
			      
	if(words.size() == Math.pow(2.0, s.length())){
	    return;
	}
	for(int in = 0; in < len; in++){
	    words.add(words.get(in) + s.charAt(i));
	}
	help(words, s, i + 1);
    }
}

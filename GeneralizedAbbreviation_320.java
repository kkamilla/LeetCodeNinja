package recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation_320 {
	class Solution {
	    public List<String> generateAbbreviations(String word) {
	        // 2 options at current index
	        List<String> forward=new ArrayList<>();
	         generateAbbreviations_forward( word, 0,0, "", forward);
	        System.out.println(forward);
	        return forward;
	    }
	    
	    public void generateAbbreviations_forward(String word,int currIndex,int char_countAbbr,String currString,List<String> res) {
	        if(currIndex==word.length()){
	            if(char_countAbbr!=0){
	                //some abbreviated chars are there to add
	                currString=currString+char_countAbbr;
	            }
	             //add currString to res
	            res.add(currString);
	        }
	        else{
	            //abbreviate the char at currIndex
	            generateAbbreviations_forward( word, currIndex+1,char_countAbbr+1, currString, res);
	            
	            
	            
	            //keep char at currIndex as is
	            if(char_countAbbr!=0){
	                //add it to currString as we are continueing from here to not abbrecviate thr next char , so we will make char_countAbbr=0 after we consume what k alrady has
	                currString=currString+char_countAbbr;
	                
	            }
	            generateAbbreviations_forward( word, currIndex+1,0, currString+word.charAt(currIndex), res);
	            
	        }
	    }
	}
}

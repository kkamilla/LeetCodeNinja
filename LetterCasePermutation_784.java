package recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation_784 {
	class Solution {
	    public List<String> letterCasePermutation(String S) {
	        return letterCasePermutation(S,0);
	    }
	    
	    public List<String> letterCasePermutation(String S,int currIndex) {
	        if(currIndex==S.length()){
	            
	            List<String> l=new ArrayList<>();
	            l.add("");
	            return l;
	        }
	        else{
	            
	            if(Character.isLetter(S.charAt(currIndex))){
	                //change current index to differernt case
	                char cu=Character.toUpperCase(S.charAt(currIndex));
	                //don't chnage to differernt case
	                char cl=Character.toLowerCase(S.charAt(currIndex));
	                //append cu cl to retrun value of ots next index call
	                List<String>  res= letterCasePermutation( S, currIndex+1);
	                List<String> returnList=new ArrayList<>();
	                for(String s:res){
	                    
	                    returnList.add(cu+s);
	                     returnList.add(cl+s);
	                    
	                }
	                return  returnList;
	                
	            }else{
	                List<String> returnList=new ArrayList<>();
	                List<String>  res=letterCasePermutation( S, currIndex+1);
	                for(String s:res){
	                    returnList.add(S.charAt(currIndex)+s);
	                }
	                return  returnList;
	            }
	            
	            
	        }
	        
	    }
	}
}

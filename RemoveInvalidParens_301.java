package recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParens_301 {
	class Solution {
	    int min_removed=Integer.MAX_VALUE;
	    public List<String> removeInvalidParentheses(String s) {
	        List<String> result=new ArrayList<>();
	        if(checkValidParens(s,0,0)){
	            result.add(s);
	            return result;
	        }
	        removeInvalidParentheses_h( s, 0, "", result);
	        System.out.println(result);
	        if(result.size()==0){
	            result.add("");
	        }
	        return result;
	    }
	    
	    public void removeInvalidParentheses_h(String s,int index,String currS,List<String> result) {
	        if(checkValidParens(currS, 0, 0) && currS.length()>0){
	            if(min_removed>(s.length()-currS.length())){
	                result.clear();
	                result.add(currS);
	                min_removed=s.length()-currS.length();
	            }
	            else if(min_removed==(s.length()-currS.length()) && !result.contains(currS)){
	                result.add(currS);
	            }
	        }
	         if(index>=s.length() ){
	            return ;
	        }
	        //use the current bracket
	        if( (s.charAt(index)=='(' || s.charAt(index)==')')){
	            removeInvalidParentheses_h( s, index+1, currS+s.charAt(index), result);
	            //don't use 
	             removeInvalidParentheses_h( s, index+1, currS, result);
	        }
	        else{
	            //if its a alphabet just skip and go to next index
	            removeInvalidParentheses_h( s, index+1, currS+s.charAt(index), result);
	        }
	    
	    }
	    
	    public boolean checkValidParens(String s,int count,int currIndex) { 
	        //for ))(( case at any point if its -ve then retrun false
	        if(count<0){
	            return false;
	        }
	        //at the end if count==0 then its a valid paren
	        if(currIndex==s.length() && count==0){
	            return true;
	        }
	        else if(currIndex<s.length()){
	            char c=s.charAt(currIndex);
	            if('('==c){
	                count++;   
	            }
	            else if(')'==c){
	                count--;
	            }
	            //increase the count if u see a open bracket
	            return checkValidParens( s, count, currIndex+1);
	        
	        //decrease count on seeing close
	        }
	        
	        return false;
	        
	    }
//	     public boolean checkValidParens_old(String s,int open,int close,int index){
//	         //balanced parens and last char is not a open bracket
	        
//	         if(index>=s.length() && open==close && s.equals("")){
//	             return true;
//	         }
//	         else if(index>=s.length() && open==close && (open==0 || s.charAt(s.length()-1)==')')){
//	             return true;
//	         }
//	         else if(index<s.length()){
//	             char c=s.charAt(index);
//	             if('('==c){
//	                 open++;   
//	             }
//	             else if(')'==c){
//	                 close++;
//	             }
	            
//	            return checkValidParens_old( s, open, close, index+1);
//	         }
	        
//	         return false;
	       
//	     }
	}
}

package twoPointer;

import java.util.Stack;

public class BackspaceStrCompare_844 {
	class Solution {
	    //extra space M+N with same time as below 2 pointer method
	    public boolean backspaceCompare_stack(String S, String T) {
	        return build(S).equals(build(T));
	    }

	    public String build(String S) {
	        Stack<Character> ans = new Stack();
	        for (char c: S.toCharArray()) {
	            if (c != '#')
	                ans.push(c);
	            else if (!ans.empty())
	                ans.pop();
	        }
	        return String.valueOf(ans);
	    }
	    //O(N+M) with no space
	    public boolean backspaceCompare(String S, String T) {
	        //eat one char in front of #
	       
	        int i = S.length() - 1, j = T.length() - 1;
	        int skipS = 0, skipT = 0;
	        while(i>=0 || j>=0){
	            while(i>=0){
	               if( S.charAt(i)=='#'){
	                    i--;
	                   //we need to skip one char
	                   skipS++;
	                } 
	                //u cananot skip the char immediatelty with a if clause here as the next char might be a # again, so u collect all the number of chars u want to skip in skipS varioable and u skip after there is no more # ahead where i points to
	               else if(skipS>0){
	                    skipS--;
	                    //skipping the actual char here
	                    i--;
	                }
	                else{
	                    break;
	                }
	            }
	            
	            while(j>=0){
	               if( T.charAt(j)=='#'){
	                    j--;
	                   //we need to skip one char
	                   skipT++;
	                } 
	                else if(skipT>0){
	                    skipT--;
	                    //skipping the actual char here
	                    j--;
	                }
	                else{
	                    //if its a char and compare in if below
	                   
	                    break;
	                }
	            }
	            //after while loop breaking if the chars are not same then false
	            if( i>=0 && j>=0 && T.charAt(j)!=S.charAt(i)){
	                return false;
	            }
	            if((i>=0 && j<0 ) || (i<0 && j>=0)){
	               return false;
	            }
	            i--;
	             j--;
	        }
	        
	        return true;
	    }
	}
}

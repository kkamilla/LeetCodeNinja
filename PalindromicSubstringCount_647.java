package dp_palindromicSubsequence;

public class PalindromicSubstringCount_647 {
	class Solution {
	    public int countSubstrings(String s) {
	        
	        int count=s.length();//minimum number of palindrom count is number of chars in the string at a minimum, so initialize with count of number of chars as 1 length palindromix strings are possible with only taking a single char
	       for(int i=1;i<s.length();i++){
	           //find all the palidroms with i as the center and expanding around i, we get count
	           //this will find odd length palindroms starting at i
	           
	           int left=i-1;
	           int right=i+1;
	           while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
	               count++;
	               left--;
	               right++;
	           }
	           
	           //now expand with space after i as ceneter , and form even length palindroms with that as center
	           left=i-1;
	           right=i;
	           while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
	               count++;
	               left--;
	               right++;
	           }
	           
	           
	       }
	        
	        
	        
	        return count;
	    }
	    
	  
	    
	}
}

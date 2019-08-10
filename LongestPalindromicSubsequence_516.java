package dp_palindromicSubsequence;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubsequence_516 {
	class Solution {
	    
	    
	    
	    public int longestPalindromeSubseq(String s) {
	        int[][] dp=new int[s.length()][s.length()];
	        //fill the diagonal first
	        //it means there are only 1 char strings where start==end
	        for(int i=0;i<s.length();i++){
	            dp[i][i]=1;
	        }
	        //fill diagonal next to (i,i+1) diagonal next
	        //then fill (i,i+2) diagonally
	        //then fill (i,i+3) diagonally
	        //https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
	        //bottom part of array is not filled as start>end
	        for(int len=2;len<=s.length();len++){
	            for(int start=0;start<s.length()-len+1;start++){
	                int end=start+len-1;
	                if(s.charAt(start)==s.charAt(end)){
	                     dp[start][end]=2+dp[start+1][end-1];
	                }
	                else{
	                    dp[start][end]=Math.max(dp[start+1][end],dp[start][end-1]);
	                }
	                
	            }
	           
	        }
	        
	        return dp[0][s.length()-1];
	    }
	    
	    public int longestPalindromeSubseq_rec(String s) {
	        Map<String,Integer> memo=new HashMap<>();
	        return longestPalindromeSubseq_rec( s,0, s.length()-1,memo);
	    }
	    
	     public int longestPalindromeSubseq_rec(String s,int start,int end,Map<String,Integer> memo) {
	        if(memo.containsKey(start+":"+end)){
	             return memo.get(start+":"+end);
	         }
	         //if there is only 1 char left, then its a palindrom
	         if(start==end){
	            return 1;      
	        }
	         // if 2 char left, then its a palindrom if both char are same else not
	         if(start+1==end){
	             if(s.charAt(start)==s.charAt(end)){
	                 return 2;
	             }
	             // else{
	             //     return 1;
	             // }
	         }
	         int x=0,y=0,z=0;
	         if(s.charAt(start)==s.charAt(end)){
	             //if both are same add 2 to longest lenght
	            x=2+longestPalindromeSubseq_rec( s,start+1, end-1,memo); 
	         }
	         else{
	             //move forward from start
	             y=longestPalindromeSubseq_rec( s,start+1, end,memo); 
	             //else move backward from end
	             z=longestPalindromeSubseq_rec( s,start, end-1,memo);
	         }
	         memo.put(start+":"+end,Math.max(z,Math.max(x,y)));
	         return Math.max(z,Math.max(x,y));
	    }
	    
	    // boolean isPalindrom(String s){
	    //     int i=0,j=s.length()-1;
	    //     while(i<j){
	    //         if(s.charAt(i)!=s.charAt(j)){
	    //             return false;
	    //         }
	    //         i++;
	    //         j--;
	    //     }
	    //     return true;
	    // }
	}
}

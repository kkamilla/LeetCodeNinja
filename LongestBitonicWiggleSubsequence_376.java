package dp_longestCommonSubstring;

import java.util.HashMap;
import java.util.Map;

public class LongestBitonicWiggleSubsequence_376 {
	class Solution {
		
		
		//https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/
		
		
	    public int wiggleMaxLength(int[] nums) {
	        //int memo[][] = new int[nums.length+1][nums.length];
	        Map<String,Integer> memo=new HashMap<>();
	        
	        int startingIncreasing=wiggleMaxLength(nums, 0, -1, false,memo);
	        
	        int startingDecreasing=wiggleMaxLength(nums, 0, -1, true,memo);
	      return Math.max(startingIncreasing,startingDecreasing);  
	    }
	    
	    public int wiggleMaxLength(int[] nums,int currIndex,int prevIndex,boolean prevIsIncreasing,Map<String,Integer>  memo) {
	        if(currIndex==nums.length ){
	            return 0;
	        }
	        //as 1st time the prevIndex==-1 , so to avoid the case , we store prevIndex+1 as the index corresponding to prevIndex
	        if ( memo.containsKey(prevIndex+":"+currIndex+":"+prevIsIncreasing)) {
	            return memo.get(prevIndex+":"+currIndex+":"+prevIsIncreasing);
	        }
	        //don not take it
	        int max=wiggleMaxLength(nums, currIndex+1, prevIndex, prevIsIncreasing,memo);
	        //take it
	        if(prevIndex==-1|| prevIndex>-1 &&((nums[prevIndex]<nums[currIndex] && prevIsIncreasing==false) ||(nums[prevIndex]>nums[currIndex] && prevIsIncreasing==true))){
	           max=Math.max(max,  1+wiggleMaxLength(nums, currIndex+1, currIndex, !prevIsIncreasing,memo));
	        }
	        memo.put(prevIndex+":"+currIndex+":"+prevIsIncreasing,max);
	       return max; 
	        
	    }
	}
}

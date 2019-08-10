package dp_boundedKnapsack;

import java.util.HashMap;
import java.util.Map;

public class TargetSum_494 {
	class Solution {
	    public int findTargetSumWays(int[] nums, int S) {
	        Map<String,Integer> memo=new HashMap<>();
	       
	         return findTargetSumWays_rec(nums,  S, 0,memo);
	    }
	    
	    public int findTargetSumWays_rec(int[] nums, int S,int currIndex,Map<String,Integer>  dp) { 
	        
	        if(S==0 && currIndex==nums.length){
	            return 1;
	        }
	        if(currIndex==nums.length){
	            return 0;
	        }
	        if(dp.containsKey(currIndex+":"+S)){
	            return dp.get(currIndex+":"+S);
	        }
	        //add a + sign with curr elemnt
	        int x=findTargetSumWays_rec(nums,  S-nums[currIndex], currIndex+1,dp);
	        //add a -ve sign with curr elemnt
	         x+=findTargetSumWays_rec(nums,  S+nums[currIndex], currIndex+1,dp);
	        dp.put(currIndex+":"+S,x);
	        return x;
	    }
	    
	    //sum can be max 1000 , so we can use +1000 as 
	    public int findTargetSumWays_dp(int[] nums, int S) {
		       int[][] dp=new int[nums.length][2001];
		       dp[0][nums[0]+1000]=1;
	        //if num[0] is same as 0 then we need to add += here as nums[0]+1000 is same as -nums[0]+1000
		       dp[0][-nums[0]+1000]+=1;
		       for(int i=1;i<nums.length;i++){
		    	   for(int j=-1000;j<=1000;j++){
	                   //if this count is >0 then we can extend it
		    		   if(dp[i-1][j+1000]>0){
	                       //we might get the same sum as we got before so +=
	                        dp[i][j+nums[i]+1000]+=dp[i-1][j+1000];
	                       dp[i][j-nums[i]+1000]+=dp[i-1][j+1000];
	                   }
		                
		                 
		             }
		         }
		         if(S>1000)return 0;
		         return dp[nums.length-1][S+1000];
		    } 
	    
	}
}

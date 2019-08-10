package dp_longestCommonSubstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence_300 {
	
	 public int lengthOfLIS(int[] nums) {
         int[] dptable=new int[nums.length];
         if(nums.length==0){
             return 0;
         }
         dptable[0]=1;//there can be a sequence containing only the first element
         //dp[i] means that a val length increasing sequence is possible with ith element as the last element in the sequence
         int maxResult=1;
         for(int i=1;i<nums.length;i++){
             int max_ending_here=1;//minimum value is 1 , the number at i itself
             for(int j=0;j<i;j++){
                 
                 //starting from 0 check , if num[j]<num[i] , if so we can add a 1 to value at dp[j]
                 if(nums[j]<nums[i]){
                   max_ending_here=Math.max(max_ending_here,dptable[j]+1);  
                 }
                 
             }
             
              //we need to take max of all the values of i,j
             dptable[i]=max_ending_here;
             //we need to keep track
             if(maxResult<max_ending_here){
                 maxResult=max_ending_here;
             }
         }
         return maxResult;
     }
	
	
	
	public int lengthOfLIS_rec(int[] nums) {
        List<Integer> currList=new  ArrayList<>();
        //as 1st time the prevIndex==-1 , so to avoid the case , we store prevIndex+1 as the index corresponding to prevIndex, so thats why 1st dimension is length+1 as we will go until maxlength+1 for previous index value as the memo[previndex][currIndex]
        int memo[][] = new int[nums.length+1][nums.length];
        //Map<String,Integer> memo=new HashMap<>();
        for (int[] l : memo) {
            Arrays.fill(l, -1);
        }
        return lengthOfLIS( nums, 0,-1,currList,memo);
    }
    
    public int lengthOfLIS(int[] nums,int currIndex,int prevIndex,List<Integer> currList,int[][] memo) {
        // if(memo.containsKey(currIndex+":"+prevIndex)){
        //     return memo.get(currIndex+":"+prevIndex);
        // }
        if(currIndex>=nums.length){
            
             return 0; 
        }
        //as 1st time the prevIndex==-1 , so to avoid the case , we store prevIndex+1 as the index corresponding to prevIndex
        if ( memo[prevIndex+1][currIndex] >= 0) {
            return memo[prevIndex+1][currIndex];
        }
        
        
        
        //don't take current number
        int x=lengthOfLIS( nums, currIndex+1,prevIndex,currList,memo);
        
        //take current number
        //check if u can add the current number
        if((prevIndex>=0 && nums[prevIndex]<nums[currIndex]) || prevIndex<0 ){
            currList.add(nums[currIndex]);
            x=Math.max(x,1+lengthOfLIS( nums, currIndex+1,currIndex,currList,memo));
            currList.remove(currList.size()-1);
        }
        //memo.put(currIndex+":"+prevIndex,x);
        memo[prevIndex+1][currIndex]=x;
        return x;
    }
}

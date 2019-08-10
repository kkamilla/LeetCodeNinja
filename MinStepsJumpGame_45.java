package dp_fibonacci;

public class MinStepsJumpGame_45 {
	class Solution {
	    public int jump(int[] nums) {
	        int[] memo=new int[nums.length];
	        //intilaize to -1 to denote we still have not calculated it
		        for(int j=0;j<nums.length;j++){
		            memo[j]=-1;
		        }
	        //return canJump_rec(nums, 0,memo);
	        return canJump_starting0_dp(nums);
	    }
	     public int canJump_starting0_dp(int[] nums) {
		        int[] dp=new int[nums.length];
	         for(int j=0;j<nums.length;j++){
		            dp[j]=Integer.MAX_VALUE;
		        }
		         dp[0]=0;
		        //intilaize to -1 to denote we still have not calculated it
		        for(int pos=0;pos<nums.length;pos++){
		           int furthestJump = Math.min(pos + nums[pos], nums.length - 1);
		           
		        //i can go from pos+1 to position + nums[position]
		        //we can start checking in reverse direction so that we take the farthest jump first
		            for(int i = pos + 1; i <= furthestJump; i++){
	                    //get min of all possible counts of steps reaching i
	                    //if in the first round, we found that we can reach pos=i by using 3 steps and then we finf there is a way to get there by 1 step, then we take a min of already exy=isting value at i and current value
		                dp[i]=Math.min(dp[i],dp[pos]==Integer.MAX_VALUE?Integer.MAX_VALUE:dp[pos]+1);
		            }
		        }
		        
		        return dp[nums.length-1];
		    }
	    public int canJump_rec(int[] nums,int pos,int[] memo) {
		        if(memo[pos]!=-1){
		            
		            return memo[pos];
		        }
		        if(pos==nums.length-1){
		         //reached end so no more steps needed to be taken
		            return 0;
		        }
		        
		      //to prevent it from trying more than len of array, we try only steps until we can reach the len-1 and not try the numbers after that
		        //this line made the rec+memo solution pass all test cases  as it does not try uneccesary steps>len-1
		        int furthestJump = Math.min(pos + nums[pos], nums.length - 1);
		        //i can go from pos+1 to position + nums[position]
		        //we can start checking in reverse direction so that we take the farthest jump first
	            int x=Integer.MAX_VALUE;
		        for(int i = pos + 1; i <= furthestJump; i++){
	                //to avoid integer overflow
	                if(canJump_rec(nums, i,memo)!=Integer.MAX_VALUE){
	                    x=Math.min(1+canJump_rec(nums, i,memo),x);
	                }    
		        }

		        memo[pos]=x;
		        return x;
		    }
	}
}

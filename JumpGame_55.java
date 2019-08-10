package dp_fibonacci;

public class JumpGame_55 {
	class Solution {
		
		
		public boolean canJump(int[] nums) {
	        boolean[] dp=new boolean[nums.length];
	         dp[nums.length-1]=true;
	        //intilaize to -1 to denote we still have not calculated it
	        for(int pos=nums.length-2;pos>=0;pos--){
	           int furthestJump = Math.min(pos + nums[pos], nums.length - 1);
	           
	        //i can go from pos+1 to position + nums[position]
	        //we can start checking in reverse direction so that we take the farthest jump first
	            for(int i = pos + 1; i <= furthestJump; i++){
	                if(dp[i]){
	                    //if we find we can reach a i which is already true , then we set this as true and we don not need to check other values
	                    dp[pos]=dp[i];
	                    break;
	                }
	                    
	            }
	        }
	        
	        return dp[0];
	    }
	    public boolean canJump_starting0_dp(int[] nums) {
	        boolean[] dp=new boolean[nums.length];
	         dp[0]=true;
	        //intilaize to -1 to denote we still have not calculated it
	        for(int pos=0;pos<nums.length;pos++){
	           int furthestJump = Math.min(pos + nums[pos], nums.length - 1);
	           
	        //i can go from pos+1 to position + nums[position]
	        //we can start checking in reverse direction so that we take the farthest jump first
	            for(int i = pos + 1; i <= furthestJump; i++){
	                dp[i]=dp[pos];
	            }
	        }
	        
	        return dp[nums.length-1];
	    }
		
	    public boolean canJump_rec_call(int[] nums) {
	        int[] memoMatrix=new int[nums.length];
	        //intilaize to -1 to denote we still have not calculated it
	        for(int j=0;j<nums.length;j++){
	            memoMatrix[j]=-1;
	        }
	        //Map<Integer,Boolean> memo=new HashMap<>();
	       // memo.put(nums.length-1,true);
	        return canJump_rec(nums, 0,memoMatrix);
	    }
	    //Time complexity : O(n^2) For every element in the array, say i, we are looking at the next nums[i] elements to its right aiming to find a GOOD index. nums[i] can be at most n, where n is the length of array nums.

	//Space complexity : O(2n)=O(n). First n originates from recursion. Second n comes from the usage of the memo table. 
	    public boolean canJump_rec(int[] nums,int pos,int[] memo) {
	        if(memo[pos]!=-1){
	            if(memo[pos]==1){
	                return true;
	            }
	            return false;
	        }
	        if(pos==nums.length-1){
	           // memo[pos]=1;
	            return true;
	        }
	        // if(pos>nums.length-1){
	        //     memo[pos]=0;
	        //     return false;
	        // }
	      //to prevent it from trying more than len of array, we try only steps until we can reach the len-1 and not try the numbers after that
	        //this line made the rec+memo solution pass all test cases  as it does not try uneccesary steps>len-1
	        int furthestJump = Math.min(pos + nums[pos], nums.length - 1);
	        //i can go from pos+1 to position + nums[position]
	        //we can start checking in reverse direction so that we take the farthest jump first
	        for(int i = pos + 1; i <= furthestJump; i++){
	           if(canJump_rec(nums, i,memo)){
	               memo[pos]=1;
	               //memo.put(i,true);
	               return true;
	              
	           } 
	        }

	        memo[pos]=0;
	        return false;
	    }
	}
}

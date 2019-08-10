package dp_fibonacci;

public class HouseRobber_198 {
	class Solution {

		public int rob(int[] nums) {
			if(nums.length==0){
				return 0;
			}
			if(nums.length==1){
				return nums[0];
			}

			int[] dp=new int[nums.length];
			dp[nums.length-1]=nums[nums.length-1];
			dp[nums.length-2]=Math.max(nums[nums.length-1],nums[nums.length-2]);


			for(int j=nums.length-3;j>=0;j--){
				int exclude=dp[j+1];
				int include=dp[j+2]+nums[j];
				dp[j]=Math.max(include,exclude);
			}
			return dp[0];
		}
		
		
		
		
		public int rob_rec(int[] nums) {
			int[] memo=new int[nums.length];
			for(int j=0;j<nums.length;j++){
				memo[j]=-1;
			}
			return rob_rec( nums, 0, 0,memo);
		}

		public int rob_rec(int[] nums,int pos,int total,int[] memo) {

			if(pos>=nums.length){
				return total;
			}
			//	         if(memo[pos]!=-1){

				//	 		            return memo[pos];
				//	 		        }

			//skip current house
			int x=rob_rec( nums, pos+1, total,memo);
			//go to current house 
			int y=rob_rec( nums, pos+2, total+nums[pos],memo);
			int k=Math.max(x,y);

			return Math.max(x,y);

		}
	}
}

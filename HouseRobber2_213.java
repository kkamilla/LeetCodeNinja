package dp_fibonacci;

public class HouseRobber2_213 {
	class Solution {
		//most optimized
		private int rob(int[] num, int lo, int hi) {
		    int include = 0, exclude = 0;
		    for (int j = lo; j <= hi; j++) {
		        int i = include, e = exclude;
		        include = e + num[j];
		        exclude = Math.max(e, i);
		    }
		    return Math.max(include, exclude);
		}
		
		
		public int rob(int[] nums) {
			if(nums.length==0){
				return 0;
			}
			if(nums.length==1){
				return nums[0];
			}
			if(nums.length==2){
				return Math.max(nums[0],nums[1]);
			}
			//return Math.max(rob_rec( nums, 0, 0,nums.length-2),rob_rec( nums, 1, 0,nums.length-1));
			//Now the question is how to rob a circular row of houses. It is a bit complicated to solve like the simpler question. It is because in the simpler question whether to rob num[lo] is entirely our choice.
			//But, it is now constrained by whether num[hi] is robbed.
			return Math.max(rob_Dp(nums, 0, nums.length-2),rob_Dp(nums, 1, nums.length-1));
		}

		public int rob_Dp(int[] nums,int start,int end) {


			int[] dp=new int[end-start+1];
			dp[dp.length-1]=nums[end];
			dp[dp.length-2]=Math.max(nums[end],nums[end-1]);

			int k=end-2;
			for(int j=dp.length-3;j>=0;j--){
				int exclude=dp[j+1];

				int include=dp[j+2]+nums[k];
				k--;
				System.out.println("dp[j+2]="+dp[j+2]+" nums[j]="+nums[j]);
				System.out.println("include="+include);
				dp[j]=Math.max(include,exclude);
			}
			System.out.println("strart="+start+" end="+end+"...."+dp[0]);
			return dp[0];
		}
		public int rob_rec(int[] nums,int start,int total,int end) {

			if(start>end){
				//if i have exceeeded end then i return total, not when i am at end as i want to incldue the end house value as well
				return total;
			}
			//	         if(memo[pos]!=-1){

			//	 		            return memo[pos];
			//	 		        }

			//skip current house
			int x=rob_rec( nums, start+1, total,end);
			//go to current house 
			int y=rob_rec( nums, start+2, total+nums[start],end);


			return Math.max(x,y);

		}
	}
}

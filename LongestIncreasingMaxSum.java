package dp_longestCommonSubstring;

public class LongestIncreasingMaxSum {
	public static int lengthOfLIS(int[] nums) {
        int[] dptable=new int[nums.length];
        if(nums.length==0){
            return 0;
        }
        dptable[0]=nums[0];//there can be a sequence contaning only the first element
        //dp[i] means that a val length increaing sequence is possible with ith element as the last element in the sequence
        int maxResult=1;
        for(int i=1;i<nums.length;i++){
            int max_sum_ending_here=nums[i];//minimum value is 1 , the number at i itself
            for(int j=0;j<i;j++){
                
                //starting from 0 check , if num[j]<num[i] , if so we can add a 1 to value at dp[j]
                if(nums[j]<nums[i]){
                	max_sum_ending_here=Math.max(max_sum_ending_here,dptable[j]+nums[i]);  
                }
                
            }
            
             //we need to take max of all the values of i,j
            dptable[i]=max_sum_ending_here;
            //we need to keep track
            if(maxResult<max_sum_ending_here){
                maxResult=max_sum_ending_here;
            }
        }
        return maxResult;
    }
	public static void main(String[] args)  
    {
	int arr[] = { 3, 2, 6, 4, 5, 1 }; 
	System.out.println(lengthOfLIS(arr));
    }
}

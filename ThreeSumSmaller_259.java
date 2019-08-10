package twoPointer;

import java.util.Arrays;

public class ThreeSumSmaller_259 {
	class Solution {
	    public int threeSumSmaller(int[] nums, int target) {
	        Arrays.sort(nums);
		        int count=0;
		        
		        //sum to start and end index map
		        
		        for(int curr=0;curr<nums.length;curr++){
		            int max_reqSum=target-nums[curr];
		            int start=curr+1;
		            int end=nums.length-1;
		             while(start<end){
		                int sum=nums[start]+nums[end];
		                //check if its smaller 
		                if(sum>=max_reqSum){
		                    end--;
		                    }
		                else if(sum<max_reqSum){
	                        //we got sum<target, so add all pairs possible
	                        //pairs we can consider as sum<target is (start,end), (start,end-1),(start,end-2),(start,end-3)....as long as 2nd index equal to start by decrementing
	                        //Exapmle:[1,2,3,4,5]
	                        //How many pairs with one of the index = leftindex=left that satisfy the condition? You can tell by the difference between rightright and leftleft which is 33, namely (1,2), (1,3),(1,2),(1,3), and (1,5)(1,5). Therefore, we move leftleft one step to its right.

	                        int totalnums=end-start;
	                        //number of combinations possible with totalnums elemnts
		                    count+=totalnums;
	                        start++;
	                    //Time complexity : O(n^2). The twoSumSmaller function takes O(n) time because both left and right traverse at most n steps. Therefore, the overall time complexity is O(n^2).
		                }
		            }
			            
			      }
			    return count;
	    }
	}
}

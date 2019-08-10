package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumZero_15 {
	class Solution {
	    public List<List<Integer>> threeSum(int[] nums) {
	        Arrays.sort(nums);
	        List<List<Integer>> resL=new ArrayList<>();
	        
	        //sum to start and end index map
	        int prev=Integer.MIN_VALUE;
	        for(int curr=0;curr<nums.length;curr++){
	            int reqSum=-nums[curr];
	            int start=curr+1;
	            int end=nums.length-1;
	            if(nums[curr]==prev ){
	                continue;//skip it
	            }
	            else{
	                //process curr
	                 while(start<end){
	                    int sum=nums[start]+nums[end];
	                    if(sum==reqSum){
	                        List<Integer> res=new ArrayList<>();
	                        res.add(nums[curr]);
	                        res.add(nums[start]);
	                        res.add(nums[end]);
	                        System.out.println("curr="+curr+" start="+start+" end="+end);
	                        resL.add(res);
	                        //skip same elements as array is sorted , this is for skipping similar elements in 2 sum part
	                        //example:[-2,0,0,2,2], here repetition in the part to find 2 sum  so skip 0's and 2's as long as they are same
	                        while (start < end && nums[start] == nums[start+1]) start++;
	                        while (start < end && nums[end] == nums[end-1]) end--;
	                        start++;
	                        end--;
	                        //this is needed to skip the curr element if its repeating example:[-1,0,1,2,-1,-4]
	                        //[[-1,-1,2],[-1,0,1]] and not [[-1,-1,2],[-1,0,1],[-1,0,1]]
	                        prev=nums[curr];

	                    }
	                    else if(sum<reqSum){
	                        start++;
	                    }
	                    else{
	                        end--;
	                    }
	                }
	            }
	           
	        }
	        return resL;
	    }
	}
}

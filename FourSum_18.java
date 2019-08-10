package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
	class Solution {
	    public List<List<Integer>> fourSum(int[] nums, int target) {
	        Arrays.sort(nums);
	        //fix 2 indexes and then 2 a 2sum problem for rest
	        List<List<Integer>> resL=new ArrayList<>();
	        int prev=Integer.MIN_VALUE;
	        for(int left1=0;left1<nums.length;left1++){
	            int reqSum=target-nums[left1];
	            if(nums[left1]==prev ){
		                continue;//skip it 2 consecutove same numberws
		            }
		            else{
	                    prev=nums[left1];
	           resL= threeSum(nums, left1+1, nums.length-1, resL,reqSum,nums[left1]);
	                }
	            
	        }
	        return resL;
	    }
	    
	    public List<List<Integer>> threeSum(int[] nums,int start,int end,List<List<Integer>> resL,int target, int num1selected) {
		        //sum to start and end index map
		        int prev=Integer.MIN_VALUE;
		        for(int curr=start;curr<nums.length;curr++){
		            int reqSum=target-nums[curr];
		             start=curr+1;
		            //int end=nums.length-1;
		            if(nums[curr]==prev ){
		                continue;//skip it
		            }
		            else{
	                    prev=nums[curr];
		              resL= twoSum(nums, start, end,resL, reqSum, num1selected, nums[curr])  ;
		            }
		           
		        }
		        return resL;
		    }
	    
	    public List<List<Integer>> twoSum(int[] nums,int start,int end,List<List<Integer>> resL,int target,int num1selected,int num2selected) {
		        
	             while(start<end){
	                int sum=nums[start]+nums[end];
	                if(sum==target){
	                    List<Integer> res=new ArrayList<>();
	                    res.add(num1selected);
	                    res.add(num2selected);
	                    res.add(nums[start]);
	                    res.add(nums[end]);
	                    //System.out.println("curr="+curr+" start="+start+" end="+end);
	                    resL.add(res);
	                    //skip same elements as array is sorted , this is for skipping similar elements in 2 sum part
	                    //example:[-2,0,0,2,2], here repetition in the part to find 2 sum  so skip 0's and 2's as long as they are same
	                    while (start < end && nums[start] == nums[start+1]) start++;
	                    while (start < end && nums[end] == nums[end-1]) end--;
	                    start++;
	                    end--;
	                    
	                }
	                else if(sum<target){
	                    start++;
	                }
	                else{
	                    end--;
	                }
	            }
		            
		        return resL;
		    }
	}
}

package twoPointer;

import java.util.Arrays;

public class ThreeSumClosest_16 {
	class Solution {
	    public int threeSumClosest(int[] nums, int target) {
	    	Arrays.sort(nums);
	        int closest_result=Integer.MAX_VALUE;
	        
	        //sum to start and end index map
	        
	        for(int curr=0;curr<nums.length;curr++){
	            int min_reqSum=target-nums[curr];
	            int start=curr+1;
	            int end=nums.length-1;
	            //System.out.println("curr="+nums[curr]);
	            //process curr
	             while(start<end){
	                int sum=nums[start]+nums[end];
	                //check if its smaller 
	                 if(closest_result!=Integer.MAX_VALUE && Math.abs(closest_result-target)>Math.abs(sum+nums[curr]-target)){
	                        closest_result=sum+nums[curr];
	                    }
	                 //to aviod integer overflow if target is -ve and max+(something)==overflows
	                    else if(closest_result==Integer.MAX_VALUE){
	                        closest_result=sum+nums[curr];
	                    }
	                if(sum==min_reqSum){
	                    //System.out.println("found equal="+sum);
	                    
	                    break;
	                    }
	                else if(sum<min_reqSum){
	                    //System.out.println("start="+nums[start]);
	                    // if(closest_result!=Integer.MAX_VALUE && Math.abs(closest_result-target)>Math.abs(sum+nums[curr]-target)){
	                    //     closest_result=sum+nums[curr];
	                    // }
	                    // else if(closest_result==Integer.MAX_VALUE){
	                    //     closest_result=sum+nums[curr];
	                    // }
	                    start++;
	                }
	                else{
	                   // System.out.println("end="+nums[end]);
	                    // if(closest_result!=Integer.MAX_VALUE && Math.abs(closest_result-target)>Math.abs(sum+nums[curr]-target)){
	                    //     closest_result=sum+nums[curr];
	                    // }
	                    // else if(closest_result==Integer.MAX_VALUE){
	                    //     closest_result=sum+nums[curr];
	                    // }
	                    end--;
	                }
	            }
		            
		      }
		    return closest_result;  
	    }
	}
}

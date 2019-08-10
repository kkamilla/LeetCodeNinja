package twoPointer;

public class UnsortedArraySize_581 {
	class Solution {
	    public int findUnsortedSubarray(int[] nums) {
	        int start=0;
	        int end=nums.length-1;
	        if(nums.length==1){
	            return 0;
	        }
	        
	        //see until what is array sorted from start
	        while(start<nums.length-1){
	            if(nums[start]<=nums[start+1]){
	                start++;
	            }
	            else{
	                break;
	            }
	        }
	        
	        //check if start has reached the end then the array is already sorted
	        if(start==nums.length-1){
	          //array is completly sorted as start is at the end of the array
	            return 0;
	        }
	        
	        //if not then find the end index until which array is sorted from behind
	        while(end>=0){
	            if(nums[end]>=nums[end-1]){
	                end--;
	            }
	            else{
	                break;
	            }
	        }
	        
	        //now find the min and max within array[start,end] indexes to see if we need to extend the unsorted part in either directiond depending on if we find greater value than min in [0,start] and smaller number than max value in [end, length]
	        int min=Integer.MAX_VALUE;
	        int max=Integer.MIN_VALUE;
	        for(int i=start;i<=end;i++){
	            if(nums[i]<min){
	                min=nums[i];
	            }
	            if(nums[i]>max){
	                max=nums[i];
	            }
	        }
	        
	        //now find the  element in array[0 to start] which is greater than min found above, because then that element has to be brought to the latter part of the array and so the index of unsorted element starts from that index instead of "start" 
	        for(int j=0;j<start;j++){
	            if(nums[j]>min){
	                start=j;
	            }
	        }
	        
	        //find an element in [end to length-1] such that its lesser than the max found , so then that element has to be moved to make the array sorted, so for that we need to make that index as the new "end" index for the unsorted array portion
	        for(int j=nums.length-1;j>end;j--){
	            if(nums[j]<max){
	                end=j;
	            }
	        }
	    
	       return  end-start+1;
	    }
	}
}

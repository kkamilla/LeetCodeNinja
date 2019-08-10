package binarysearch_modified;

public class MinRotatedArr_153 {
	
	    public int findMin(int[] nums) {
	       
	        if(nums.length==1){
	            return nums[0];
	        }
	        int left=0;
	        int right=nums.length-1;
	        //if last element> first element then there is no rotation
	        if(nums[right]>nums[0]){
	            return nums[0];
	        }
	        //else find the largest element point
	        while(left<=right){
	            int mid=left+(right-left)/2;
	            if(  nums[mid]>nums[mid+1] ){
	                //beacuse after mid array is increasing again
	                return nums[mid+1];
	            }
	            else if(nums[mid]>nums[0] ){
	                left=mid+1;
	            }
	            else{
	            	//as nums[mid]<nums[0], so it might be the smallest in array and might be the result
	                right=mid;//mid might be the answer in this case , so we set right=mid, as it might be the minimum in the whole array
	            }
	        }
	        return -1;
	       
	    }
	
}

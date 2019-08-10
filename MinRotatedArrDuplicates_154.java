package binarysearch_modified;

public class MinRotatedArrDuplicates_154 {
	class Solution {
	    public int findMin(int[] nums) {
	        if(nums.length==1){
		            return nums[0];
		        }
		        int left=0;
		        int right=nums.length-1;
		        //if last element> first element then there is no rotation
	        // if(nums[nums.length-1]>nums[0] ){
	        // return nums[0];
	        // }
	        // if(nums[nums.length-1]>nums[0] && nums[nums.length-2]<nums[nums.length-1]){
	        // return nums[0];
	        // }
	       
		        //else find the largest element point
	        int mid=0;
		        while(left<=right){
		             mid=(right+left)/2;
		            if(  nums[mid]>nums[right] ){
		                //beacuse after mid array is increasing again
	                    System.out.println("inside, mid="+mid+" left="+left+" right="+right);
		               left=mid+1;
	                    
		            }
	                else if(  nums[mid]<nums[right] ){
	                     System.out.println("inside2, mid="+mid+" left="+left+" right="+right);
		                //beacuse after mid array is increasing again
	                    //as nums[mid]<nums[0], so it might be the smallest in array and might be the result
		                right=mid;//mid might be the answer in this case , so we set right=mid, as it might be the minimum in the whole array
		            }
		            
		            else{ //if  nums[mid]==nums[right] 
		            	//as we don't know where the minimum is , but we can reduce right as we can search in smaller space
	                    System.out.println("inside3, mid="+mid+" left="+left+" right="+right);
		                right--;
		            }
		        }
	        System.out.println(left);
		        return nums[left];
	    }
	}
}

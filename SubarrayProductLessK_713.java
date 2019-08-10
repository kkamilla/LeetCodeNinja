package twoPointer;

public class SubarrayProductLessK_713 {
	class Solution {
		//O(N) Solution 
	    public int numSubarrayProductLessThanK(int[] nums, int k) {
	        int numOfArrays=0;
	        int start=0;//fix the start of the window to 0
	        int product=1;
	        //loop over the end of the window depending on the product, move the start index if product >k
	        for(int end=0;end<nums.length;end++){
	            
	            //this is cumulative product until  
	            product*=nums[end];
	            
	            if(product>=k){
	               //slide the window forward by dividing by start index element
	                //check if start<end else start might move ahead of end and that does not make sense to keep deividing by start elemtn after end to reduce product
	                while(start<end && product>=k){
	                   product=product/nums[start];
	                    start++; 
	                }
	                
	            }
	            if(product<k){
	                //when its <k , you add as many subarrays as the size of the window
	                //Ex:[1,2,3,4] we add {[1]} , next step-> {[2],[1,2]},(window size=2) next step we add{[3],[2,3],[1,2,3]} which is same as window size here which is 3
	                numOfArrays+=end-start+1;
	                //increment end 
	                
	            }


	        }
			return numOfArrays;
	    }
	    //O(n2) solution -time exceeding for 10 test cases
	    public int numSubarrayProductLessThanK_ON2(int[] nums, int k) {
	        int numOfArrays=0;
	        for(int start=0;start<nums.length;start++){
	            //find product starting index start and see when the product <k then add it to count
	            int product=1;
	            for(int end=start;end<nums.length;end++){
	                //this is cumulative product until  
	                product*=nums[end];
	                if(product<k){
	                    numOfArrays++;
	                }
	                //as array has only +ve ints
	                if(product>=k){
	                    break;
	                }

	            }

	        }
			return numOfArrays;
	    }
	}
}

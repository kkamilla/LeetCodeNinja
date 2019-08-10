package binarysearch_modified;

import java.util.Random;

public class RnadomPickIndexDuplicates_398 {
	class Solution {
	    int total=0;
	    Random rand=new Random();
	    int[] input_arr;
	    public Solution(int[] nums) {
	        input_arr=nums;
	        total=nums.length;
	        
	        
	    }
	    
	    public int pick(int target) {
	        int count_withtarget=0;
	        for(int i=0;i<input_arr.length;i++){
	            if(target==input_arr[i]){
	                count_withtarget++;
	            }
	        }
	        
	        
	        int picked_random=0;
	        //int index=-1;
	        for(int i=0;i<input_arr.length;i++){
	            if(target==input_arr[i]){
	                //pick a number from count
	                 picked_random=rand.nextInt(count_withtarget--);
	                if(picked_random==0){
	                    //that means the count has reached 0 by subtracting/random number gave an ouput of 0, so we have gone thru all the elements as picked a random one
	                    //index=i;
	                    //Great idea! I was wondering if every index probability distributes equally. I did some math and looks like yes, all the indexes of the duplicate numbers have equal 1/n probability (where n is a number of duplicates). This is trivial for the last index, it's just 1/count. But what about the first one? At first try, the first index will be selected with a probability of 100%, but what's next? Let's try to multiply 1 * (1 - 1/2) * (1 - 1/3) * (1 - 1/4) * ... * (1 - 1/n) = 1 * 1/2 * 2/3 * 3/4 * ... * n-1/n = (n - 1)! / n! = 1 / n
	                    return i;
	                }
	                
	                
	            }
	        }
	        //never comes here
	        return -1;
	    }
	}

	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(nums);
	 * int param_1 = obj.pick(target);
	 */
}

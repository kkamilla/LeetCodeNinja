package binarysearch_modified;

import java.util.Random;

public class RandomPickRepeatedOcc_398 {
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
	       
	       //pick a random index from 0 to count_withtarget  , this works because
	        //if we have a map with element and indexes that its present in the array, then we can simply pick a 
	        //random index from that list of indexes and that would be out retun index
	        //instead of using extra space we can only pick  a random number between 0 to list's  size for list of indexes  
	        //and try to find that occurance of the number going thru the array again.
	       int ran=rand.nextInt(count_withtarget);
	       //search for that occuranc eof target in the arr
	       int seen_occurance_number_oftarget=0;
	        for(int i=0;i<input_arr.length;i++){
	            if(target==input_arr[i]){
	                
	               //check if the seen_occurance_count is same as ran
	                if(seen_occurance_number_oftarget==ran){
	                    return i;
	                }
	                //we increement the count later as we count 1st occurance of target as 0
	                seen_occurance_number_oftarget++;
	            }
	        }
	       //should not go here
	       return -1;
	   } 
	   }
}

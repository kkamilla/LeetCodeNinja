package cyclicSort;

public class DuplicateNum_287 {
	class Solution {
//	     public int findDuplicate(int[] nums) {
//	         //does not work for [2,2,2,2,2]
//	         int expected_xor=1;
//	         for(int i=2;i<nums.length;i++){
//	             expected_xor^=i;
//	         }
//	         int actual_xor=nums[0];
//	         for(int i=1;i<nums.length;i++){
//	             actual_xor^=nums[i];
//	         }
	        
//	         return expected_xor^actual_xor;
//	     }
	    //set solution is n extra space
	    
	    //sorting solution is nlogn
		
		//O(N) solution by fast and slow pointer method
	    public int findDuplicate(int[] nums){
	        // Find the intersection point of the two runners.
	        //as 0 number is not present in arr
	        int tortoise = nums[0];
	        int hare = nums[0];
	        do {
	            tortoise = nums[tortoise];
	            hare = nums[nums[hare]];
	        } while (tortoise != hare);
	        System.out.println(tortoise);
	        
	        System.out.println(hare);
	        // Find the "entrance" to the cycle.
	        int ptr1 = nums[0];
	        //point where they met
	        int ptr2 = tortoise;
	        while (ptr1 != ptr2) {
	            ptr1 = nums[ptr1];
	            ptr2 = nums[ptr2];
	        }

	        
	        return ptr2;
	    }
	}
}

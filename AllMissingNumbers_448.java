package cyclicSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AllMissingNumbers_448 {
	class Solution {
		//O(n) solution with no extra space
	    public List<Integer> findDisappearedNumbers_noextra_space(int[] nums) {
	        /*This solution is using the relation between array index ([0, n-1]) and the given value range [1,n].

	Each time when a new value X is read, it changes the corresponding Xth number (value at index X-1) into negative, indicating value X is read for the first time.
	For example. using the given test case [4,3,2,7,8,2,3,1], when it comes to i = 2 in the first loop, this solution marks the 2nd number (index = 1), indicating we've found number 2 for the first time.

	When we encounter a redundant number Y, because we've marked the Yth position (index Y -1) when we saw Y for the first time, the if clause won't let us flip it again. This leaves the already marked Yth number (number at index Y-1) negative.
	For example, in the given test case, when i = 5, val = |2| - 1 = 1, nums[1] = -3 < 0. No flip operation is needed because we've found value 2 before.

	Looping through the 1st loop takes O(n) time, flipping signs won't take extra space.

	The second loop checks the signs of the values at indices. If the sign at index P is negative, it means value P + 1 is in the array. e.g. nums[0] = -4, so value 0+1 = 1 is in the array. If the value at index Q is positive, then value Q + 1 is not in the array. e.g. nums[4] = 8 > 0, value 4 + 1 = 5, we add 5 into the ret list.*/
	       for(int i=0;i<nums.length;i++){
	           //mark value at index nums[i]-1 as -ve to mark we found that ( nums[i]-1) index in the array
	           int index_val=Math.abs(nums[i])-1;
	           //we are considering 0 based index , 0 to n-1
	           if(nums[index_val]>0){
	               nums[index_val]=-nums[index_val];
	           }
	       } 
	        List<Integer> res=new ArrayList<>();
	        for(int i=0;i<nums.length;i++){
	           
	           //check which numbers have not been marked as -ve , that means that index+1 value was not present in the array
	           if(nums[i]>0){
	               res.add(i+1);
	           }
	       }
	       return res; 
	    }
	    //extra space solution
	     public List<Integer> findDisappearedNumbers(int[] nums) {
	         HashSet<Integer> set=new HashSet<>();
	         for(int i=0;i<nums.length;i++){
	           
	             set.add(nums[i]);
	           }
	       
	        List<Integer> res=new ArrayList<>();
	        for(int i=1;i<=nums.length;i++){
	            if(!set.contains(i)){
	                res.add(i);
	            }
	        }
	        return res;
	     }
	}
}

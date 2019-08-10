package cyclicSort;

import java.util.ArrayList;
import java.util.List;

public class AllDuplicates_442 {
	class Solution {
	    public List<Integer> findDuplicates(int[] nums) {
	      //index in the array is 0 based
	        //0 to nums.length-1
	        //but numbers in the array are between 1 to len+1
	        //we mark all numbers at index =(value-1) as -ve and when we encounter an index in which the value is already -ve then that index+1 is a repeating index as we are visiting that index again now
	        List<Integer> res=new ArrayList<>();
	        for(int i=0;i<nums.length;i++){
	            int index=Math.abs(nums[i])-1;//as 0 based index and numebrs are from 1 to n
	            if(nums[index]<0){
	                res.add(index+1); 
	            }
	            //make it -ve to kind of mark as visisted
	            nums[index]=-nums[index];
	        }
	        return res;
	    }
	}
}

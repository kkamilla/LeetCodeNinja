package recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsDuplicates_90 {
	class Solution {
	    public List<List<Integer>> subsetsWithDup(int[] nums) {
	       List<List<Integer>> res=new ArrayList<>();
		        Arrays.sort(nums);
		        List<Integer> subset=new ArrayList<>();
		         subsets_backtrack(nums, 0,subset, res);
		        return res;
		    }
		    
		    public void subsets_backtrack(int[] nums,int currIndex,List<Integer> subset,List<List<Integer>> res) {
		        List<Integer> temp=new ArrayList<>(subset);
		        res.add(temp);//as we are making changes to subset and its passed by reference, so subsets values will be overwrittien if we add subset instead
	            
	                for(int i=currIndex;i<nums.length;i++){
		            //copy elements only until that into reslist
	                    //for 1st round when i==currIndex, we need to skip this check as i can be 0 as well and we want to get aset with all elements as well despite the repetatiion
	                if(i>currIndex && nums[i-1]==nums[i]){
	                    continue;
	                }
	                    subset.add(nums[i]);
		            //call subproblem from here after adding index ith element
		            subsets_backtrack( nums, i+1,subset, res);
	                 
		            //remove the added element ith element to try other elements in for loop
		             subset.remove(new Integer(nums[i]));
	                }
	            
		        
		     }
		        
	}
}

package recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
	class Solution {
	    public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> res=new ArrayList<>();
	        
	        List<Integer> subset=new ArrayList<>();
	         subsets_backtrack(nums, 0,subset, res);
	        return res;
	    }
	    
	    public void subsets_backtrack(int[] nums,int currIndex,List<Integer> subset,List<List<Integer>> res) {
	        List<Integer> temp=new ArrayList<>(subset);
	        res.add(temp);//as we are making changes to subset and its passed by reference, so subsets values will be overwrittien if we add subset instead
	        for(int i=currIndex;i<nums.length;i++){
	            //copy elements only until that into reslist
	            subset.add(nums[i]);
	            //call subproblem from here after adding index ith element
	            subsets_backtrack( nums, i+1,subset, res);
	            
	            //remove the added element ith element to try other elements in for loop
	             subset.remove(subset.size() - 1);
	            
	        }
	        
	    }
	    
	    
	    
	    //using include/don't include technique
	    public List<List<Integer>> subsets_rec(int[] nums) {
	        List<List<Integer>> res=new ArrayList<>();
	        int[] usedArray=new int[nums.length];//max size of the subset is len of nums
	         subsets_rec(nums, 0,usedArray,0, res);
	        return res;
	    }
	    
	    public void subsets_rec(int[] nums,int currIndex,int[] usedArray,int usedArrIndex,List<List<Integer>> res) {
	        if(currIndex==nums.length){
	            List<Integer> subset=new ArrayList<>();
	            for(int i=0;i<usedArrIndex;i++){
	                //copy elements only until that into reslist
	                subset.add(usedArray[i]);
	            }
	            res.add(subset);
	        }
	        else{
	           
	            //don't add the current index element
	            subsets_rec(nums, currIndex+1,usedArray,usedArrIndex, res);
	             //use the currIndex
	                usedArray[usedArrIndex]=nums[currIndex];
	             subsets_rec(nums, currIndex+1,usedArray,usedArrIndex+1, res);
	        }
	    }
	    
	    
	    //itertaive  approach
	    public List<List<Integer>> subsets_iter(int[] nums) {
	        long pow_set_size =  
	            (long)Math.pow(2, nums.length);
	        List<List<Integer>> res=new ArrayList<>();
	        for(int i=0;i<pow_set_size;i++){
	        List<Integer> subset=new ArrayList<>();
	            for(int j=0;j<nums.length;j++){
	                //check if jth bit is set
	                if((i & (1<<j))>0){
	                    //then add the jth element to subset
	                    subset.add(nums[j]);
	                }
	            }
	           List<Integer> temp=new ArrayList<>(subset);
	        res.add(temp); 
	            
	        }
	        return res;
	    }
	}
}

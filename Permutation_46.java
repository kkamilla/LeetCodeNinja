package recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation_46 {
	class Solution {
	    public List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> res=new ArrayList<>();
	        List<Integer> currentlist=new ArrayList<>();
	        permute_backtrack(nums,0,res,currentlist);
	        return res;
	    }
	    void permute_backtrack(int[] nums,int startIndex,List<List<Integer>> res,List<Integer> currList){
	         if(startIndex==nums.length){
	             //copy content of the array to a list and add it to res
	             
	             res.add(new ArrayList<>(currList));
	         }
	        
	        for(int i=0;i<nums.length;i++){
	           
	            if(currList.contains(nums[i])){ continue;}
	            currList.add(nums[i]);
	            //call assistanrt after element at startindex is fixed
	            permute_backtrack(nums, startIndex+1, res,currList);
	            
	            //undo as we have to return the array as it is we got from our parent
	            currList.remove(currList.size()-1);
	        }
	     }
	    
	    
	    public List<List<Integer>> permute_recur(int[] nums) {
	        //fix current position eleemnt and  passon the next index as thee start pf the array of elements whose positin you have not fixed yet
	        //after my child returns from recursive call , it restores the array as it was given to it without messing up the order, so that i know which element has not got a chance to be at positon current and i give that element next chance by fixing it as pos=current and passing on the rest to my child call
	        List<List<Integer>> res=new ArrayList<>();
	        permuteRecur(nums,0,res);
	        return res;
	        
	    }
	    
	    void permuteRecur(int[] nums,int startIndex,List<List<Integer>> res){
	         if(startIndex==nums.length){
	             //copy content of the array to a list and add it to res
	             List<Integer> temp=new ArrayList<>();
	             for(int s:nums){
	                 temp.add(s);
	             }
	             res.add(temp);
	         }
	        //try all elements by fixng each at pos=strart by swap
	        for(int i=startIndex;i<nums.length;i++){
	            //swap startindex with i index
	            swap(startIndex,i,nums);
	            //call assistanrt after element at startindex is fixed
	            permuteRecur(nums, startIndex+1, res);
	            
	            //undo the swap as we have to return the array as it is we got from our parent
	            swap(startIndex,i,nums);
	        }
	     }
	    
	    void swap(int i,int j,int[]nums){
	        int temp=nums[i];
	        nums[i]=nums[j];
	        nums[j]=temp;
	    }
	}
}

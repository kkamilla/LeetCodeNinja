package recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {
	class Solution {
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> res=new ArrayList<>();
	        List<Integer> templist =new ArrayList<>();
	        combinationSum_backtrack(candidates, 0,  target, 0, res, templist) ;
	        //backtrack(res, new ArrayList<>(), candidates, target, 0 );
	           return res;
	    }
	    
	    
	    public void combinationSum_backtrack(int[] candidates,int currIndex, int target,int currSum,List<List<Integer>>  res,List<Integer> templist) {
	        
	         if( currSum>target){
	            
	            return;
	        }
	        else if(currSum==target){
	            res.add(new ArrayList<>(templist));
	           // return;
	        }
	        
	        else{    
	            //beacuse this is combinations we start from currIndex as we don't want to consider eelemnts befoer that for the current set as that will give us all permuatiaons instead as here 2,2,3 is same as 3,2,2 so once we are at index of element 3 then we don't want to consider previouysly already considered ones again else that will result in permutations
	            for(int i=currIndex;i<candidates.length;i++){
	                 //include one instance of the crrent index
	                // if(templist.contains(candidates[i])){
	                //     continue;
	                // }
	                templist.add(candidates[i]);
	                //if it safe to proceed
	                //if(currSum+candidates[i]<=target){
	                //as we can resuse the same element again, so we don't advance currIndex
	                    combinationSum_backtrack(candidates,i,  target, currSum+candidates[i],  res,templist ); 
	                templist.remove(templist.size()-1);
	            }
	           
	        }
	        
	    }
	    
	    //same as above onyl with remainingsum
	    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
		    if(remain < 0) return;
		    else if(remain == 0) list.add(new ArrayList<>(tempList));
		    else{ 
		        for(int i = start; i < nums.length; i++){
		            tempList.add(nums[i]);
		            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
		            tempList.remove(tempList.size() - 1);
		        }
		    }
		}
	    public List<List<Integer>> combinationSum_usingsubset(int[] candidates, int target) {
	        List<List<Integer>> res=new ArrayList<>();
	        List<Integer> templist =new ArrayList<>();
	        combinationSum_subset(candidates,  target, 0,0,  res,templist );
	           return res;
	    }
	    public void combinationSum_subset(int[] candidates, int target,int currIndex,int currSum,List<List<Integer>>  res,List<Integer> templist) {
	        if(currSum==target){
	            res.add(new ArrayList<>(templist));
	            return;
	        }
	        if(currIndex>=candidates.length || currSum>target){
	            
	            return;
	        }
	        else{
	            //don't include the current element
	            combinationSum_subset(candidates,  target, currIndex+1, currSum,  res, templist);
	            
	            //include one instance of the crrent index
	            templist.add(candidates[currIndex]);
	             combinationSum_subset(candidates,  target, currIndex, currSum+candidates[currIndex],  res,templist );
	            templist.remove(templist.size()-1);
	        }
	        
	    }
	}
}

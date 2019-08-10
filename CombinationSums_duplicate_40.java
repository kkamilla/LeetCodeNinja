package recursion_backtracking;

public class CombinationSums_duplicate_40 {
	class Solution {
	    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	       List<List<Integer>> res=new ArrayList<>();
		        List<Integer> templist =new ArrayList<>();
	            Arrays.sort(candidates);
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
		                if(i>currIndex && candidates[i]==candidates[i-1]){
		                    continue;
		                }
		                templist.add(candidates[i]);
		                //if it safe to proceed
		                //if(currSum+candidates[i]<=target){
		                //as we can resuse the same element again, so we don't advance currIndex
	                    
		                combinationSum_backtrack(candidates,i+1,  target, currSum+candidates[i],  res,templist ); 
		                templist.remove(templist.size()-1);
		            }
		           
		        }
		        
		    }
	}
}

package recursion_backtracking;

public class PermuationDuplicates_47 {
	class Solution {
	    public List<List<Integer>> permuteUnique(int[] nums) {
	    //fix current position eleemnt and  passon the next index as thee start pf the array of elements whose positin you have not fixed yet
		        //after my child returns from recursive call , it restores the array as it was given to it without messing up the order, so that i know which element has not got a chance to be at positon current and i give that element next chance by fixing it as pos=current and passing on the rest to my child call
		    Arrays.sort(nums);  
	        boolean[] used = new boolean[nums.length];
	        List<List<Integer>> res=new ArrayList<>();
	        List<Integer> templist=new ArrayList<>();
		        permute_backrtrack(nums,res,used,templist);
		        return res;
		        
		    }
		    
		    void permute_backrtrack(int[] nums,List<List<Integer>> res,boolean[] used,List<Integer> templist){
		         if(templist.size()==nums.length){
		            
		             
		             res.add(new ArrayList<>(templist));
		         }
		        //try all eleents by fixng each at pos=strart by swap
		        for(int i=0;i<nums.length;i++){
		            //swap startindex with i index
	                if(used[i]==true){continue;}//normal backtracking check to see it fthe ith element is already in templist, if so skip adding it
	                if(i>0 && nums[i-1]==nums[i] && used[i-1]){
	                    continue;
	                }
	                used[i]=true;
		            templist.add(nums[i]);
		            //call assistanrt after element at startindex is fixed
		            permute_backrtrack(nums, res,used,templist);
		            
		            //undo the swap as we have to return the array as it is we got from our parent
	                used[i]=false;
		             templist.remove(templist.size()-1);
	                
		        }
		     }
		    
	}
}

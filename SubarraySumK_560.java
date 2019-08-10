package twoPointer;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumK_560 {
	class Solution {
	    //O(N^2) solution with no extra space
	    
	    public int subarraySum(int[] nums, int k) {
	        
		       
		        int numOfArrays=0;
		        for(int start=0;start<nums.length;start++){
	                //find sum starting index start and see when the sum ==k then add it to count
	                int sum=0;
	                for(int end=start;end<nums.length;end++){
	                    sum+=nums[end];
	                    if(sum==k){
	                        numOfArrays++;
	                    }
	                    //array has -ve numbers so caanot break if sum>k
	                    // if(sum>k){
	                    //     break;
	                    // }
	                }
		            
		        }
		        return numOfArrays;
	    }
	    
	    
	    //O(N) solution with O(N) space 
	    public int subarraySum_hmap(int[] nums, int k) {
	        //this contains all sums to number of times this sum has appreared previously mapping found until now
		        Map<Integer,Integer> sumMap=new HashMap<>();
		        //at the beginning sum=0 so we add this entry
		        sumMap.put(0,1);
		        
		        int sum=0;
		        int numOfArrays=0;
		        for(int i=0;i<nums.length;i++){
	                //cumulative sum until index i
		           sum+=nums[i];
		            //check if there is an entry in hashmap which if we subtract from sum, would give us k
		            int sum_to_remove=sum-k;
		            if(sumMap.containsKey(sum_to_remove)){
		                numOfArrays+=sumMap.get(sum_to_remove);
		            }
		//if we find a sum value which is already in the map, then 
		            //if sum not in hashmap, then add it
		            if(!sumMap.containsKey(sum)){
		                sumMap.put(sum,1);
		            }
	                //if its there then add to count in hashmap
	                else if(sumMap.containsKey(sum)){
		                int s=sumMap.get(sum);
	                    s++;
	                    sumMap.put(sum,s);
		            }
		        }
		        return numOfArrays;
	    }
	}
}

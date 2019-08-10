package cyclicSort;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPos_41 {
	class Solution {
	    
	    
	    //O(N) time , no extra space
	    public int firstMissingPositive(int[] nums) {
	        if(nums.length==0){
	            return 1;
	        }
	        
	        int min=Integer.MAX_VALUE;
	        int max=Integer.MIN_VALUE;
	        //clean up -ve and nums>nums.length and replace with 1 if 1 is not present in the array
	        boolean flag_one=false;
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]==1){
	                flag_one=true;
	            }
	        }
	        // nums = [1]
	        if (nums.length == 1 && flag_one==true)
	            return 2;
	        if(!flag_one){
	            return 1;
	        }
	        else{
	           //clean up -ve and 0, and numbers>nums.length and replace with 1 if 1 is present in the array
	            for(int i=0;i<nums.length;i++){
	                if(nums[i]<=0 || nums[i]>nums.length){
	                    nums[i]=1;
	                }
	            }
	            //change sign of num[i] element to -ve if i is in array
	             for(int i=0;i<nums.length;i++){
	                 int index=Math.abs(nums[i])-1;//as it start from 1 
	                 // //if (index == nums.length)
	                 //  nums[0] = - Math.abs(nums[0]);//as we removed 0
	                 //to avoid duplicates
	                  nums[index]=-Math.abs(nums[index]);
	                 
	            }
	            
	            //check which index has +ve number
	            boolean all_negetive=true;
	             for(int i=0;i<nums.length;i++){
	                  System.out.println("nums="+nums[i]);
	                if(nums[i]>0){
	                    all_negetive=false;
	                    System.out.println("i="+i);
	                    if(nums[i]<=nums.length){
	                        System.out.println(i);
	                        return i+1;
	                    }
	                    // else{
	                    //     //if greater than len then return nums.len+1
	                    //     return nums.length+1;
	                    // }
	                }  
	            }
	            
	            //after for loop if all still neegtive
	            if(all_negetive){
	                     //if all numbers are -ve and no +ve numebr found
	                     return nums.length+1;
	                 }
	            
	        }
	        //never comes here
	        return -1;
	    }
	    public int firstMissingPositive_extraspace(int[] nums) {
	        if(nums.length==0){
	            return 1;
	        }
	        Set<Integer> targetSet = new HashSet<>(); 
	        for(int j=0;j<nums.length;j++){
	            targetSet.add(nums[j]);
	        }
	        int min=Integer.MAX_VALUE;
	        int max=Integer.MIN_VALUE;
	        for(int i=1;i<=nums.length;i++){
	            if(!targetSet.contains(i)){
	                min=Math.min(i,min);
	                
	            }
	            //get max of all numbers in array in case all numbers are presetn we need to use it to get next positive number
	            max=Math.max(max,i);
	        }
	        
	        //if all numbers are present then min is not changed
	        if(min==Integer.MAX_VALUE ){
	            if(!targetSet.contains(nums[nums.length-1]+1)){
	                return nums[nums.length-1]+1;
	            }
	            else{
	                //[2,1] return 3
	                return max+1;
	            }
	        }
	      
	        return min;
	    }
	}
}

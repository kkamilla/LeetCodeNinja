package cyclicSort;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges_163 {
	class Solution{ 
		public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		        //
		        List<String> res=new ArrayList<>();
		        if(nums.length==0){
		            if(lower!=upper){
		                res.add(lower+"->"+upper);
		            }
		            else{
		                res.add(lower+"");
		            }
		            
		            return res;
		        }
		        long start=lower;
		        //int end=Integer.MIN_VALUE;
		       
		        for (int i = 0; i < nums.length; i++) {
		            // not within the range yet
		            if (nums[i] < start) {
		                continue;
		            }
		            if(nums[i]==start){
		                start++; 
		                continue;
		            }
		            
		            //adding to range
		            //end=nums[i]-1
		            if(start==nums[i]-1 ){
		                res.add(start+"");
		                System.out.println("1");
		                start=(long)nums[i]+1;
		            } 
		            else if(start<nums[i]-1){
		                System.out.println("2");
		                res.add(start+"->"+(nums[i]-1));
		                //to avoid iverflow by aading 1 to int , it becomes -ve number and causes issue MAX+1=-ve int min
		                start=(long)nums[i]+1;
		            }
		        }
		        
		        //after while loop check if last number is less that upper
		        if(nums[nums.length-1]!=upper){
		            if((nums[nums.length-1]+1)!=upper){
		                System.out.println("end");
		                res.add((nums[nums.length-1]+1)+"->"+upper);
		            }
		            else{
		                res.add(upper+"");
		            }
		        }
		        
		       return res; 
		    }
		}
}

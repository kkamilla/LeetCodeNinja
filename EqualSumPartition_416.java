package dp_boundedKnapsack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSumPartition_416 {
	class Solution {
	    
	    
	    public boolean canPartition_dp(int[] nums) {
	        int sum=0;
	        for(int i=0;i<nums.length;i++){
	            sum+=nums[i];
	        }
	        boolean[][] dptable=new boolean[nums.length][(sum/2)+1];
	        //System.out.println(sum/2);
	        
	        if(sum%2!=0){
	            return false;
	        }
	        else{
	           
	            //sum /= 2;
	            //first col is all true as sum of 0 is possible with empty set
	            dptable[0][0]=true;
	            for(int row=1;row<nums.length;row++){
	              
	                dptable[row][0]=true;
	            }
	            //intialaize first row to all false except 0,0 to true
	            for(int col=1;col<(sum/2)+1;col++){
	                 //System.out.println(col);
	                //as dp[0][col] means considering elements till 0 , is it possible to create a sum ==col
	                dptable[0][col]=nums[0]==col?true:false;//if sum needed is same as 0th element
	            }
	            
	            //for filling rest of the values, we need to dp[index][sum]=dp[index-1][sum]||dp[index-1][sum-arr[index]]
	            //filling it bottom up we first call canPartition(num.length,target)=canPartion(num.length-1,target)||canParttion(num.length-1,target-nums[lenght-1])
	            //so f(1,sum)=f(0,sum)||f(0,sum-nums[1])
	            sum=sum/2;
	           for(int row=1;row<nums.length;row++){
	               for(int col=1;col<(sum)+1;col++){
	                   //System.out.println(row+":"+col);
	                   if(col-nums[row]>=0){
	                      dptable[row][col]=dptable[row-1][col]||dptable[row-1][col-nums[row]];  
	                   }
	                   else{
	                       dptable[row][col]=dptable[row-1][col]||false;
	                   }
	                  
	               }
	           }
	        }
	        return dptable[nums.length-1][sum];
	    }
	    public boolean canPartition(int[] nums) {
	        int sum=0;
	        for(int i=0;i<nums.length;i++){
	            sum+=nums[i];
	        }
	        if(sum%2!=0){
	            return false;
	        }
	        else{
	            List<Integer> currList=new ArrayList<>();
	          
	            Map<String,Boolean> memo =new HashMap<>();
	           //return canPartition_rec( nums,0,sum/2,currList,memo) ;
	            return canPartition_dp(nums);
	        }
	    }
	    

	     public boolean canPartition_rec(int[] nums,int index,int target,List<Integer> currList,Map<String,Boolean> memo) {
	         if(memo.containsKey(index+":"+target)){
	             return memo.get(index+":"+target);
	         }
	         if(target==0 ){
	             return true;
	         }
	         
	         if(index==nums.length){
	             return false;
	         }
	         //don't add
	         boolean x=canPartition_rec(nums, index+1, target, currList,memo) ;
	         //currList.add(nums[index]);
	         x=x||canPartition_rec(nums, index+1, target-nums[index], currList,memo) ;
	         // currList.remove(currList.size()-1);
	         memo.put(index+":"+target,x);
	         return x;
	         
	     }
	    
	    
	    
	}
}

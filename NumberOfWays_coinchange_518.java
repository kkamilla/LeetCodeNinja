package dp_UnboundedKnapsack;

import java.util.HashMap;
import java.util.Map;

public class NumberOfWays_coinchange_518 {
	class Solution {
	    public int change(int amount, int[] coins) {
	        Map<String,Integer> memo=new HashMap<>();
	    // return change_rec(amount, coins, 0,memo) ;
	        return change_dp( amount, coins) ;
	    }
	    public int change_rec(int amount, int[] coins,int currIndex,Map<String,Integer> memo) {
	        if(amount==0){
	            //found a way
	            return 1;
	        }
	        if(amount<0 || currIndex==coins.length){
	            return 0;
	        }
	        if(memo.containsKey(currIndex+":"+amount)){
	            return memo.get(currIndex+":"+amount);
	        }
	        //excelude
	        int x=change_rec(amount, coins, currIndex+1,memo) ;
	        //include
	        x+=change_rec(amount-coins[currIndex], coins, currIndex,memo) ;
	        memo.put(currIndex+":"+amount,x);
	     return x;
	    }
	    
	    
	    public int change_dp(int amount, int[] coins) {
	        if(coins.length==0 && amount==0){
	            return 1;
	        }
	        if(coins.length==0 ){
	            return 0;
	        }
	      int[][] dp=new int[coins.length][amount+1];
	        //intialize 1st col as 1 as there is one way of making amt=0 by not using any coin
	        for(int row=0;row<coins.length;row++){
	            dp[row][0]=1;
	        }
	        //intialize 1st row as 1 if there is a way of making amt=col by  using 1 coin of row=0
	        for(int col=0;col<amount+1;col++){
	            int sum=col;
	            //if coin[0] is a multiple of amount col then we can make col using coin[0] , so we found 1 way of doing it
	            if(col%coins[0]==0){
	                dp[0][col]=1;
	            }
	             
	        }
	        for(int row=1;row<coins.length;row++){
	            for(int col=1;col<amount+1;col++){
	                //exclude
	               dp[row][col]=dp[row-1][col];
	                if(col-coins[row]>=0){
	                    //include atleat 1 of row type coin
	                    //multiple is max number of times i can take coin[row] until col-m
	                    for(int multiple=1;multiple<=col/coins[row];multiple++){
	                       dp[row][col]+=dp[row-1][col-multiple*coins[row]]; 
	                    }
	                    
	                }
	                
	            }
	            
	        }
	        
	        return dp[coins.length-1][amount];
	    }
	    public int change_dp_(int amount, int[] coins) {
	        if(coins.length==0 && amount==0){
	            return 1;
	        }
	        if(coins.length==0 ){
	            return 0;
	        }
	      int[][] dp=new int[coins.length][amount+1];
	        //intialize 1st col as 1 as there is one way of making amt=0 by not using any coin
	        for(int row=0;row<coins.length;row++){
	            dp[row][0]=1;
	        }
	        //intialize 1st row as 1 if there is a way of making amt=col by  using 1 coin of row=0
	        for(int col=0;col<amount+1;col++){
	            int sum=col;
	            //if coin[0] is a multiple of amount col then we can make col using coin[0] , so we found 1 way of doing it
	            if(col%coins[0]==0){
	                dp[0][col]=1;
	            }
	            // while(sum>=0){
	            //    if(sum==0){
	            //         dp[0][col]=1;
	            //            break;
	            //     }
	            //     else{
	            //         sum-=coins[0];
	            //     } 
	            // }  
	        }
	        for(int row=1;row<coins.length;row++){
	            for(int col=1;col<amount+1;col++){
	                //exclude
	               dp[row][col]=dp[row-1][col];
	                if(col-coins[row]>=0){
	                    //include atleat 1 of row type coin
	                    dp[row][col]+=dp[row][col-coins[row]];
	                }
	                
	            }
	            
	        }
	        
	        return dp[coins.length-1][amount];
	    }
	}
}

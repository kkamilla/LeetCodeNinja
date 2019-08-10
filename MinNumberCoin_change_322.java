package dp_UnboundedKnapsack;

public class MinNumberCoin_change_322 {
	   public int coinChange(int[] coins, int amount) {
	        int[] dptable=new int[amount+1];
	        for(int i=0;i<dptable.length;i++){
	            dptable[i]=Integer.MAX_VALUE;
	        }
	        dptable[0]=0;
	        for(int a=0;a<=amount;a++){
	            int min=Integer.MAX_VALUE;
	            for(int k=0;k<coins.length;k++){
	                if(a-coins[k]>=0){
	                    min=Math.min(min,dptable[a-coins[k]]);
	                }
	            }
	            //to avoid int overflow on adding 1
	            if(min!=Integer.MAX_VALUE){
	                dptable[a]=min+1;}
	            
	        }
	        if(dptable[amount]==Integer.MAX_VALUE){return -1;}
	        return dptable[amount];
	    }
	   
	   public int coinChange_2d( int[] coins,int amount) {
	        if(coins.length==0 && amount==0){
	            return 0;
	        }
	        if(coins.length==0 ){
	            return 0;
	        }
	      int[][] dp=new int[coins.length][amount+1];
	        for(int i=0;i<dp.length;i++){
	            for(int col=0;col<amount+1;col++){
	               dp[i][col]=Integer.MAX_VALUE; 
	            }
	            
	        }
	        //intialize 1st col as 1 as there is one way of making amt=0 by not using any coin
	        for(int row=0;row<coins.length;row++){
	            dp[row][0]=0;
	        }
	        //intialize 1st row as 1 if there is a way of making amt=col by  using 1 coin of row=0
	        for(int col=0;col<amount+1;col++){
	            int sum=col;
	            //if coin[0] is a multiple of amount col then we can make col using coin[0] , so we found 1 way of doing it
	            if(col%coins[0]==0){
	                dp[0][col]=col/coins[0];
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
	                        //to avoid int overflow on adding 1
	                        int val=Integer.MAX_VALUE;
	                        if(dp[row-1][col-multiple*coins[row]]!=Integer.MAX_VALUE){
	                            //here we use multiple count of current row coin, so we add that 
	                            val=dp[row-1][col-multiple*coins[row]]+multiple;
	                        }
	                       dp[row][col]=Math.min(val,dp[row][col]); 
	                    }
	                    
	                }
	                
	            }
	            
	        }
	        
	        if(dp[coins.length-1][amount]==Integer.MAX_VALUE){return -1;}
	        return dp[coins.length-1][amount];
	    }
	
}

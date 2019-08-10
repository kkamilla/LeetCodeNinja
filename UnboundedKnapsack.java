package dp_UnboundedKnapsack;

public class UnboundedKnapsack {
	 
 // Returns the maximum value with knapsack 
    // of W capacity 
    private static int unboundedKnapsack_my(int W, int n,  
                                int[] val, int[] wt) { 
          
        // dp[i] is going to store maximum value 
        // with knapsack capacity i. 
        int dp[][] = new int[wt.length][W + 1]; 
        for(int j = 0; j < n; j++){ 
        	if(W-wt[0]>=0)
        	dp[j][W-wt[0]]=val[0];
        }
          
        // Fill dp[] using above recursive formula 
        for(int i = 1; i <= W; i++){ 
            for(int j = 1; j < n; j++){ 
                if(wt[j] <= i){ 
                    dp[j][i] = Math.max(dp[j][i], dp[j][i - wt[j]] +  
                                val[j]); 
                } 
                dp[j][i] = Math.max(dp[j][i], dp[j-1][i ]); 
            } 
        } 
        return dp[wt.length-1][W]; 
    }
    // Driver program 
    public static void main(String[] args) { 
        int W = 100; 
        int val[] = {10, 30, 20}; 
        int wt[] = {5, 10, 15}; 
        int n = val.length; 
        
        System.out.println(unboundedKnapsack_my(W, n, val, wt)); 
    } 

}

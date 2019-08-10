package dp_longestCommonSubstring;

public class LongestRepeatedSubsequence {
	
	static int findLongestRepeatingSubSeq_dp(String str) 
    { 
        int n = str.length(); 
   
        // Create and initialize DP table 
        int[][] dp = new int[n+1][n+1]; 
   
        // Fill dp table (similar to LCS loops) 
        for (int i=1; i<=n; i++) 
        { 
            for (int j=1; j<=n; j++) 
            { 
                // If characters match and indexes are not same 
                if (str.charAt(i-1) == str.charAt(j-1) && i!=j) 
                    dp[i][j] =  1 + dp[i-1][j-1];           
                        
                // If characters do not match 
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]); 
            } 
        } 
        return dp[n][n]; 
    }
	static int lrs(String str,int index1,int index2) {
		if(index1==str.length()||index2==str.length()) {
			return 0;
		}
		//do not take the char at index1
		int x=lrs( str, index1+1, index2) ;
		//do not take char at index2
		int y=lrs( str, index1, index2+1) ;
		//take char at both if they match
		int z=0;
		//2nd condition is important, else whole string might result in a common subsequence output
		if(str.charAt(index1)==str.charAt(index2) && index1!=index2) {
			//then we can add 1 to result
			z=1+lrs( str, index1+1, index2+1) ;
		}
		int max=Math.max(x, y);
		max=Math.max(max, z);
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "axxxy"; 
        System.out.println("The length of the largest subsequence that"
            +" repeats itself is : "+lrs(str,0,1)); 

	}

}

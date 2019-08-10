package dp_longestCommonSubstring;

public class LongestCommonSubsequence {
	static int lcs_dp(String x,String y) {
		  int[][] dptable=new int[x.length()+1][y.length()+1];
		  
		  //1st row and 1st col denotes empty strings in both the strings, so fill with 0 as lcs when one of the string is empty is 0
		  for(int row=0;row<x.length();row++) {
			  dptable[row][0]=0;
		  }
		  for(int col=0;col<y.length();col++) {
			  dptable[0][col]=0;
		  }
		//now we will dp[x][y] ={1+dp[x-1][y-1], dp[x][y-1], dp[x-1][y]} 
		  
		  for(int row=1;row<=x.length();row++) {
			  for(int col=1;col<=y.length();col++) {
				  int k=0,h=dptable[row-1][col],z=dptable[row][col-1];
				  if(x.charAt(row-1)==y.charAt(col-1)) {
					  k=1+dptable[row-1][col-1];
				  }
				  dptable[row][col]=Math.max(k, Math.max(h, z));
			  }
		  }
		  return dptable[x.length()][y.length()];
		  
	  }
	
	
	public static void main(String[] args)  
    { 
        String X = "New122112"; 
        String Y = "New22211"; 
        String s1 = "AGGTAB"; 
        String s2 = "GXTXAYB"; 
    
        
        System.out.println(lcs_dp(s1,s2));
        }
}

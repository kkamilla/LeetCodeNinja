package dp_longestCommonSubstring;

public class LongestCommonSubstring {
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
		  int result=0;
		  for(int row=1;row<=x.length();row++) {
			  for(int col=1;col<=y.length();col++) {
				  
				  if(x.charAt(row-1)==y.charAt(col-1)) {
					  int k=1+dptable[row-1][col-1];
					  result=Math.max(result, k);
					  dptable[row][col]=k;
					  
				  }
				  else {
					  //as its a subtring, so we caanot skip chars, so we make it 0 as current index chars do not match
					  dptable[row][col]=0;
				  }
				  
				  
			  }
		  }
		  return result;
		  
	  }
	 // Returns length of function for longest common  
	// substring of X[0..m-1] and Y[0..n-1]  
	static  int lcs_recursion(String X,String Y,int i, int j) { 
			System.out.println(i + "_ " + j);
	        if (i >=X.length()  || j >=Y.length()) { 
	            return 0; 
	        } 
	        int count=0;
	        if (X.charAt(i) == Y.charAt(j)) { 
	        	
	            count = lcs_recursion(X,Y,i + 1, j + 1)+1; 
	            System.out.println(count);
	        } else {
	        	count = 0;
	        	
	        }
	       int count1 = Math.max( lcs_recursion(X,Y,i + 1, j), lcs_recursion(X,Y,i , j +1));
	       count = Math.max( count1, count);
//	        count = Math.max(count, Math.max(lcs_recursion(X,Y,i, j +1), 
//	        		lcs_recursion(X,Y,i +1, j))); 
	        return count; 
	    } 
	     
	     
	 
	  
	  public static void main(String[] args)  
	    { 
	        String X = "New122112"; 
	        String Y = "New22211"; 
	        
	        int m = X.length(); 
	        int n = Y.length(); 
//	        int sub_length[][] = new int[m][n];
//	        if (X.charAt(0) == Y.charAt(0)) {
//	        	sub_length[0][0] = 1;
//	        } else {
//	        	sub_length[0][0] = 0;
//	        }
//	        int max = -1000;
//	        for (int i = 1; i < m ; i ++) {
//	        	for (int j = 1; j < n; j ++) {
//	        		if (X.charAt(i) == X.charAt(j)) {
//	        			sub_length[i][j] = sub_length[i-1][j-1] + 1;
//	        			if (sub_length[i][j] > max) {
//	        				 max = sub_length[i][j] ;
//	        			}
//	        		} else {
//	        			sub_length[i][j] = 0;
//	        		}
//	        		
//	        		
//	        		
//	        	}
//	        }
	  
//	        System.out.println("Length of Longest Common Substring is "
//	                + lcs_dp(X, Y)); 
	        
	        System.out.println("Length of Longest Common Substring is "
	                + lcs_recursion(X,Y,0, 0)); 
	    } 
	            
	    
	  
}

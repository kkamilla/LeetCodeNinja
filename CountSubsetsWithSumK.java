package dp_boundedKnapsack;

import java.util.ArrayList;
import java.util.List;

public class CountSubsetsWithSumK {
	// Prints all subsets of arr[0..n-1] with sum 0. 
    static void printAllSubsets(int arr[],  int sum) 
    { 
    	if(arr.length==0) {
    		return ;
    	}
    	boolean[][] dp=new boolean[arr.length][sum+1];
    	//add true in 1st col as sum of 0 is possible by not including anthing
    	for(int row=0;row<arr.length;row++) {
    		dp[row][0]=true;
    	}
    	for(int col=0;col<sum+1;col++) {
    		if(arr[0]==col)
    			dp[0][col]=true;
    	}
    	
    	//fill rest
    	for(int row=1;row<arr.length;row++) {
    		for(int col=1;col<sum+1;col++) {
    			boolean exclude=dp[row-1][col];
    			boolean include=false;
        		if(col-arr[row]>=0)
        			include=dp[row-1][col-arr[row]];
        		
        		dp[row][col]=exclude||include;
        	}
    	}
    	
    	if (dp[arr.length-1][sum]== false) 
        { 
            System.out.println("There are no subsets with" +  
                                                  " sum "+ sum); 
            return; 
        } 
    	if(dp[arr.length-1][sum]) {
    		//print all subsets 
    		List<Integer> currSet=new ArrayList<>();
    		//did not test print funct yet
    		
    		printSubsetsRec( arr,  0,  sum, currSet,dp);
    		
    	}
    }
    
 // A recursive function to print all subsets with the 
    // help of dp[][]. Vector p[] stores current subset. 
    static void printSubsetsRec(int arr[], int currIndex, int currSum, List<Integer> p,boolean[][] dp) 
    { 
    	//if reached sum!=0 and currIndex==0
    	if(currSum!=0 && currIndex==0) {
    		//add the 0th elemnt
    		p.add(arr[0]);
    		System.out.print(p);
    		return;
    		
    	}
    	
    	if(currSum==0 ) {
    		System.out.print(p);
    		return;
    	}
    	//try checking exclude option
    	if(dp[currIndex-1][currSum]==true) {
    		//then we go to cell on top and not add the currIndex elemnt in subset
    		printSubsetsRec( arr,  currIndex+1,  currSum, p,dp);
    	}
    	//we need to aslo try if we can proceed by including this index as it might be true as well as we need all the subsets with sum =k
    	if(currSum-arr[currIndex]>=0) {
    		if(dp[currIndex][currSum-arr[currIndex]]==true) {
        		//then we go to cell on top and not add the currIndex elemnt in subset
    			p.add(arr[currIndex]);
        		printSubsetsRec( arr,  currIndex+1,  currSum-arr[currIndex], p,dp);
        		p.remove(p.size()-1);
        	}
    	}
    	
    }
}

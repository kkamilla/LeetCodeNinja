package dp_boundedKnapsack;

public class SubsetSum {
	public boolean canPartition_kk(int[] num, int sum) {
		boolean dp[][]=new boolean[num.length][sum+1];//as we need to go until sum value so we need entries from 0 to sum
		//so lenght= sum-0+1;
		//1st col is true as sum needed is 0 and it can be formed by not seleting anything so all true
		for(int row=0;row<num.length;row++) {
			dp[row][0]=true;
		}
		
		//1st row can be filled with all values according to if sum==num[0]
		
		for(int col=1;col<sum+1;col++) {
			if(num[0]==sum)
				dp[0][col]=true;
		}
		for(int row=1;row<num.length;row++) {
			for(int col=1;col<sum+1;col++) {
				boolean without=dp[row-1][col];
				boolean with=false;
				if(col-num[row]>=0) {
					with=dp[row-1][col-num[row]];
					
				}
				
				dp[row][col]=without||with;	
			}
			
		}
		
		return dp[num.length-1][sum];
		
	}
  public static void main(String[] args) {
    SubsetSum ss = new SubsetSum();
    int[] num = { 1, 2, 3, 7 };
    //System.out.println(ss.canPartition(num, 6));
    num = new int[] { 1, 2, 7, 1, 5 };
   
    System.out.println(ss.canPartition_kk(num, 10));
    num = new int[] { 1, 3, 4, 8 };
   
    System.out.println(ss.canPartition_kk(num, 6));
  }
}

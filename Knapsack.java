package dp_boundedKnapsack;

public class Knapsack {


		  public int solveKnapsack(int[] profits, int[] weights, int capacity) {
		    return this.knapsackRecursive(profits, weights, capacity, 0);
		  }

		  private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
		    // base checks
		    if (capacity <= 0 || currentIndex >= profits.length)
		      return 0;

		    // recursive call after choosing the element at the currentIndex
		    // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
		    int profit1 = 0;
		    if( weights[currentIndex] <= capacity )
		        profit1 = profits[currentIndex] + knapsackRecursive(profits, weights,
		                capacity - weights[currentIndex], currentIndex + 1);

		    // recursive call after excluding the element at the currentIndex
		    int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

		    return Math.max(profit1, profit2);
		  }

		  
		  public int solveKnapsack_memo(int[] profits, int[] weights, int capacity) {
			    Integer[][] dp = new Integer[profits.length][capacity + 1];
			    return this.knapsackRecursive_memo(dp, profits, weights, capacity, 0);
			  }

			  private int knapsackRecursive_memo(Integer[][] dp, int[] profits, int[] weights, int capacity,
			      int currentIndex) {

			    // base checks
			    if (capacity <= 0 || currentIndex >= profits.length)
			      return 0;

			    // if we have already solved a similar problem, return the result from memory
			    if(dp[currentIndex][capacity] != null)
			      return dp[currentIndex][capacity];

			    // recursive call after choosing the element at the currentIndex
			    // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
			    int profit1 = 0;
			    if( weights[currentIndex] <= capacity )
			        profit1 = profits[currentIndex] + knapsackRecursive_memo(dp, profits, weights,
			                capacity - weights[currentIndex], currentIndex + 1);

			    // recursive call after excluding the element at the currentIndex
			    int profit2 = knapsackRecursive_memo(dp, profits, weights, capacity, currentIndex + 1);

			    dp[currentIndex][capacity] = Math.max(profit1, profit2);
			    return dp[currentIndex][capacity];
			  }
			  
			  private int knapsackRecursive_dp_bottomup( int[] profits, int[] weights, int capacity) {

				  
				  int[][] dptable=new int[weights.length][capacity+1];
				  
				    // base case, add 0's in 1st column as capacity is 0
				    for(int i=0;i<weights.length;i++) {
				    	dptable[i][0]=0;
				    }
				    
				     
				    //fill the 1st row by checking if its possible to take the first object depending on column values which is capacity
				    for(int i=0;i<capacity+1;i++) {
				    	if(weights[0]<=capacity) {
				    		dptable[0][i]=profits[0];
				    	}
				    	else {
				    		dptable[0][i]=0;
				    	}
				    	
				    }
				    
				    //now fill the table row wise
				    for(int row=1;row<weights.length;row++) {
					    for(int col=1;col<capacity+1;col++) {
					    	//not include the row item
					    	
					    	int profit1 = dptable[row-1][col];
					    	
					    	//include the row item
					    	 int profit2 =0;
					    	if(col-weights[row]>=0) {
					    		profit2=profits[row]+dptable[row-1][col-weights[row]];
					    	}
					    	dptable[row][col] = Math.max(profit1, profit2);
					    }
				    }
				    System.out.println("my ..........Selected weights:");
				    printSelectedElements_rec(dptable,weights, profits, capacity, dptable[weights.length-1][capacity], weights.length-1);
				    return dptable[weights.length-1][capacity];
				  }
			  
			  
			  private void printSelectedElements_rec(int dp[][], int[] weights, int[] profits, int capacity,int totalProfit,int curr){
			      System.out.print("Selected weights:");
			      if(totalProfit!=0 && curr<1) {
			        //we need to add the 0th item as totalProfit is not yet 0
			        System.out.print(" " + weights[0]);
			        return;
			      }
			      if(totalProfit==0) {
			        return;
			      }
			        if(totalProfit != dp[curr-1][capacity]) {
			          System.out.print(" adding.." + weights[curr]);
			          
			          printSelectedElements_rec(dp,weights, profits, capacity-weights[curr], totalProfit-profits[curr], curr);
			          
			        }
			        else {
			          printSelectedElements_rec(dp,weights, profits, capacity, totalProfit, curr-1);
			            
			        }
			}
			  private void printSelectedElements_iter(int dp[][], int[] weights, int[] profits, int capacity){
				   System.out.print("Selected weights:");
				   int totalProfit = dp[weights.length-1][capacity];
				   for(int i=weights.length-1; i > 0; i--) {
				     if(totalProfit != dp[i-1][capacity]) {
				       System.out.print(" " + weights[i]);
				       capacity -= weights[i];
				       totalProfit -= profits[i];
				     }
				   }

				   if(totalProfit != 0)
				     System.out.print(" " + weights[0]);
				   System.out.println("");
				 } 
		  public static void main(String[] args) {
		    Knapsack ks = new Knapsack();
		    int[] profits = {1, 6, 10, 16};
		    int[] weights = {1, 2, 3, 5};
		    int maxProfit = ks.solveKnapsack(profits, weights, 7);
		    System.out.println("Total knapsack profit ---> " + maxProfit);
		    maxProfit = ks.solveKnapsack(profits, weights, 6);
		    System.out.println("Total knapsack profit ---> " + maxProfit);
		    int maxProfit2 = ks.knapsackRecursive_dp_bottomup(profits, weights, 6);
		    System.out.println("Total my......knapsack profit ---> " + maxProfit2);
		  }
		  
		  class Index {
		        int remainingWeight;
		        int remainingItems;

		        @Override
		        public boolean equals(Object o) {
		            if (this == o) return true;
		            if (o == null || getClass() != o.getClass()) return false;

		            Index index = (Index) o;

		            if (remainingWeight != index.remainingWeight) return false;
		            return remainingItems == index.remainingItems;

		        }

		        @Override
		        public int hashCode() {
		            int result = remainingWeight;
		            result = 31 * result + remainingItems;
		            return result;
		        }
		    }
		  
		  //Map<Index, Integer> map = new HashMap<>();
		}



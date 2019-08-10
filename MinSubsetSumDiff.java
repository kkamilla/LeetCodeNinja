package dp_boundedKnapsack;

public class MinSubsetSumDiff {
	public static  int findMinRec(int arr[], int currIndex, int sumCalculated, int sumTotal) 
{
		if(currIndex==arr.length) {
			//find the sum collected until now
			int diff=Math.abs(sumTotal-sumCalculated-sumCalculated);
			return diff;
		}
		else {
			int x=findMinRec(arr,  currIndex+1,  sumCalculated,  sumTotal) ;
			int y=findMinRec(arr,  currIndex+1,  sumCalculated+arr[currIndex],  sumTotal) ;
			return Math.min(x, y);
		} 
}
	public static int findMin(int arr[], int n) 
    { 
        // Compute total sum of elements 
        int sumTotal = 0; 
        for (int i = 0; i < n; i++) 
            sumTotal += arr[i]; 
       
        // Compute result using recursive function 
        return findMinRec(arr, 0, 0, sumTotal); 
    } 
}

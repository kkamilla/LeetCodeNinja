package grokking_2slidingwindow;

public class MaxSumSubArrayOfSizeK {
	
	
	
	static int findMaxSumSubArray(int k,int[] arr) {
		int window_start=0;
		int max_sum=0;
		int curr_sum=0;
		for(int window_end=0;window_end<arr.length;window_end++) {
			curr_sum+=arr[window_end];
			//slide the window if its equal to k size
			if(window_end-window_start==k-1) {
				max_sum=Math.max(max_sum, curr_sum);
				curr_sum=curr_sum-arr[window_start];// subtract the element going out of thw window
				window_start++;// slide the window ahead
			}
		}
		return max_sum;
	}

	public static void main(String[] args) {
	    System.out.println("Maximum sum of a subarray of size K: "
	        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
	    System.out.println("Maximum sum of a subarray of size K: "
	        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
	  }
}

package binaryIndexTreesFenwick;
/*
 * Input : arr = {0, 0, 0, 0, 0}
Queries: update : l = 0, r = 4, val = 2
         getElement : i = 3
         update : l = 3, r = 4, val = 3 
         getElement : i = 3

Output: Element at 3 is 2
        Element at 3 is 5
 
Explanation : Array after first update becomes
              {2, 2, 2, 2, 2}
              Array after second update becomes
              {2, 2, 2, 5, 5}
 * 
 * Method 2 [update : O(1), getElement() : O(n)]

We can avoid updating all elements and can update only 2 indexes of the array!

update(l, r, val) : Add ‘val’ to the lth element and subtract ‘val’ from the (r+1)th element, do this for all the update queries.
  arr[l]   = arr[l] + val
  arr[r+1] = arr[r+1] - val
getElement(i) : To get ith element in the array find the sum of all integers in the array from 0 to i.(Prefix Sum).
Let’s analyze the update query. Why to add val to lth index? Adding val to lth index means that all the elements after l are increased by val, since we will be computing the prefix sum for every element. Why to subtract val from (r+1)th index? A range update was required from [l,r] but what we have updated is [l, n-1] so we need to remove val from all the elements after r i.e., subtract val from (r+1)th index. Thus the val is added to range [l,r]. Below is implementation of above approach.
 * 
 * 
 * 
 * 
 * Method 3 (Using Binary Indexed Tree)
In method 2, we have seen that the problem can reduced to update and prefix sum queries. 
We have seen that BIT can be used to do update and prefix sum queries in O(Logn) time.
* Space complexity for fenwick tree is O(n)
 * Time complexity to create fenwick tree is O(nlogn)- update "n " values with each logn time
 * Time complexity to update value is O(logn)
 * Time complexity to get prefix sum is O(logn)
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/FenwickTree.java
 * https://www.youtube.com/watch?v=CWDQJGaN1gY
 * */
public class PointQueries_RangeUpdate {
	 /* Java code to demonstrate Range Update and 
	* Point Queries on a Binary Index Tree. 
	* This method only works when all array values are initially 0.*/
	static class GFG 
	{ 
	    // Max tree size 
	    final static int MAX = 1000; 
	  
	    static int BITree[] = new int[MAX]; 
	  
	    // Updates a node in Binary Index 
	    // Tree (BITree) at given index 
	    // in BITree. The given value 'val' 
	    // is added to BITree[i] and 
	    // all of its ancestors in tree. 
	    public static void updateBIT(int n,int index,int val) 
	    { 
	        // index in BITree[] is 1  
	        // more than the index in arr[] 
	        index = index + 1; 
	  
	        // Traverse all ancestors  
	        // and add 'val' 
	        while (index <= n) 
	        { 
	            // Add 'val' to current node of BITree 
	            BITree[index] += val; 
	  
	            // Update index to that of parent in update View 
	            index += index & (-index); 
	        } 
	    } 
	  
	    // Constructs Binary Indexed Tree  
	    // for given array of size n. 
	  
	    public static void constructBITree(int arr[], 
	                                       int n) 
	    { 
	        // Initialize BITree[] as 0 
	        for(int i = 1; i <= n; i++) 
	            BITree[i] = 0; 
	  
	        // Store the actual values in BITree[] using update() 
	        for(int i = 0; i < n; i++) 
	            updateBIT(n, i, arr[i]); 
	  
	        // Uncomment below lines to  
	        // see contents of BITree[] 
	        // for (int i=1; i<=n; i++) 
	        //     cout << BITree[i] << " "; 
	    } 
	  
	    
	    
	    
	    // SERVES THE PURPOSE OF getElement() 
	    // Returns sum of arr[0..index]. This  
	    // function assumes that the array is 
	    // preprocessed and partial sums of 
	    // array elements are stored in BITree[] 
	    public static int getSum(int index) 
	    { 
	        int sum = 0; //Initialize result 
	  
	        // index in BITree[] is 1 more than the index in arr[] 
	        index = index + 1; 
	  
	        // Traverse ancestors of BITree[index] 
	        while (index > 0) 
	        { 
	  
	            // Add current element of BITree to sum 
	            sum += BITree[index]; 
	  
	            // Move index to parent node in getSum View 
	            index -= index & (-index); 
	        } 
	  
	        // Return the sum 
	        return sum; 
	    } 
	  
	    // Updates such that getElement()  
	    // gets an increased value when  
	    // queried from l to r. 
	    public static void update(int l, int r,  
	                              int n, int val) 
	    { 
	        // Increase value starting at 'l' to max index by 'val' 
	        updateBIT(n, l, val); 
	  
	        // Decrease value starting at 'r+1' to max index by 'val' as we want to undo the increase from r+1 to max that we did in previous step
	        updateBIT(n, r + 1, -val); 
	    } 
	  
	  
	    // Driver Code 
	    public static void main(String args[]) 
	    { 
	        int arr[] = {0, 0, 0, 0, 0}; 
	        int n = arr.length; 
	  
	        constructBITree(arr,n); 
	  
	        // Add 2 to all the 
	        // element from [2,4] 
	        int l = 2, r = 4, val = 2; 
	        update(l, r, n, val); 
	  
	        int index = 4; 
	  
	        System.out.println("Element at index "+  
	                                index + " is "+  
	                                getSum(index)); 
	  
	        // Add 2 to all the  
	        // element from [0,3] 
	        l = 0; r = 3; val = 4; 
	        update(l, r, n, val); 
	  
	        // Find the element 
	        // at Index 3 
	        index = 3; 
	        System.out.println("Element at index "+  
	                                index + " is "+  
	                                getSum(index)); 
	    } 
	} 
}

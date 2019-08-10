package segmentTrees;

public class RangeMin {
/*
 * Segment tree stores intervals, and optimized for "which of these intervals contains a given point" queries.
 * (segment trees is used for queries like- max value in a range within an array, sum of elements in a range within an array)
Interval tree stores intervals as well, but optimized for "which of these intervals overlap with a given interval" queries. It can also be used for point queries - similar to segment tree.
Range tree stores points, and optimized for "which points fall within a given interval" queries.

Binary indexed tree stores items-count per index, and optimized for "how many items are there between index m and n" queries.
//Also called the Fenwick tree , its used to find out information about a range of values, say whats the state of values from [0,3], maybe sum of values from [0,3]

Performance / Space consumption for one dimension:

Segment tree - O(n logn) preprocessing time, O(k+logn) query time, O(n logn) space
Interval tree - O(n logn) preprocessing time, O(k+logn) query time, O(n) space
Range tree - O(n logn) preprocessing time, O(k+logn) query time, O(n) space
Binary Indexed tree - O(n logn) preprocessing time, O(logn) query time, O(n) space
(k is the number of reported results).
 * 
 * 
 * 
 * Build a segment tree:
 * [-1,3,4,0,2,1]
 * split array into 2
 * [-1,3,4]  and [0,2,1]
 * split again
 * [-1,3] and [4] ...[0,2] and [1]
 * so all these will be leaves of this tree and if we solving for finding minimim of a range, 
 * then min of (-1,3) will be at the same level as 4 in the segment tree
 * 				      -1[0,5]
 * 					/			\
 * 			   -1[0,2]   	  0[3,5]
 * 				/  \        /      \
 * 			-1[0,1] 4[2,2]  0[3,4]   1[5,5]
 * 			/    \         /      \      
 * 		  -1[0,0] 3[1,1]   0[3,3]  2[4,4]
 * 
 *inorder to serve the query, we need to follow 3 rules:
 *1.partial overlap->go search in both branches of the tree
 *2.total overlap->return the value at that node
 *3.no overlap, return a very big MAX value so that its not selected as we are trying to find min here
 *
 *To represent this tree we need size of array=(nearest_power of 2  greater than equal to n)*2-1 nodes, where n= number of elements in original array
 *left child index=2i+1
 *right child index=2i+2
 *parent index=(i-1)/2
 *so space complexity=O(n), search time=O(logN)
 * Ex:[-1,2,4,0]
 * size=2*4-1=7
 * segTree:[-1,-1,0,-1,2,4,0]
 * Time Complexity for tree construction is O(n). There are total 2n-1 nodes, 
 * and value of every node is calculated only once in tree construction.

Time complexity to query is O(Logn). To query a sum, we process at most 4 nodes at every level 
and number of levels is O(4Logn).
https://www.geeksforgeeks.org/segment-tree-set-1-range-minimum-query/
 * 
 * */
	int[] segTreeArr;
	int[] input;
	 int nextPowerOf2(int n) 
	    { 
	        int p = 1; 
	        if (n > 0 && (n & (n - 1)) == 0) 
	            return n; 
	  
	        while (p < n)  
	            p <<= 1; 
	      
	        return p; 
	    } 
	RangeMin(int[] nums){
		input=nums;
        //Height of segment tree 
        int max_size = nextPowerOf2(nums.length); 
  
        //Maximum size of segment tree 
       
        //if input len is pow of 2 then size of 
        //segment tree is 2*len - 1, otherwise
        //size of segment tree is next (pow of 2 for len)*2 - 1.
       
        segTreeArr = new int[max_size*2 -1];
        
        
	}
	void constructSegTree(int[] input,int[] segTreeArr,int low,int high,int segTreeIndex) {
		if(low==high) {
			segTreeArr[segTreeIndex]=input[low];
			return;
		}
		int mid=(low+high)/2;
		//construct left child
		constructSegTree(input,segTreeArr,low, mid, 2*segTreeIndex+1);
		//constrct rught child
		constructSegTree(input,segTreeArr,mid+1, high, 2*segTreeIndex+2);
		//update parent node value after coming back from recursion as both childs have values already updated now and parent is min of both children
		segTreeArr[segTreeIndex]=Math.min(segTreeArr[2*segTreeIndex+1], segTreeArr[2*segTreeIndex+2]);
	}
	
	int rangeMinQuery(int qlow,int qhigh,int low,int high,int pos) {
		
		//check if the range given contains(is superset of) the range=>(low,high) passed in the function
		
		if(qlow<=low && qhigh>=high) {
			//total overlap as (qlow ,qhigh) actually contains (low,high) within itself
			//so we can just return that number
			return segTreeArr[pos];
		}
		//no overlap
		if(qlow>high || qhigh<low) {
			return Integer.MAX_VALUE;
		}
		//if there is partial overlap we search in both direction
		
		//total overlap as (qlow ,qhigh) actually contains (low,high) within itself
		//so we can just return that number
		int mid=(low+high)/2;
		int x=rangeMinQuery( qlow, qhigh, low, mid, 2*pos+1);
		int y=rangeMinQuery( qlow, qhigh, mid+1, high, 2*pos+2);
		return Math.min(x, y);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

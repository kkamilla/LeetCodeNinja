package segmentTrees;

public class RangeSum_Mutable_307 {
	class NumArray {
	    int[] input;
	    int[] segmentTree;
	    public NumArray(int[] nums) {
	        //if nums.length==0 then don't do anything
	        if (nums.length > 0) {
	            input=nums;
	            int size=nextPowerOf2(nums.length);
	            segmentTree=new int[2*size-1];

	            constructSegTree_RangeSum(0, nums.length-1, 0);
	        }
	    }
	     int nextPowerOf2(int n) 
		    { 
		        int p = 1; 
		        if (n > 0 && (n & (n - 1)) == 0) 
		            return n; 
		  
		        while (p < n)  
		            p <<= 1; 
		      
		        return p; 
		    } 
	    void constructSegTree_RangeSum(int low,int high,int segTreeIndex) {
				if(low==high) {
					segmentTree[segTreeIndex]=input[low];
					return;
				}
				int mid=(low+high)/2;
				//construct left child
				constructSegTree_RangeSum(low, mid, 2*segTreeIndex+1);
				//constrct rught child
				constructSegTree_RangeSum(mid+1, high, 2*segTreeIndex+2);
				//update parent node value after coming back from recursion as both childs have values already updated now and parent is min of both children
				segmentTree[segTreeIndex]=segmentTree[2*segTreeIndex+1]+ segmentTree[2*segTreeIndex+2];
			}
	    public void update(int i, int val) {
	        int diff=val-input[i];
	        //update the value
	        
	        update_segTree(0, input.length-1, diff,i,0);
	        input[i]=val;
	        
	    }
	    void update_segTree(int low,int high,int diff,int changedIndex,int segTreeIndex) {
	         //if index to be updated is less than low or higher than high just return.
	        if(changedIndex < low || changedIndex > high){
	            return;
	        }
				if(low==high) {
					segmentTree[segTreeIndex]+=diff;
					return;
				}
				int mid=(low+high)/2;
				//construct left child
				update_segTree(low, mid, diff,changedIndex,2*segTreeIndex+1);
				//constrct rught child
				update_segTree(mid+1,high, diff,changedIndex,2*segTreeIndex+2);
				//update parent node value after coming back from recursion as both childs have values already updated now and parent is min of both children
				segmentTree[segTreeIndex]=segmentTree[2*segTreeIndex+1]+ segmentTree[2*segTreeIndex+2];
			}
	    
	    int rangeSumQuery(int qlow,int qhigh,int low,int high,int pos) {
				
		 		//check if the range given contains(is superset of) the range=>(low,high) passed in the function
				
		 		if(qlow<=low && qhigh>=high) {
		 			//total overlap as (qlow ,qhigh) actually contains (low,high) within itself
		 			//so we can just return that number
		 			return segmentTree[pos];
		 		}
		 		//no overlap
		 		if(qlow>high || qhigh<low) {
		 			return 0;
		 		}
		 		//if there is partial overlap we search in both direction
				
		 		//total overlap as (qlow ,qhigh) actually contains (low,high) within itself
		 		//so we can just return that number
		 		int mid=(low+high)/2;
		 		int x=rangeSumQuery( qlow, qhigh, low, mid, 2*pos+1);
		 		int y=rangeSumQuery( qlow, qhigh, mid+1, high, 2*pos+2);
		 		return x+ y;
		 	}
	    public int sumRange(int i, int j) {
	       return rangeSumQuery( i, j, 0, input.length-1, 0);
	    }
	    
	    
	}

	/**
	 * Your NumArray object will be instantiated and called as such:
	 * NumArray obj = new NumArray(nums);
	 * obj.update(i,val);
	 * int param_2 = obj.sumRange(i,j);
	 */
}

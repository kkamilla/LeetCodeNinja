package topK_Elements;

import java.util.PriorityQueue;

public class KthLargestStream_703 {
	class KthLargest {
		PriorityQueue<Integer> minHeap=new PriorityQueue<>();
		    int maxSize=0;
		    public KthLargest(int k, int[] nums) {
		        //put k max elements in the minheap from the int array
		        maxSize=k;
		        for(int i:nums){
		            if(minHeap.size()<k){
		                minHeap.offer(i);
		            }
		            else if(minHeap.size()==k && minHeap.peek()<i){
		                minHeap.poll();
		                 minHeap.offer(i);
		            }
		        }
		        
		    }
		    
		    public int add(int val) {
		        if(minHeap.size()<maxSize){
		                minHeap.offer(val);
		            }
		            else if(minHeap.size()==maxSize && minHeap.peek()<val){
		                minHeap.poll();
		                 minHeap.offer(val);
		            }
		        return minHeap.peek();
		    }
		}

		/**
		 * Your KthLargest object will be instantiated and called as such:
		 * KthLargest obj = new KthLargest(k, nums);
		 * int param_1 = obj.add(val);
		 */
}

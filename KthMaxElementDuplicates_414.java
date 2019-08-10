package topK_Elements;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KthMaxElementDuplicates_414 {
	class Solution {
	    public int thirdMax(int[] nums) {
	        int kthSmallest=nums.length-3;
	        //here there are duplicate elemnets in the array(so we cannot use quick select) and , if 3rd largest is not found then we nee to return the 2nd largest
	        //store elements in minheap of size k and try to remove min of all elements in heap if we see an incoming number >min on heap
	        //but beacuse there are repeating elements, we need to skip duplictaes and not add it to minheap if its already processed before and has gone into minheap sometime
	        
	        Set<Integer> checkDuplicates=new HashSet<>();
	        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
	        for(int i:nums){
	            if(checkDuplicates.contains(i)){
	                continue;
	            }
	            else if(minHeap.size()<3){
	                checkDuplicates.add(i);
	                minHeap.offer(i);  
	            }
	            else if(minHeap.size()==3 && i>minHeap.peek()){
	                minHeap.poll();
	                checkDuplicates.add(i);
	                minHeap.offer(i);
	            }
	        }
	         int r=-1;
	        //if 3rd largest is not found then we nee to return the 2nd largest
	        if(minHeap.size()<3){
	           while(minHeap.size()>0){
	               //empty the heap to get the 2nd maximumvalue
	             r=minHeap.poll();
	            } 
	            return r;
	        }
	        
	        return minHeap.poll();
	    }
	    
	    
	}
}

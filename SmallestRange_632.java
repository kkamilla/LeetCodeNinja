package k_way_merge_heap;

import java.util.*;

public class SmallestRange_632 {
	class Solution {
	    class Obj{
		        int val;
		        int row;
		        int col;
		        Obj(int v,int r,int c){
		            val=v;
		            row=r;
		            col=c;
		        }
		    }
	    public int[] smallestRange(List<List<Integer>> nums) {
	        int numOfArrays=nums.size();
	        //we need to do a k way merge and find out the difference between the max and min values in heap to get the range of elements covering all lists as we know the heap always conatins atleast one element from each list
	        
	        //create a minheap of size numOfArrays
	         PriorityQueue<Obj> minHeap=new PriorityQueue<>(new Comparator<Obj>(){
			            public int compare(Obj o1,Obj o2){
			                //first sort by freq
			                if(o1.val>o2.val){
			                    return 1;
			                }
			                
			                else{
			                    //o1.freq<o2.freq
			                    return -1;
			                }
			            }
			        });
	         int max_value_inheap = Integer.MIN_VALUE;
	        //add the first elements of each list into the minheap
		        for(int row=0;row<nums.size();row++){
		            minHeap.offer(new Obj(nums.get(row).get(0),row,0));
	                if(max_value_inheap<nums.get(row).get(0)){
	                   max_value_inheap= nums.get(row).get(0);
	                }
		        }
	        int minDiff=Integer.MAX_VALUE;
	        int[] result=new int[2];
	        int currDiff=0;
	        
	        //while minheap size==nums of lists, keep finding the next difference between the highest and lowest element on heap to get the min range covering all lists
	        
	        while(minHeap.size()==numOfArrays){
	            Obj smallest=minHeap.poll();
	            //find range differnce
	            currDiff=max_value_inheap-smallest.val;
	            if(currDiff<minDiff){
	                minDiff=currDiff;
	                result[0]=smallest.val;
	                result[1]=max_value_inheap;
	            }
	            
	            //now add next element from the list from where we removed the min element
	            if(smallest.col+1<nums.get(smallest.row).size()){
	                //if there are still elements in the current list where smallest top came from
	               minHeap.offer(new Obj(nums.get(smallest.row).get(smallest.col+1),smallest.row,smallest.col+1));
	                if(max_value_inheap<nums.get(smallest.row).get(smallest.col+1)){
	                   max_value_inheap=nums.get(smallest.row).get(smallest.col+1);
	                }
	            }
	             
	            
	        }
	       return result; 
	    }
	}
}

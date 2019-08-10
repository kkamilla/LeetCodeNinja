package k_way_merge_heap;

import java.util.*;

public class MergeKSortedLinkedLists_23 {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public class ListNode {
		     int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	class Solution {
	    class Obj{
			        ListNode node;
			        int val;
			        
			        Obj(ListNode v,int r){
			            node=v;
			            val=r;
			            
			        }
			    }
	    public ListNode mergeKLists(ListNode[] lists) {
	        ListNode head=new ListNode(0);
	        if(lists.length==0){
	            return head.next;
	        }
	        int numOfLinkedLists=lists.length;
		       
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

	        //add the first elements of each list into the minheap
	        for(int row=0;row<lists.length;row++){
	            //if its not empty as list might be like this -> [[]]
	            if(lists[row]!=null){
	                 minHeap.offer(new Obj(lists[row],lists[row].val));
	            }
	        }
	        
	        
	        ListNode currNode=new ListNode(0);
	        head=currNode;
	        while(minHeap.size()>0){
		            Obj smallest=minHeap.poll();
		            //add it to new linkedlist
		            currNode.next=new ListNode(smallest.val);
	                currNode=currNode.next;
		            //now add next element from the list from where we removed the min element
		            if(smallest.node.next!=null){
		                //if there are still elements in the current list where smallest top came from
		               minHeap.offer(new Obj(smallest.node.next,smallest.node.next.val));
		                
		            }
		             
		            
		        }
	        // as head was created as ListNode(0)
	        return head.next;
	    }
	}
}

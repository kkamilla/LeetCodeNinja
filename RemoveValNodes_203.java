package linkedListReverse;

public class RemoveValNodes_203 {
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
	    public ListNode removeElements(ListNode head, int val) {
	        if(head==null ){
	            return head;
	        }
	        //key is to think that that val can also be the value of the first node and the last node in the linked list
	        //so we need to handle the case where head node value is also val
	        //thats why we assign a new Node to point to head ,i.e newnode.next=head, so that we always check if newnode.next.val==matched_val
	        ListNode new_node=new ListNode(0);
	        new_node.next=head;
	        ListNode node_toloop=new_node;
	        while(node_toloop.next!=null){
	        	//node_to_loop is always one node behind the node being compared,
	        	//so we are able to delete the last node as well without any issues of null pointer
	            if(node_toloop.next.val==val){
	                ListNode toremove=node_toloop.next;
	                //we have updated the next of node_toloop, so next loop it will check next next val
	                node_toloop.next=toremove.next;
	                
	            }
	            //go to the next of node_loop, either after updating /if the val is not same, then go to the next node
	            else{
	               node_toloop=node_toloop.next; 
	            }
	            
	            
	        }
	        
	        return new_node.next;
	    }
	}
}

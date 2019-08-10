package linkedListReverse;

public class ReverseLinkedList_206 {
	public class ListNode {
		    int val;
		     ListNode next;
		     ListNode(int x) { val = x; }
		 }
	public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        ListNode temp=null;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            
        }
        
        //as curr==null now, return prev as it has the last node which was not null
        return prev;
    }
}

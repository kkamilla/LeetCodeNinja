package linkedListReverse;

public class ReverseSublist_92 {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public ListNode reverseBetween(ListNode head, int m, int n) {
        int countS=1;
        ListNode curr=head;
        ListNode prev=null;
        while(countS<m){
            prev=curr;
            curr=curr.next;
            countS++;
        }
        
        //this is one prev to mth node , so once we get the reveresed list,conenct to m_start_prev
         ListNode mStart_prev=prev;
        //this will be end of the reversed list and we need to connect nodex from n+1 to end to it 
          ListNode nStop=curr;
        countS=0;
         ListNode temp=null;
        //reverse the nodes
        while(countS<=n-m){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            countS++;
        }
        
        //connect mStart_prev to new head after reverse
       
       if(mStart_prev!=null){
           mStart_prev.next=prev;//prev points to the nth node
       }
        else{
            //rverse is from 1st node itself
            //there is nothing befoer m_start, so head should point to this new nth node
            head=prev;
        }
        
        nStop.next=curr;//curr points to n+1 node
        
        return head;
    }
}

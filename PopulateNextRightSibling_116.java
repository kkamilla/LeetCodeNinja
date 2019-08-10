package treeBFS;

public class PopulateNextRightSibling_116 {
	/*
	// Definition for a Node.
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}

	    public Node(int _val,Node _left,Node _right,Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};
	*/
	class Solution {
	    public Node connect(Node root) {
	       Queue<Node> q=new LinkedList<>();
		        
		        if(root==null){
		            return root;
		        }
		        q.add(root);
		        
		        while(!q.isEmpty()){
		            List<Node> frontList=new ArrayList<>();
		            while(!q.isEmpty()){
		                  frontList.add(q.poll());
		            }
		          Node curr=null;
	                int j=0;
		          for(int i=0;i<frontList.size()-1;i++){
	                   j=i+1;
	                  curr=frontList.get(i);
	                  curr.next=frontList.get(j);
		              if(curr.left!=null){
		                   q.add(curr.left);
		                }
		                if(curr.right!=null){
		                   q.add(curr.right);
		                }
		            }
	                
	                //adding the last node --> jth node's child in queue as its still not processed
	                if(frontList.get(j).left!=null){
		                   q.add(frontList.get(j).left);
		                }
		                if(frontList.get(j).right!=null){
		                   q.add(frontList.get(j).right);
		                }
		        }
		        
		        return root; 
	    }
	}
}

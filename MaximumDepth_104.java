package treeBFS;

public class MaximumDepth_104 {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
	    public int maxDepth(TreeNode root) {
	        Queue<TreeNode> q=new LinkedList<TreeNode>();
		        
		        if(root==null){
		            return 0;
		        }
		        q.add(root);
		        int count=0;
		        while(!q.isEmpty()){
		            List<TreeNode> frontList=new ArrayList<>();
		            while(!q.isEmpty()){
		                  frontList.add(q.poll());
		            }
		           
		            count++;
		          for(TreeNode front:frontList){
	                  //as soon as we get a leaf node, we return
	                  // if(front.left==null && front.right==null){
	                  //     return count;
	                  // }
		              if(front.left!=null){
		                   q.add(front.left);
		                }
		                if(front.right!=null){
		                   q.add(front.right);
		                }
		                
		            }
		            
		           
		        }
		        
		        return count;
	    }
	}
}

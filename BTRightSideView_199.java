package treeBFS;

public class BTRightSideView_199 {
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
	    public List<Integer> rightSideView(TreeNode root) {
	        Queue<TreeNode> q=new LinkedList<TreeNode>();
		        List<Integer> res=new ArrayList<>();
		        if(root==null){
		            return res;
		        }
		        q.add(root);
		        
		        while(!q.isEmpty()){
		            List<TreeNode> frontList=new ArrayList<>();
		            while(!q.isEmpty()){
		                  frontList.add(q.poll());
		            }  
		          for(TreeNode front:frontList){
		              if(front.left!=null){
		                   q.add(front.left);
		                }
		                if(front.right!=null){
		                   q.add(front.right);
		                }
		               
		            }
		            //adding last node in each level
		            int val=frontList.get(frontList.size()-1).val;
		                 res.add(val);
		            
		           
		        }
		        
		        return res;
	    }
	}
}

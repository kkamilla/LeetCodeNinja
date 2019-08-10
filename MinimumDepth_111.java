package treeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumDepth_111 {
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
	    public int minDepth(TreeNode root) {
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
	                  if(front.left==null && front.right==null){
	                      return count;
	                  }
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

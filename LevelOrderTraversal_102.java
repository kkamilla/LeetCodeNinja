package treeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal_102 {
	/**
	 * Definition for a binary tree node.
	 * 
	 */
	public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		 }
	class Solution {
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        Queue<TreeNode> q=new LinkedList<TreeNode>();
	        List<List<Integer>> res=new ArrayList<>();
	        if(root==null){
	            return res;
	        }
	        q.add(root);
	        
	        while(!q.isEmpty()){
	            List<TreeNode> frontList=new ArrayList<>();
	            while(!q.isEmpty()){
	                  frontList.add(q.poll());
	            }
	           List<Integer> sub_res=new ArrayList<>();
	            
	          for(TreeNode front:frontList){
	              if(front.left!=null){
	                   q.add(front.left);
	                }
	                if(front.right!=null){
	                   q.add(front.right);
	                }
	                sub_res.add(front.val); 
	            }
	            
	            if(sub_res.size()>0){
	                 res.add(sub_res);
	            }
	           
	        }
	        
	        return res;
	    }
	}
}

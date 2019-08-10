package treeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BoundaryBT_545 {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	class Solution {
	    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
	        
		        List<Integer> res=new ArrayList<>();
	         List<Integer> sub_left=new ArrayList<>();
	         List<Integer> sub_right=new ArrayList<>();
	         List<Integer> sub_leaf=new ArrayList<>();
		        if(root==null){
		            return res;
		        }
		    //add left
	        if(root.left!=null){
	            boundary_left( root.left,sub_left) ;
	        boundary_leaf( root.left,sub_leaf) ;
	        }
	        if(root.right!=null){
	             boundary_leaf( root.right,sub_leaf) ;
	        boundary_right( root.right,sub_right) ;
	        }
	       
	        
        	res.add(root.val);
	        res.addAll(sub_left);
            res.addAll(sub_leaf);
            res.addAll(sub_right);
            
	        return res;
	    }
	    
	   void boundary_left( TreeNode root,List<Integer> leftlist){
	        
	       if(root.left==null && root.right==null){
	            return;
	        }
	       if(root.left!=null){
	            leftlist.add(root.val);
	           boundary_left(  root.left, leftlist);
	           
	       }
	       //if there is no left then go right child and thats the boundary
	       else if(root.right!=null){
	            leftlist.add(root.val);
	           boundary_left(  root.right, leftlist);
	           
	       }
	       
	       
	    }
	    void boundary_right( TreeNode root,List<Integer> rlist){
	        if(root.left==null && root.right==null){
	            
	            return;
	        }
	       if(root.right!=null){
	           boundary_right(  root.right, rlist);
	            rlist.add(root.val);
	       }
	        //if there is no right child then left child will be the boundary here
	        else if(root.left!=null){
	            boundary_right(  root.left, rlist);
	            rlist.add(root.val);
	           
	       }
	       
	    }
	    
	    void boundary_leaf( TreeNode root,List<Integer> llist){
	        if(root.left==null && root.right==null){
	            llist.add(root.val);
	            return;
	        }
	       if(root.left!=null){
	           
	           boundary_leaf(  root.left, llist);
	       }
	       if(root.right!=null){
	           
	           boundary_leaf(  root.right, llist);
	       }
	       
	       
	    }
	}
}

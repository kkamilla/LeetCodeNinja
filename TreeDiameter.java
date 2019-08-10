package treeDFS;

public class TreeDiameter {
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
	    class Result{
	        int diameter;
//	        int h_left;
//	        int h_right;
	        int height;
	        Result(int d,int h){
	            diameter=d;
	            //h_left=l;
	            //h_right=r;
	            height=h;
	        }
	    }
	    int maxDiameter=0;
	    public int diameterOfBinaryTree(TreeNode root) {
	        if(root==null){
	            return 0;
	        }
	        diameterOfBinaryTree_h( root);
	        return maxDiameter;
	    }
	    public Result diameterOfBinaryTree_h(TreeNode root) {
	        System.out.println(root.val);
	        //if it is a leaf node
	        
	        if(root.left==null && root.right==null){
	            Result r=new Result(0,0);
	            return r;
	        }
	        
	        //length is number of edges between the nodes as there are 2 extra edges connecting root to left and root to right tree
	        Result leftTree=new Result(-1,-1);
	        Result rightTree=new Result(-1,-1);
	        if(root.left!=null){
	             leftTree=diameterOfBinaryTree_h( root.left);
	        }
	        if(root.right!=null){
	             rightTree=diameterOfBinaryTree_h( root.right);
	        }
	        int height_root=0;
	        int dia_root=0;
	         if(leftTree.height!=-1 && rightTree.height!=-1){
	             height_root=Math.max(leftTree.height,rightTree.height)+1;
	             //length is number of edges between the nodes
	             dia_root=leftTree.height+1+rightTree.height+1; 
	         }
	        else if(leftTree.height!=-1 && rightTree.height==-1){
	            height_root=leftTree.height+1;
	             dia_root=leftTree.height+1; 
	        }
	        else if(leftTree.height==-1 && rightTree.height!=-1){
	            height_root=rightTree.height+1;
	             dia_root=rightTree.height+1; 
	        }
	        
	        if(dia_root>maxDiameter){
	           maxDiameter= dia_root;
	        }
	        Result rootTree=new Result(dia_root,height_root);
	        return rootTree;
	    }
	}
}

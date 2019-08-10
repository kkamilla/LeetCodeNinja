package treeDFS;

public class SumNumbersRootToLeaf_129 {
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
	    public int sumNumbers(TreeNode root) {
	        if(root==null){
	            return 0;
	        }
	        return sumNumbers_rec( root,"",0);
	    }
	    public int sumNumbers_rec(TreeNode root,String num,int sum) {
	        if(root.left==null && root.right==null){
	            return sum+=Integer.parseInt(num+root.val);
	        }
	        int x=0,y=0;
	        if(root.left!=null){
	             x=sumNumbers_rec( root.left,num+root.val,sum);
	        }
	        if(root.right!=null){
	             y=sumNumbers_rec( root.right,num+root.val,sum);
	        }
	        
	        
	        return x+y;
	        
	    }
	}
}

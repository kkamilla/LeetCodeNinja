package treeDFS;

public class LongestConsecSequence_298 {
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
	    public int longestConsecutive(TreeNode root) {
	        if(root==null){
	            return 0;
	        }
	       return longestConsecutive_rec( root, null, 0);
	    }
	    
	    public int longestConsecutive_rec(TreeNode root,TreeNode parent,int curr_len) {
	        
	        
	        if(root==null ){
	            return curr_len;
	        }
	    
	        int x=0,y=0;
	        // root.val+1=root.left.val than continue the exisitngpath as it is longer than starting a new path
	        
	           if(parent!=null && root.val==parent.val+1){
	               curr_len=curr_len+1;
	            }
	            else{
	                       //else start a new path from root.left
	                curr_len=1;
	            }
	         x=   longestConsecutive_rec( root.left, root,curr_len);
	        y=   longestConsecutive_rec( root.right,root,curr_len); 
	        
	        int max=Math.max(x,y);
	        //value of curr_len might be longer than what x,y return as longest path might end at the parent itself
	        max=Math.max(curr_len,max);
	        
	        return max;
	    }
	}
}

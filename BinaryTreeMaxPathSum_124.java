package treeDFS;

public class BinaryTreeMaxPathSum_124 {
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
		//global maxSum to store the max until now
	    int maxSum=Integer.MIN_VALUE;
	    public int maxPathSum(TreeNode root) {
	         maxPathSum_rec( root, 0);
	        return maxSum;
	    }
	    class Obj{
	        int sum;
	        boolean thru;
	        Obj(int s,boolean t){
	            sum=s;
	            thru=t;
	        }
	    }
	    public int maxPathSum_rec(TreeNode root,int currSum) {
	        //if leaf thats the max sum possibel at that node
	        if(root==null){
	            return 0;
	        }
	        if(root.left==null && root.right==null){
	            maxSum=Math.max(root.val,maxSum);
	            return root.val;
	        }
	        
	        //if root is +ve then add it to maxleft thru left node+currPath+maxlength thru right node
	        int x=maxPathSum_rec( root.left, currSum);
	        int y=maxPathSum_rec( root.right, currSum);
	       
	           
	            //if(x.thru==true && y.thru==true){
	                //add to current path, but maybe x is -ve and it will reduce sum
	                
	                maxSum=Math.max(x+root.val+y,maxSum);
	                maxSum=Math.max(Math.max(x,y)+root.val,maxSum);
	                //but the path that can continue upto the parent is max of right path and min path as the parebt of parent can choose only one of these 2 paths and not both to conitune
	                maxSum=Math.max(root.val,maxSum);
	                System.out.println("1.."+maxSum);
	        //u can take either the root.val directly else
	                return Math.max(root.val,Math.max(x,y)+root.val);
	            //}
	            // else if(y.thru==true){
	            //     System.out.println("y.."+root.val+y.sum);
	            //     maxSum=Math.max(root.val+y.sum,maxSum);
	            //     maxSum=Math.max(root.val,maxSum);
	            //     return new Obj(Math.max(root.val,root.val+y.sum),true);
	            // }
	            // else if( x.thru==true ){
	            //     System.out.println("x.."+root.val+x.sum);
	            //     maxSum=Math.max(root.val+x.sum,maxSum);
	            //     maxSum=Math.max(root.val,maxSum);
	            //     return new Obj(Math.max(root.val,root.val+x.sum),true);
	            // }
	            // else{
	            //     //cannot combine with children
	            //      //else take max of left return , and right return
	            //     maxSum=Math.max(Math.max(x.sum,y.sum),maxSum);
	            //     maxSum=Math.max(root.val,maxSum);
	            //     System.out.println("4.."+maxSum);
	            //     return new Obj(Math.max(root.val,Math.max(x.sum,y.sum)),false);
	            // }
	     
	    }
	}
}

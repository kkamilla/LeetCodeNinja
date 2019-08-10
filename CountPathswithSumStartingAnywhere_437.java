package treeDFS;
  class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
public class CountPathswithSumStartingAnywhere_437 {
	/**
	 You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
	 
	*/

	class Solution {
	    int target=0;
	    
	    
	    public int pathSum(TreeNode root, int sum) {
	        if(root==null){
	            return 0;
	        } 
	        target=sum;
	        //below is not needed as in pathWithParent_rec() we add one for root.val==sum in base case
	        // int count=0;
	         // if(root.val==sum ){
	         //        return 1;
	         //    }
	        
	        //we want to start only one path to child nodes from parent itself and not from parent of parent, 
	        //so in pathWithParent_rec() we call recursive function inclduing parent in the path, 
	        //and to exclude and start a new path from the child node we call pathSum() so 
	        //that we do not have duplicate paths starting for a child node from parent's parent and
	        //along the path where we did not include any of the parent nodes
	        return pathSum( root.left,  sum) +pathSum( root.right,  sum) +pathWithParent_rec( root,  sum); 
	    }
	    
	     public int pathWithParent_rec(TreeNode root, int sum) {
	         
	          int totalCount=0;
	         if(root==null){
	              return 0;
	          } 
	      
	        if(root.val==sum ){
	                totalCount+= 1;
	            }
	         
	         //value of sum changes but value of target is fixed
	      
	        totalCount+=pathWithParent_rec( root.left,  sum-root.val);
	        
	         totalCount+=pathWithParent_rec( root.right,  sum-root.val); 
	          
	         return totalCount;
	    }
}
	}
/* for each parent node in the tree, we have 2 choices:
	1. include it in the path to reach sum.
	2. not include it in the path to reach sum. 

	for each child node in the tree, we have 2 choices:
	1. take what your parent left you.
	2. start from yourself to form the path.

	one little thing to be careful:
	every node in the tree can only try to be the start point once.

	for example, When we try to start with node 1, node 3, as a child, could choose to start by itself.
	             Later when we try to start with 2, node 3, still as a child, 
	             could choose to start by itself again, but we don't want to add the count to result again.
	     1
	      \
	       2
	        \
	         3
	         

	public class Solution {
	    int target;
	    Set<TreeNode> visited;
	    public int pathSum(TreeNode root, int sum) {
	        target = sum;
	        visited = new HashSet<TreeNode>();  // to store the nodes that have already tried to start path by themselves.
	        return pathSumHelper(root, sum, false);
	    }
	    
	    public int pathSumHelper(TreeNode root, int sum, boolean hasParent) {
	        if(root == null) return 0;
	        //the hasParent flag is used to handle the case when parent path sum is 0.
	        //in this case we still want to explore the current node.
	        if(sum == target && visited.contains(root) && !hasParent) return 0;
	        if(sum == target && !hasParent) visited.add(root);
	        int count = (root.val == sum)?1:0;
	        count += pathSumHelper(root.left, sum - root.val, true);
	        count += pathSumHelper(root.right, sum - root.val, true);
	        count += pathSumHelper(root.left, target , false);
	        count += pathSumHelper(root.right, target, false);
	        return count;
	    }
	}````
	 */ 

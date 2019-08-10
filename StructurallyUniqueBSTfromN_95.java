package recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

public class StructurallyUniqueBSTfromN_95 {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	class Solution {
		public List<TreeNode> generateTrees(int n) {
			List<TreeNode> all_trees = new ArrayList<TreeNode>();
			if(n==0){
				return all_trees;
			}
			return generateTrees_rec( 1,n);
		}

		public List<TreeNode> generateTrees_rec(int min,int max) {
			//when to add to result list?
			TreeNode root=null;
			//when n==0 then add null nodes
			List<TreeNode> all_trees = new ArrayList<TreeNode>();
			//when min>max then we stop as we have to add null nodes now as we have no valid interger number to add to tree forming
			if(min>max){
				all_trees.add(null);
				return all_trees;
			}
			// if(n==1){
			//     all_trees.add(new TreeNode(1));
			//     return all_trees;
			// }
			else{
				//here are need the actual node value to put it in the tree so we need to divide into 3 parts: (min to i-1) and i and (i+1 to max)
				for(int i=min;i<=max;i++){

					//recurse on left to get the root node return value from left
					List<TreeNode> rootleft_list=generateTrees_rec( min,i-1);
					List<TreeNode> rootright_list=generateTrees_rec(i+1,max);
					//loop thru return list of trees to add it to root
					// connect left and right trees to the root i
					for (TreeNode l : rootleft_list) {
						for (TreeNode r : rootright_list) {
							//fix the root i
							root=new  TreeNode(i);
							root.left=l;
							root.right=r;
							//add to list
							all_trees.add(root);

						}
					}

				}


			}
			return all_trees;  

		}
	}
}

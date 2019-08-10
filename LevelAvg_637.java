package treeBFS;

public class LevelAvg_637 {
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
	    public List<Double> averageOfLevels(TreeNode root) {
	       Queue<TreeNode> q=new LinkedList<TreeNode>();
		        List<Double> res=new ArrayList<>();
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
		            double sum = 0, count = 0;
		            for(int i:sub_res){
	                     sum+=i;
	                    count++;
		                
		            }
	                Double val=sum/count;
	                 res.add(val);
		           
		        }
		        
		        return res; 
	    }
	}
}

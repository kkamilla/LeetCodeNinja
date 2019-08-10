package treeBFS;

import java.util.*;
import java.util.Stack;

public class ZigZag_103 {
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
	    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        List<List<Integer>> res=new ArrayList<>();
	        if(root==null) {
				return res;
			}
			
			// declare two stacks 
		    Stack<TreeNode> currentLevel = new Stack<>(); 
		    Stack<TreeNode> nextLevel = new Stack<>(); 
		    boolean addleftToRight=true;
		    currentLevel.push(root);
		    List<Integer> sub_res=new ArrayList<>();
		    while(!currentLevel.isEmpty()) {
		    	TreeNode top=currentLevel.pop();
	            
	            sub_res.add(top.val);
	                
		    	System.out.println(top.val);
		    	if(addleftToRight) {
		    		//add left child first so that we print right child first
		    		if(top.left!=null) {
		    			nextLevel.push(top.left);
		    		}
		    		if(top.right!=null) {
		    			nextLevel.push(top.right);
		    		}
		    	}
		    	else {
		    		//add right first
		    		if(top.right!=null) {
		    			nextLevel.push(top.right);
		    		}
		    		if(top.left!=null) {
		    			nextLevel.push(top.left);
		    		}
		    	}
		    	
		    	//if currentlevel is empty then we reset the flag
		    	if(currentLevel.isEmpty()) {
		    		addleftToRight=!addleftToRight;
		    		currentLevel=nextLevel;
		    		nextLevel=new Stack<>();
	                res.add(sub_res);
	                sub_res=new ArrayList<>();
		    		//Stack<Node> temp = currentLevel; 
		            //currentLevel = nextLevel; 
		            //nextLevel = temp;
		    	}
		    	
		    	
		    }
	        return res;
	    }
	    public List<List<Integer>> zigzagLevelOrder_q(TreeNode root) {
	        Queue<TreeNode> q=new LinkedList<TreeNode>();
		        List<List<Integer>> res=new ArrayList<>();
		        if(root==null){
		            return res;
		        }
		        q.add(root);
		        int count=0;
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
	                  if(count%2==1){
	                      sub_res.add(0,front.val);  
	                  }
		               else{
	                        sub_res.add(front.val); 
	                   }
		            }
		            
		            if(sub_res.size()>0){
		                 res.add(sub_res);
		            }
	                count++;
		           
		        }
		        
		        return res;
	    }
	}
	
	
}

package treeDFS;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        return hasPathSum_rec( root,  sum); 
    }
     public boolean hasPathSum_rec(TreeNode root, int sum) {
        if(root.left==null && root.right==null ){
            if(root.val==sum){
                return true;
            }
        }
         boolean x=false,y=false;
         if(root.left!=null){
             x=hasPathSum_rec( root.left,  sum-root.val); 
         }
         if(root.right!=null){
            y=hasPathSum_rec( root.right,  sum-root.val);  
         }
         return x||y;
    }
}

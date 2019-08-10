package recursion_backtracking;

public class CountUniqueBST_96 {
	class Solution {
	    public int numTrees(int n) {
	       return numTrees_rec(n);
	    }
	    public int numTrees_rec(int n) {
	        if(n==0 || n==1){
	            return 1;
	        }
	        else{
	            int count=0;
	            for(int i=1;i<=n;i++){
	                count+=numTrees_rec(i-1)*numTrees_rec(n-i);
	            }
	            return count;
	        }
	    }
	}
}

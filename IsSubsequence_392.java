package dp_longestCommonSubstring;

public class IsSubsequence_392 {
	class Solution {
	    public boolean isSubsequence(String s, String t) {
	        int[][] memo=new int[s.length()][t.length()];
	        for(int i=0;i<memo.length;i++){
	            for(int j=0;j<memo[i].length;j++){
	                memo[i][j]=-1;
	            }
	        }
	        return isSubsequence( s,  t, 0, 0,memo);
	    }
	    
	    public boolean isSubsequence(String s, String t,int indexS,int indexT,int[][] memo) {
	        
	        if(indexS==s.length()){
	            return true;
	        }
	        if(indexT==t.length()){
	            return false;
	        }
	        if(memo[indexS][indexT]!=-1){
	            
	            return memo[indexS][indexT]==0?false:true;
	        }
	        //don't take it
	        boolean x=isSubsequence( s,  t, indexS, indexT+1,memo);
	        //take it
	        if(s.charAt(indexS)==t.charAt(indexT)){
	           x=x|| isSubsequence( s,  t, indexS+1, indexT+1,memo);
	        }
	        
	        //update memo table
	        if(x==true){
	            memo[indexS][indexT]=1;
	        }
	        else{
	            memo[indexS][indexT]=0;
	        }
	        
	        return x;
	    }
	}
}

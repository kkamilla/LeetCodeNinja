package dp_palindromicSubsequence;

import java.util.ArrayList;
import java.util.List;

public class PalindromDecomp_131 {
	class Solution {
	    
	    public List<List<String>> partition(String s) {
	        List<List<String>> res=new ArrayList<>();
	        List<String> tempList=new ArrayList<>();
	        //populate dptable such that dp[i][j]==true represent that string i to j is a palindrom
	        boolean[][] dptable=new boolean[s.length()][s.length()];
	        //fill one length string, the diagonal first
	        for(int i=0;i<s.length();i++){
	            dptable[i][i]=true;
	        }
	        
	        //fill 2 length strings by checking if both are same 
	        for(int i=0;i<s.length()-1;i++){
	            int j=i+1;
	            if(s.charAt(i)==s.charAt(j)){
	                 dptable[i][j]=true;
	            }
	           
	        }
	        
	        
	        //fill 3 or more length strings by checking if both are same
	        for(int len=2;len<s.length();len++){
	            for(int i=0;i<s.length()-len;i++){
	                int j=i+len;
	                if(s.charAt(i)==s.charAt(j) && dptable[i+1][j-1]){
	                     dptable[i][j]=dptable[i+1][j-1];
	                }
	            }
	        }
	        
	        //now call recursion using this dptable
	       partition_dp( s, 0,tempList, res,dptable);
	        return res;
	      
	    }
	    
	    public void partition_dp(String s,int currIndex,List<String> templist,List<List<String>> res,boolean[][] dptable) {
	        if(currIndex==s.length()){
	            res.add(new ArrayList<>(templist));
	        }
	        else{
	            //check if 1 length starting at currIndex is a palindrom
	            //chekc all leneghts , if yes then call recursion at next index
	            //else go back and try other possiblites
	            for(int len=0;len<s.length()-currIndex;len++){
	               // System.out.println(s.substring(currIndex,currIndex+len)+":"+dptable[currIndex][currIndex+len]);
	                if(dptable[currIndex][currIndex+len]){
	                    //go further
	                    templist.add(s.substring(currIndex,currIndex+len+1));
	                    partition_dp( s, currIndex+len+1,templist, res,dptable);
	                    templist.remove(templist.size()-1);
	                }
	            }
	        }
	    }
	    
	    public List<List<String>> partition_rec(String s) {
	        List<List<String>> res=new ArrayList<>();
	        List<String> tempList=new ArrayList<>();
	        partition( s, 0,tempList, res);
	        return res;
	    }
	    
	    
	    public void partition(String s,int currIndex,List<String> templist,List<List<String>> res) {
	        if(currIndex==s.length()){
	            res.add(new ArrayList<>(templist));
	        }
	        else{
	            //check if 1 length starting at currIndex is a palindrom
	            //chekc all leneghts , if yes then call recursion at next index
	            //else go back and try other possiblites
	            for(int len=1;len<=s.length()-currIndex;len++){
	                if(isPalindrom(s.substring(currIndex,currIndex+len))){
	                    //go further
	                    templist.add(s.substring(currIndex,currIndex+len));
	                    partition( s, currIndex+len,templist, res);
	                    templist.remove(templist.size()-1);
	                }
	            }
	        }
	    }
	    
	    
	    boolean isPalindrom(String s){
	        if(s.length()==1){
	            return true;
	        }
	        int start=0;
	        int end=s.length()-1;
	        while(start<end){
	            if(s.charAt(start)!=s.charAt(end)){
	               return false; 
	            }
	            start++;
	            end--;
	        }
	        return true;
	    }
	}
}

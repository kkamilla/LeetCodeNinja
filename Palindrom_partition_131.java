package recursion_backtracking;

public class Palindrom_partition_131 {
	class Solution {
	    public List<List<String>> partition(String s) {
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

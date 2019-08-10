package dp_longestCommonSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumMatchingSubsequences_792 {
	class Solution {
	    
	     public int numMatchingSubseq(String S, String[] words) {
	         Map<Character,List<String>> nextCharMap=new HashMap<>();
	         for(int i=0;i<words.length;i++){
	             //add all words with first char as key
	             if(nextCharMap.containsKey(words[i].charAt(0))){
	                 List<String> l=nextCharMap.get(words[i].charAt(0));
	                 l.add(words[i]);
	                 nextCharMap.put(words[i].charAt(0),l);
	             }
	             else{
	                 List<String> l=new ArrayList<>();
	                 l.add(words[i]);
	                 nextCharMap.put(words[i].charAt(0),l);
	             }
	             
	         }
	         
	         //loop thru the Text string to see if we have each of these chars and if we get the firdt char , we process the current char by adding it to new key char which now points to next needed char in the word
	         char[] textArray=S.toCharArray();
	         
	         for(char c: textArray){
	             if(nextCharMap.containsKey(c)){
	                 //this is one of the needed chars
	                 //we take a substring of each of the words in the list for that char
	                 List<String> l=nextCharMap.get(c);
	                 nextCharMap.remove(c);
	                 List<String> lnew=new ArrayList<>();
	                 for(String e: l){
	                     if(e.length()>1){
	                         lnew.add(e.substring(1));
	                     }
	                     
	                 }
	                 
	                 //add these new substrings to corrsponding char in the hashmap
	                 if(lnew.size()>0){
	                   for(String s: lnew){
	                        if(nextCharMap.containsKey(s.charAt(0))){
	                             List<String> ls=nextCharMap.get(s.charAt(0));
	                             ls.add(s);
	                             nextCharMap.put(s.charAt(0),ls);
	                         }
	                         else{
	                             List<String> ls=new ArrayList<>();
	                             ls.add(s);
	                             nextCharMap.put(s.charAt(0),ls);
	                         } 
	                    }  
	                 }
	                 
	                 
	             }
	             
	             //else go to the next char in text
	             
	             
	         }
	         
	         //if all the lists in hashmap are empty then we can say
	         //count the list of words for each char in hashmap
	         int count_notfound=0;
	          for (Map.Entry<Character, List<String>> entry : nextCharMap.entrySet()) {
	                System.out.println(entry.getKey() + ":" + entry.getValue().size());
	              count_notfound+=entry.getValue().size();
	            }
	         return words.length-count_notfound;
	         
	     }
	    
	    
	    
	    public int numMatchingSubseq_rec(String S, String[] words) {
	        
	        
	        int count=0;
	        for(int i=0;i<words.length;i++){
	            int[][] memo=new int[words[i].length()][S.length()];
	            for(int r=0;r<memo.length;r++){
	                for(int j=0;j<memo[r].length;j++){
	                    memo[r][j]=-1;
	                }
	            }
	            if(isSubsequence( words[i],  S, 0, 0,memo)){
	                count++;
	            }
	        }
	        return count;
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

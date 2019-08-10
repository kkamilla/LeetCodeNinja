package grokking_2slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams_438 {
	
	    public List<Integer> findAnagrams(String s, String p) {
	         List<Integer> res=new ArrayList<>();
	        if(s.length()<p.length()){
	            return res;
	        }
	        int[] p_count=new int[26];
	        int[] s_count=new int[26];
	       
	        for(int i=0;i<p.length();i++){
	            p_count[p.charAt(i)-'a']++;
	            s_count[s.charAt(i)-'a']++;
	        }
	        int windowStart=0;
	        int windowEnd=p.length();
	        for(;windowEnd<s.length();windowEnd++){
	            if(isSame(s_count,p_count)){
	                //found anagram 
	                res.add(windowStart);
	            }
	            //slide the window forard to see if its still a anagram of p, so length of the window is fixed as length of p
	            s_count[s.charAt(windowEnd)-'a']++;
	            s_count[s.charAt(windowStart)-'a']--;
	            //System.out.println(s_count);
	            windowStart++;
	        }
	        //at the end if its anagram
	        if(isSame(s_count,p_count)){
	                res.add(windowStart);
	            }
	        return res;
	        
	    }
	   boolean isSame(int[] s_count,int[] p_count){
	        for(int i=0;i<s_count.length;i++){
	            if(s_count[i]!=p_count[i]){
	                return false;
	            }
	        }
	       return true;
	    }
	
}

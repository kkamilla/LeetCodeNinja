package grokking_2slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermuationsS1inS2_567 {

	    public boolean checkInclusion(String s1, String s2) {
	        if(s2.length()<s1.length()){
	            return false;
	        }
	        //continuos substring of s2 which contains all characters in s1
	        int[] s1_count=new int[26];
	        int[] s2_count=new int[26];
	        
	        Map<Character,Integer> cmap_orginal=new HashMap<>();
	        for(int i=0;i<s1.length();i++){
	            s1_count[s1.charAt(i)-'a']++;
	            //0 to s1 lenght is the max window size that is allowed as we want to find all chars of s1 in s2, so window cannot be greater than length of s1
	            s2_count[s2.charAt(i)-'a']++;
	        }
	        int windowStart=0;//because we started at 0 of s2 now and window end here is length of s1 as s2_count contains elements from 0 to s1.length
	    
	        for(int windowEnd=s1.length();windowEnd<s2.length();windowEnd++){
	            //if s1_count==s2_count at all indices then true
	             if(isSimilarArrays(s1_count,s2_count)){
	                return true;
	            }
	            //slide window to get the add the windowEnd element to s2_count and remove windowStart elment remove s2_count
	            s2_count[s2.charAt(windowEnd)-'a']++;
	            s2_count[s2.charAt(windowStart)-'a']--;
	            //0 to s1 lenght is the max window size that is allowed as we want to find all chars of s1 in s2, so window cannot be greater than length of s1
	            //here we advanced the windowend in for loop , so we need to reduce the windowstart to keep only s1.lngth worth of chars in window and not more than that.
	            windowStart++;
	        }
	        
	        return isSimilarArrays(s1_count,s2_count);
	    }
	   boolean isSimilarArrays(int[] s1_count,int[] s2_count){
	        for(int i=0;i<s1_count.length;i++){
	            if(s1_count[i]!=s2_count[i]){
	                return false;
	            }
	        }
	       return true;
	    }
	
}

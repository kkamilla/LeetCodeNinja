package grokking_2slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring_424 {
	public int lengthOfLongestSubstring(String s) {
        int windowStart=0;
        int longest_length=0;
        Map<Character,Integer> cmap=new HashMap<>();
        for(int windowEnd=0;windowEnd<s.length();windowEnd++){
            if(cmap.containsKey(s.charAt(windowEnd))){
                //this is a reapating char
                //slide the window forward until last index of reapeating char stored in map +1  
                int lastIndexOfReapeatedChar=cmap.get(s.charAt(windowEnd));
                //remove all chars between widowstart and lastIndexOfReapeatedChar(included) from the map
                for(int i=windowStart;i<=lastIndexOfReapeatedChar;i++){
                    cmap.remove(s.charAt(i));
                }
                windowStart=lastIndexOfReapeatedChar+1; 
                //add the new index of the repeated character into map
                cmap.put(s.charAt(windowEnd),windowEnd);
            }
            else{
                //this is a non reapeating char
                cmap.put(s.charAt(windowEnd),windowEnd);
                longest_length=Math.max(longest_length,windowEnd-windowStart+1);
            }
        }
        return longest_length;
    }
}

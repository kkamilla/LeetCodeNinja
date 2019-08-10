package grokking_2slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class ReplaceKChars {
	
	    public int characterReplacement(String s, int k) {
	        if(s.length()==0){
	            return 0;
	        }
	        //i can only expand my window when i see a char not in my map but until the extent ==k such chars
	        int windowStart=0;
	        //char at windowstart is base char with which we can check how much we can extend with k replcaments
	        //char baseChar=s.charAt(windowStart);
	        int[] countArray=new int[26];
	        int longest_len=0;
	        Map<Character,Integer> cmap=new HashMap<>();
	        int freq_ofmostfrequentChar=0;
	        for(int windowEnd=0;windowEnd<s.length();windowEnd++){
	            //only upper case letter so subtractig 'A' will make index from 0 to 26 instead of 65 to 92
	            countArray[s.charAt(windowEnd)-'A']++;
	            //number of chars not equal to the char with most frequency in the current window(this might not necessarily be the windowStart element) is total window size- count of windowstartcharacter
	            freq_ofmostfrequentChar=Math.max(freq_ofmostfrequentChar,countArray[s.charAt(windowEnd)-'A']);
	            int count_charsDifferentFromMostFreqChar=windowEnd-windowStart+1-freq_ofmostfrequentChar;
	            while(count_charsDifferentFromMostFreqChar>k){
	                //slide window and check if charsDifferentFromWindowStart<k now
	                countArray[s.charAt(windowStart)-'A']--;
	                windowStart++;
	                count_charsDifferentFromMostFreqChar=windowEnd-windowStart+1-countArray[s.charAt(windowStart)-'A'];
	            }
	            //if ==k
	            longest_len=Math.max(longest_len,windowEnd-windowStart+1);
	        }
	        return longest_len;
	    }
	}


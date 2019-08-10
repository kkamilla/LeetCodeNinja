package grokking_2slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordConcatenation_30 {
	public List<Integer> findSubstring(String s, String[] words) {
        if(s == null || s.length() == 0 || words == null || words.length == 0) return Collections.emptyList();
        HashMap<String,Integer> given_map = new HashMap<>();            // map to record frequency of word 
        int len = words[0].length()*words.length;
        for(String str: words){
            int count = given_map.getOrDefault(str,0);
            given_map.put(str,count+1);
        }
        
        // s = "barfoofoothefoobartheman",
       // words = ["foo","bar","the"]
        //ouput=[6,,9,12]
        
        List<Integer> list = new LinkedList<>();
        //loop:
        for(int i = 0;i<=s.length() - len;i++){ 
        	//O(m - n) time complexity, where m is length of s, n is the length of all word
            HashMap<String,Integer> tempMap = new HashMap<>();   
            
            //word can start from i+j to i+j+words[0].length
            //collect all words as required , len number of words
            for(int j = 0;j<len;j += words[0].length()){   
            	//O(N) time complexity, where N is length of words
                String sub = s.substring(i+j,i+j+words[0].length());
                if(given_map.containsKey(sub)){
                    int count = tempMap.getOrDefault(sub,0);
                    tempMap.put(sub,count+1);
                }else {
                	//if its not presetn in given_map
                	break;
                }
            }
            //once all words are collected we check if 2 maps are same
          //O(n) time complexity to compare two maps
            if(given_map.equals(tempMap)) {
            	list.add(i);                    
            }
        }
        return list;
    }
}

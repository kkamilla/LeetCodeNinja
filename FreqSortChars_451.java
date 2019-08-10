package topK_Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class FreqSortChars_451 {
	class Solution {
	    public String frequencySort(String s) {
	        Map<Character, Integer> map = new HashMap<>();
	        for (char c : s.toCharArray())
	            map.put(c, map.getOrDefault(c, 0) + 1);
							
	        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>(){
	            public int compare(Map.Entry<Character, Integer> e1,Map.Entry<Character, Integer> e2){
	                if(e1.getValue()>e2.getValue()){
	                    return -1;
	                }
	                else{
	                    return 1;
	                }
	            }
	            
	        });
	        maxHeap.addAll(map.entrySet());
	        
	        StringBuilder sb = new StringBuilder();
	        //using string instead of stringbuilder was causing time limit exeeeded as lot of new strngs were created, adding stringbuilder, solved this tLE issue
	        while(maxHeap.size()>0){
	            Map.Entry<Character, Integer> e=maxHeap.poll();
	            for(int j=0;j<e.getValue();j++){
	                sb.append(e.getKey());
	            }
	        }
	        return sb.toString();
	    }
	    public String frequencySort_order_N_bucketSort(String s) {
	        Map<Character, Integer> map = new HashMap<>();
	        for (char c : s.toCharArray()) 
	            map.put(c, map.getOrDefault(c, 0) + 1);
							
	        List<Character> [] bucket = new List[s.length() + 1];
	        for (char key : map.keySet()) {
	            int frequency = map.get(key);
	            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
	            bucket[frequency].add(key);
	        }
					
	        StringBuilder sb = new StringBuilder();
	        for (int pos = bucket.length - 1; pos >= 0; pos--)
	            if (bucket[pos] != null)
	                for (char c : bucket[pos])
	                    for (int i = 0; i < map.get(c); i++)
	                        sb.append(c);

	        return sb.toString();
	    }
	}
}

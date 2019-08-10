package topK_Elements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.*;
public class TopKFreqElements_347 {
	class Solution {
	    class Obj{
	        int element;
	        int freq;
	        Obj(int e,int f){
	            element=e;
	            freq=f;
	        }
	    }
	    public List<Integer> topKFrequent(int[] nums, int k) {
	        Map<Integer,Integer> freqMap=new HashMap<>();
	        for(int i:nums){
	            if(freqMap.containsKey(i)){
	                int c=freqMap.get(i);
	                c++;
	                freqMap.put(i,c);
	            }
	            else{
	                freqMap.put(i,1);
	            }
	        }
	        
	        PriorityQueue<Obj> minHeap=new PriorityQueue<>(new Comparator<Obj>(){
	            public int compare(Obj o1,Obj o2){
	                //we need min freq element at the op
	                if(o1.freq<o2.freq){
	                    return -1;
	                }
	                else{
	                    return 1;
	                }
	            }
	        });
	        
	        //add to minheap of size k
	        for(int key :freqMap.keySet()){
	            if(minHeap.size()<k){
	                minHeap.offer(new Obj(key,freqMap.get(key)));
	            }
	            else if(minHeap.size()==k && minHeap.peek().freq<freqMap.get(key)){
	                //remove this top and add the incoming element
	                minHeap.poll();
	                 minHeap.offer(new Obj(key,freqMap.get(key)));
	                
	            }
	        }
	       
	        //output the k eelements in heap
	        List<Integer> output=new ArrayList<>();
	        while(minHeap.size()>0){
	            output.add(minHeap.poll().element);
	        }
	       return output; 
	    }
	}
}

package topK_Elements;

import java.util.ArrayList;
import java.util.*;
import java.util.PriorityQueue;

public class KClosestElements_658 {
	class Solution {
	    class Obj{
	        int element;
	        int diff;
	        Obj(int e,int d){
	            element=e;
	            diff=d;
	        }
	    }
	    public List<Integer> findClosestElements(int[] arr, int k, int x) {
	        PriorityQueue<Obj> maxHeap=new PriorityQueue<>(new Comparator<Obj>(){
	            public int compare(Obj o1,Obj o2){
	                if(o1.diff>o2.diff){
	                    return -1;
	                }
	                else{
	                    return 1;
	                }
	            }
	            
	        });
	        
	        for(int i:arr){
	            if(maxHeap.size()<k){
	                maxHeap.offer(new Obj(i,x-i));
	            }
	            else if(maxHeap.size()==k && maxHeap.peek().diff>Math.abs(x-i)){
	                maxHeap.poll();
	                 maxHeap.offer(new Obj(i,x-i));
	            }
	        }
	        
	        List<Integer> res=new ArrayList<>();
	        while(maxHeap.size()>0){
	            res.add(maxHeap.poll().element);
	        }
	        return res;
	    }
	}
}

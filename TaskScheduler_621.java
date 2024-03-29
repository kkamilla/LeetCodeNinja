package mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler_621 {
	public int leastInterval(char[] tasks, int n) {
	       Map<Character,Integer> taskFreq=new HashMap<>();
	        for(char c:tasks){
	            taskFreq.put(c,taskFreq.getOrDefault(c,0)+1);
	        }
	        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
	        maxHeap.addAll(taskFreq.values());
	        int cpu_cycles=0;
	        
	        
	        while(!maxHeap.isEmpty()){
	            //loop thru n cooling intervals and execute as many unique tasks present in heap
	            List<Integer> tasksExecuted_currentLoop=new ArrayList<>();
	            for(int i=0;i<=n;i++){
	                if(!maxHeap.isEmpty()){
	                    tasksExecuted_currentLoop.add(maxHeap.remove());
	                }
	                else {
	                	break;
	                }
	            }
	            
	            //after one full cooling time cycle, add back all the tasks count that were removed
	            //if the tasks count is still >0 after its been executed once in this current cycle
	            for(int freq:tasksExecuted_currentLoop){
	                if(--freq>0){
	                    //add back to the maxHeap
	                    maxHeap.add(freq);
	                }
	            }
	            
	            //add number of cycles that were exceuted in currrent loop
	            int currCount=0;
	            if(maxHeap.size()==0){
	               currCount=tasksExecuted_currentLoop.size(); 
	            }
	            else{
	                //if we had n different tasks to execute in the given list as maxHeap is not empty 
	                //total tasks done (n-0)+1=n+1
	                currCount=n+1;
	            }
	            cpu_cycles+=currCount;
	        }
	        
	        return cpu_cycles;
	    }
}

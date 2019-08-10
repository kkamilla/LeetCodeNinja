package topK_Elements;

import java.util.*;

public class TaskScheduler_621 {
	class Solution {
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
	            
	            //add number of tasks executed in current loop
	            int currCount=0;
	            //at the end of all the tasks are done, in the last round as we don't need to go till cooling period if we are done with all tasks at the end cycle
	            if(maxHeap.size()==0){
	               currCount=tasksExecuted_currentLoop.size(); 
	            }
	            else{
	                //either we had n different tasks to execute/we took some idle time, in the given list as maxHeap is not empty now,
	            	//so we would have done some tasks + some idle time as all should sum up to n+1 in the current round
	                //total tasks done (n-0)+1=n+1
	                currCount=n+1;
	            }
	            cpu_cycles+=currCount;
	            
	            
	        }
	        
	        return cpu_cycles;
	    }
	}
}

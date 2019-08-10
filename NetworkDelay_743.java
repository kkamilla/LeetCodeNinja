package graph;

import java.util.*;

public class NetworkDelay_743 {
	class Solution {
	    class Obj{
	        int node;
	        int dist_fromSource;
	        Obj(int n,int d){
	            node=n;
	            dist_fromSource=d;
	        }
	    }
	    public int networkDelayTime(int[][] times, int N, int K) {
	        //this is single source shortest time for signal to reach other nodes
	        //Dijasktra can be used
	        Map<Integer,List<List<Integer>>> neighbrs_wt=new HashMap<>();
	        for(int row=0;row<times.length;row++){
	            if(neighbrs_wt.containsKey(times[row][0])){
	                List<List<Integer>> sublist=neighbrs_wt.get(times[row][0]);
	                List<Integer> node_wt=new ArrayList<>();
	                node_wt.add(times[row][1]);
	                node_wt.add(times[row][2]);
	                sublist.add(node_wt); 
	                neighbrs_wt.put(times[row][0],sublist);
	            }
	            else{
	               List<List<Integer>> sublist=new ArrayList<>();
	                List<Integer> node_wt=new ArrayList<>();
	                node_wt.add(times[row][1]);
	                node_wt.add(times[row][2]);
	                sublist.add(node_wt); 
	                neighbrs_wt.put(times[row][0],sublist);
	            }   
	        }
	        
	        int[] distance_fromSource=new int[N+1];
	        //1 to N , so we find nodes by i-1 as index as index start from 0 to N-1
	        for(int i=1;i<distance_fromSource.length;i++){
	            distance_fromSource[i]=Integer.MAX_VALUE;
	        }
	        
	        //source distn=0 from itself
	        distance_fromSource[K]=0;
	        //create a minHeap with distacne from source as key
	        PriorityQueue<Obj> minHeap=new PriorityQueue<>(new Comparator<Obj>(){
	            public int compare(Obj o1,Obj o2){
	                if(o1.dist_fromSource<o2.dist_fromSource){
	                    return -1;
	                }
	                else{
	                    return 1;
	                }
	            }
	        });
	        //System.out.println(neighbrs_wt);
	        //add source to PQ
	        minHeap.offer(new Obj(K,0));
	        Set<Integer> visited=new HashSet<>();
	        
	        while(!minHeap.isEmpty()){
	            
	            Obj top=minHeap.poll();
	            visited.add(top.node);
	           // System.out.println(top.node);
	            if(neighbrs_wt.containsKey(top.node)){
	                //process distances of neigbrs from current node
	                List<List<Integer>> sublist=neighbrs_wt.get(top.node);
	                for(List<Integer> l:sublist){
	                    int neigh=l.get(0);
	                    int weight=l.get(1);
	                     //System.out.println("neigh="+neigh+" distance_fromSource[neigh]="+ distance_fromSource[neigh]);
	                    if(distance_fromSource[neigh]>top.dist_fromSource+weight){
	                        distance_fromSource[neigh]=top.dist_fromSource+weight;
	                        //add to heap only if you found a shorter distacne as 
	                        if(!visited.contains(neigh)){
	                             minHeap.offer(new Obj(neigh,distance_fromSource[neigh])); 
	                        }
	                    }
	                   
	                    
	                }
	                
	            }
	            
	        }
	        
	       
	        
	        int max_time=0;
	        for(int i=0;i<distance_fromSource.length;i++){
	           // System.out.println("i="+i+" distance_fromSource="+distance_fromSource[i]);
	            max_time=Math.max(max_time,distance_fromSource[i]);
	        }
	        //if any of the nodes is not reacahble from source, then return -1
	        return max_time==Integer.MAX_VALUE?-1:max_time;
	    }
	}
}

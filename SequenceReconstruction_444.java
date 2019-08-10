package graph;

import java.util.*;

public class SequenceReconstruction_444 {
	class Solution {
		
		//works only for seqs individual array size=2 not more than that/less than that, need to fix
		//61/100 tests passed
		
	    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
	        Map<Integer,List<Integer>> childMatrix=new HashMap<>();
	        Map<Integer,Integer> indegree=new HashMap<>();
	        
	        for(int i=0;i<seqs.size();i++){
	            if(seqs.get(i).size()>1){
	                int parent=seqs.get(i).get(0);
	                int child=seqs.get(i).get(1);
	                if(!indegree.containsKey(parent)){
	                    indegree.put(parent,0);
	                }
	                if(!indegree.containsKey(child)){
	                    indegree.put(child,1);
	                }
	                else{
	                    int c=indegree.get(child);
	                    c=c+1;
	                    indegree.put(child,c);
	                }
	                if(childMatrix.containsKey(parent)){
	                    List<Integer> l=childMatrix.get(parent);
	                    l.add(child);
	                    childMatrix.put(parent,l);

	                }
	                else{
	                   List<Integer> l=new ArrayList<>();
	                    l.add(child);
	                    childMatrix.put(parent,l); 
	                }
	            }
	            
	            
	            
	        }
	        
	        int count_possible_start_seq=0;
	        Queue<Integer> bfs_q=new LinkedList<>();
	        //add indegree 0 node on queue
	        for(int i:indegree.keySet()){
	            if(indegree.get(i)==0){
	                count_possible_start_seq++;
	                bfs_q.add(i);
	            }
	        }
	        //more than one start value possible for start node in sequence then there is ambiguity and more than one value possible
	        if(count_possible_start_seq>1){
	            return false;
	        }
	        else{
	            int k=0;
	            while(!bfs_q.isEmpty()){
	                int top=bfs_q.poll();
		            if(org[k]!=top){
	                    return false;
	                }
		            k++;
		             count_possible_start_seq=0;
		            //check indegree of neigbrs
	                if(childMatrix.containsKey(top)){
	                    for(int col=0;col<childMatrix.get(top).size();col++){
		                int indegree_count=indegree.get(childMatrix.get(top).get(col));
	                    indegree_count--;
	                    indegree.put(childMatrix.get(top).get(col),indegree_count);
	                    //if 0 add to queue
	                    if(indegree_count==0){
	                        count_possible_start_seq++;
	                        bfs_q.add(childMatrix.get(top).get(col));
	                    }
		               
		            }
	                }
		            
	                //more than one start value possible for start node in sequence
	                if(count_possible_start_seq>1){
	                    return false;
	                }
	                
	            }
	            if(k==org.length){
		            return true;
		        }
	            else{
	                return false;
	            }
	        }
	        
	    }
	    
	}
}

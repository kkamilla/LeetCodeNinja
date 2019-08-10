package k_way_merge_heap;

import java.util.*;

public class KthSmallestNumSortedMatrix_378 {
	class Solution {
	    class Obj{
	        int val;
	        int row;
	        int col;
	        Obj(int v,int r,int c){
	            val=v;
	            row=r;
	            col=c;
	        }
	    }
	    public int kthSmallest(int[][] matrix, int k) {
	        //this can be solved by kway merge techinique
	        PriorityQueue<Obj> minHeap=new PriorityQueue<>(new Comparator<Obj>(){
		            public int compare(Obj o1,Obj o2){
		                //first sort by freq
		                if(o1.val>o2.val){
		                    return 1;
		                }
		                
		                else{
		                    //o1.freq<o2.freq
		                    return -1;
		                }
		            }
		        });
	        
	        //heap can have only row count number of elements at anypoint
	        //add the first elements of each row into the minheap
	        for(int row=0;row<matrix.length;row++){
	            minHeap.offer(new Obj(matrix[row][0],row,0));
	        }
	        
	        while(k>1){
	            Obj top=minHeap.poll();
	            //decremnet k
	            k--;
	            int r=top.row;
	            int c=top.col;
	            //get the next element from same row, but next col and add it to heap
	            if(c+1<matrix[r].length){
	                minHeap.offer(new Obj(matrix[r][c+1],r,c+1));
	            }
	            else{
	                //don't add anyhting
	            }
	            
	        }
	        
	        return minHeap.poll().val;
	        
	        
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
	
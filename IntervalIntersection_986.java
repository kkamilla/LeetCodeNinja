package mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection_986 {
	class Solution {
	    public int[][] intervalIntersection(int[][] A, int[][] B) {
	        //to conclude that 2 intervals in 2 sorted lists intersect , we need to check if whatever is max of start times among the 2 intervals, lies befoer the end times of the other
	        //whenever the two intervals overlap, one of the interval’s start time lies within the other interval. This rule can help us identify if any two intervals overlap or not.
	        //to find common points between 2 interval objects , we need to get max of start time and min of end times which would give us common points between 2 inteval objects...this tells us the extent of overlap
	        List<int[]> res=new ArrayList<>();
	        int i=0,j=0;
	        while(i<A.length && j<B.length){
	            //if A's start >B's end or reverse then no overlap
	            if(A[i][0]>B[j][1] || B[j][0]>A[i][1]){
	              //no overlap between them  
	            }
	            else{
	                //overalp
	                //to find the extend of overlap we take max of start times and min of end times from A, B list intervals
	                int maxStart=Math.max(A[i][0],B[j][0]);
	                int minEnd=Math.min(A[i][1],B[j][1]);
	                res.add(new int[]{maxStart,minEnd});
	                
	            }
	            //go forward in the list with smaller end value of current index interval in comparision as it does not have any possibility of intervsection with next values in A list
	            if(A[i][1]>B[j][1] ){
	                j++;
	            }
	            else{
	                i++;
	            }
	        }
	        return res.toArray(new int[res.size()][]);
	    }
	}
}

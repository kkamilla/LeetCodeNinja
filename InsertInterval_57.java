package mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {
	class Solution {
	    public int[][] insert(int[][] intervals, int[] newInterval) {
	       
	        if(intervals.length==0 && newInterval.length==0){
	            return intervals;
	        }
	         List<int[]> res=new ArrayList<>();
	        if(intervals.length==0 && newInterval.length!=0){
	            res.add(new int[]{ newInterval[0], newInterval[1]});
	            return res.toArray(new int[res.size()][]);
	        }
	        
	         //Skip all intervals which end before the start of the new interval, i.e., skip all intervals with the following condition:
	    //intervals[i].end < newInterval.start
	        int i=0;
	        while(i<intervals.length && intervals[i][1]<newInterval[0]){
	            res.add(new int[]{ intervals[i][0], intervals[i][1]});
	            i++;
	        }
	       
	        int prevS=newInterval[0];
	        int prevE=newInterval[1];
	        //Let’s call the last interval ‘b’ that does not satisfy the above condition. If ‘b’ overlaps with the new interval (a) (i.e. b.start <= a.end), we need to merge them into a new interval ‘c’:
	    //c.start = min(a.start, b.start)
	    //c.end = max(a.end, b.end)
	   
	        for(int j=i;j<intervals.length;j++){
	            if(intervals[j][0]<=prevE){
	                //overlap
	                prevS=Math.min(prevS,intervals[j][0]);
	                prevE=Math.max(prevE,intervals[j][1]);
	            }
	            else{
	                //no overlap
	                //add prev to final list
	                res.add(new int[]{prevS,prevE});
	                prevS=intervals[j][0];
	                prevE=intervals[j][1];
	                
	            }
	        }
	        res.add(new int[]{prevS,prevE});
	        return res.toArray(new int[res.size()][]);
	    
	    }
	    
	    
}}

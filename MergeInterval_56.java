package mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval_56 {
	class Interval {
		  int start;
		  int end;

		  public Interval(int start, int end) {
		    this.start = start;
		    this.end = end;
		  }
		};
	public int[][] merge(int[][] intervals) {
	       if(intervals.length==0||intervals.length==1){
	            return intervals;
	        }
			else{
	           List<Interval> givenIntervals=new ArrayList<>();
	            for(int i=0;i<intervals.length;i++){
	                givenIntervals.add(new Interval(intervals[i][0],intervals[i][1]));
	            }
			//sort intervals by staring digit and then by ending digit
			Collections.sort(givenIntervals,new Comparator<Interval>(){
				
				public int compare(Interval o1, Interval o2) {
				    return o1.start- o2.start;
				}
				
			});
			List<Interval> res=new ArrayList<Interval>();
			
			int prevStart=givenIntervals.get(0).start;
			int prevEnd=givenIntervals.get(0).end;
			for(int i=1;i<givenIntervals.size();i++){
				int currStart=givenIntervals.get(i).start;
				int currEnd=givenIntervals.get(i).end;
	            //no overlap
				if(currStart>prevEnd){
	                //add prev one to result
					res.add(new Interval(prevStart,prevEnd));
	                //update start and end
					prevStart=currStart;
					prevEnd=currEnd;
				}
				else{
					//res.add(new Interval(prevStart,Math.max(prevEnd, currEnd)));
					prevEnd=Math.max(prevEnd, currEnd);
				}
	           
				
			}
			 res.add(new Interval(prevStart,prevEnd));
			int[][] resArr=new int[res.size()][2];
	        for(int i=0;i<res.size();i++){
	            resArr[i][0]=res.get(i).start;
	            resArr[i][1]=res.get(i).end;
	        }
			return resArr;
	    } 
	    }
}

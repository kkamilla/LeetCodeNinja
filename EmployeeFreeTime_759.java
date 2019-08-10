package mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTime_759 {
	class Solution {
	    class TimeType{
		        int time;
		        boolean isStart;
		        TimeType(int t, boolean s){
		            time=t;
		            isStart=s;
		               
		        }
		    }
	    public int[][] employeeFreeTime(int[][][] schedule) {
	        List<TimeType> bookedTimeList=new ArrayList<>();
	        for(int i=0;i<schedule.length;i++){
	            for(int j=0;j<schedule[i].length;j++){
	                bookedTimeList.add(new TimeType(schedule[i][j][0],true));
	                bookedTimeList.add(new TimeType(schedule[i][j][1],false));
	            }
	        }
	        
	        Collections.sort(bookedTimeList,new Comparator<TimeType>(){
		          public  int compare(TimeType t1, TimeType t2){
		                 //first sort by time value
		                if(t1.time<t2.time){
		                    return -1;
		                }
		              //if the time values are same 
		                if(t1.time==t2.time){
		                    if(t1.isStart==true && t2.isStart==false)
		                    return 1;
		                }
		              if(t1.time==t2.time && t1.isStart==false && t2.isStart==true){
		                    return -1;
		                }
		                else{
		                    return 1;
		                }
		            }
		        });
	        List<int[]> output=new ArrayList<>();
	        int freeTime=0,prevTime=-1;
	        //go thru the list and add 1 if its a start time and subtract 1 if it is an end time
	        //when the val of freetime==0 and prev!=-1 then we know we have an empty slot here, so we add it to result
	        for(TimeType t:bookedTimeList){
	           if(freeTime==0 && prevTime!=-1){
	               //add prev and curr to output list
	               if(prevTime!=t.time){
	                   //to remove [5,5] slots even when its free slot
	                   output.add(new int[]{prevTime,t.time});
	               }
	               
	           } 
	            //now process the current time
	            if(t.isStart==true){
	                freeTime++;
	            }
	            else{
	                freeTime--;
	            }
	            prevTime=t.time;
	        }
	        
	        return output.toArray(new int[output.size()][]);
	        
	    }
	}
}

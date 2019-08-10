package mergeIntervals;
import java.util.*;
public class MinMeetingRooms {
	// Class name must be "Main"
	// Libraries included:
	// json simple, guava, apache commons lang3, junit, jmock

	// Given an list of meeting time intervals consisting of start and end times [[s1, e1],[s2,e2],...] find the minimum number of meeting rooms required to host the meeting.
	// Example: [[2, 5], [1, 5], [5, 7], [3, 8]] = 3

	//(2,1), (5,0)...
	// You can model the input in any way you'd like i.e. 2-d array, list of lists

	

	static class Main {
	    
	    class TimeType{
	        int time;
	        boolean isStart;
	        TimeType(int t, boolean s){
	            time=t;
	            isStart=s;
	               
	        }
	    }
	    
	     static int minMeetingRooms(List<TimeType> meetingTimes) {
	        //null, empty
	        //check start times<end times
	        //both are +ve numbers
	        
	        //sort it by start time first and then if they are same then  put ending time first
	        Collections.sort(meetingTimes,new Comparator<TimeType>(){
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
	        
	        int roomCount=0;
	        int maxCount=0;
	        for(TimeType t: meetingTimes){
	            
	        }
	        for(int i=0;i<meetingTimes.size();i++){
	            if(meetingTimes.get(i).isStart==true){
	                roomCount++;
	            }
	            else{
	                roomCount--;
	            }
	            maxCount=Math.max(maxCount,roomCount);
	        }
	        
	        return maxCount;
	        
	    }
	    //// Example: [[2, 5], [1, 5], [5, 7], [3, 8]] = 3
	    public static void main(String[] args) {
	        System.out.println("Hello, world!");
	        TimeType t1=new TimeType(2,true);
	        TimeType t2=new TimeType(4,false);
	        TimeType t3=new TimeType(1,true);
	        TimeType t4=new TimeType(20,false);
	        
	        TimeType t5=new TimeType(5,true);
	        TimeType t6=new TimeType(7,false);
	        TimeType t7=new TimeType(8,true);
	        TimeType t8=new TimeType(10,false);
	        
	        List<TimeType> meetingTimes = new ArrayList<>();
	        meetingTimes.add(t1);
	        meetingTimes.add(t2);
	        meetingTimes.add(t3);
	        meetingTimes.add(t4);
	        meetingTimes.add(t5);
	        meetingTimes.add(t6);
	        meetingTimes.add(t7);
	        meetingTimes.add(t8);
	        
	        System.out.println(minMeetingRooms(meetingTimes));
	         
	        
	    }
	}



}

package recursion_backtracking;

import java.util.Arrays;

public class CourseSchedule3_630 {
	class Solution {
	    public int scheduleCourse(int[][] courses) {
	        //sort by end date for each course
	        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
	        int maxTime=courses[courses.length-1][1]+1;
	        Integer[][] memo=new Integer[courses.length][maxTime];
	        
	        return schedule_rec(courses,0,0,memo);
	        
	    }
	    
	    int schedule_rec(int[][] courses, int index,int currTime,Integer[][] memo){
	        if(index==courses.length){
	            return 0;
	        }
	        if(memo[index][currTime]!=null){
	            return memo[index][currTime];
	        }
	        //do not take it
	        int x=schedule_rec(courses,  index+1,currTime,memo);
	        
	        //take it
	        int y=0;
	        if(courses[index][0]+currTime<=courses[index][1]){
	            y=1+schedule_rec(courses,  index+1,currTime+courses[index][0],memo);
	        }
	        memo[index][currTime]=Math.max(x,y);
	        return Math.max(x,y);
	        
	    }
	}
}

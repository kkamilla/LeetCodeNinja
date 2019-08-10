package graph;

import java.util.*;

public class CourseSchedule_207 {
	class Solution {
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	        int[][] child_matrix = new int[numCourses][numCourses]; // i -> j
	    int[] indegree = new int[numCourses];
	    
	    for (int i=0; i<prerequisites.length; i++) {
	        int post_course = prerequisites[i][0];
	        int pre_course = prerequisites[i][1];
	        if (child_matrix[pre_course][post_course] == 0){
	            //there is an edge from pre_course to post_course so increase indegree for post_course
	             indegree[post_course]++;
	        }
	        child_matrix[pre_course][post_course] = 1;
	    }
	    
	    int count_possible = 0;
	    Queue<Integer> queue = new LinkedList();
	    //find the vertex with indregree==0 to start with , so add it to queue
	    for (int i=0; i<indegree.length; i++) {
	        if (indegree[i] == 0){
	            queue.offer(i);
	        } 
	    }   
	    //now do a bfs
	    
	    while (!queue.isEmpty()) {
	        int course_from_top = queue.poll();
	        count_possible++;
	        //find all links from course in queue front, which means if i have done this front course, i can take any course that are its neighbrs
	        for (int col=0; col<child_matrix.length; col++) {
	            if (child_matrix[course_from_top][col] != 0) {
	                --indegree[col];
	                //check if all its indegress are processed and removed, if so we can add in queue only when indegree is 0
	                if (indegree[col] == 0){
	                     queue.offer(col);
	                }    
	            }
	        }
	    }
	    return count_possible == numCourses;
	    }
	}
}

package graph;

import java.util.*;

public class CourseSchedule2_210 {
	class Solution {
	    public int[] findOrder(int numCourses, int[][] prerequisites) {
	        boolean[][] childmatrix=new boolean[numCourses][numCourses];
	        int[] indegree=new int[numCourses];
	        for(int i=0;i<prerequisites.length;i++){
	           
	                //add an edge from prerequisites[i][0] to [i][1]
	                int pre_course=prerequisites[i][1];
	                int post_course=prerequisites[i][0];
	                childmatrix[pre_course][post_course]=true;
	                indegree[post_course]++;
	           
	        }
	        
	        //add indegree 0 to queue
	        Queue<Integer> bfs_q=new LinkedList<>();
	        for(int i=0;i<indegree.length;i++){
	            if(indegree[i]==0){
	                bfs_q.add(i);
	            }
	        }
	        int[] result=new int[numCourses];
	        int k=0;
	        while(!bfs_q.isEmpty()){
	            int top=bfs_q.poll();
	            result[k]=top;
	            k++;
	            
	            //check indegree of neigbrs
	            for(int col=0;col<childmatrix[top].length;col++){
	                if(childmatrix[top][col]){
	                    indegree[col]--;
	                    //if 0 add to queue
	                    if(indegree[col]==0){
	                        bfs_q.add(col);
	                    }
	                }
	            }
	            
	        
	            
	        }
	        if(k!=numCourses){
	            return new int[0];
	        }
	        
	        return result;
	        
	    }
	}
}

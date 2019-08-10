package graph;

import java.util.*;

public class MinHeightTreeRoot_310 {
	class Solution {
		class Obj{
			int val;
			int degree;
			List<Integer> neigb;
		}
		public List<Integer> findMinHeightTrees(int n, int[][] edges) {
			int[] degree=new int[n];
			List<Integer> res=new ArrayList<>();
			if(n==1){
				res.add(0);
				return res;
			}
			Map<Integer,List<Integer>> neighbr=new HashMap<>();
			for(int i=0;i<edges.length;i++){

				degree[edges[i][0]]++;
				degree[edges[i][1]]++;
				//add for the first node in the egde
				if(neighbr.containsKey(edges[i][0])){
					List<Integer> l=neighbr.get(edges[i][0]);
					l.add(edges[i][1]);
					neighbr.put(edges[i][0],l);
				}
				else{
					List<Integer> l=new ArrayList<>();
					l.add(edges[i][1]);
					neighbr.put(edges[i][0],l);
				}
				//add for the second node in the edge
				if(neighbr.containsKey(edges[i][1])){
					List<Integer> l=neighbr.get(edges[i][1]);
					l.add(edges[i][0]);
					neighbr.put(edges[i][1],l);
				}
				else{
					List<Integer> l=new ArrayList<>();
					l.add(edges[i][0]);
					neighbr.put(edges[i][1],l);
				}
			}

			// System.out.println(Arrays.asList(degree));
			//we want to first eliminate all nodes which are leaf nodes, nodes with degree 1 as this is a undirected graph
			//we add all the leaf nodes to the queue and process them by doing degree-- for each of their neigbrs 
			Queue<Integer> bfs_q=new LinkedList<>();
			for(int i=0;i<degree.length;i++){
				System.out.println("i="+i+" degree="+degree[i]);
				if(degree[i]==1){
					bfs_q.add(i);
				}
			}
			boolean[] visisted=new boolean[n];
			while(bfs_q.size()>0){
				int count = bfs_q.size();
				System.out.println("starting q size ="+bfs_q.size());
				res = new ArrayList<Integer>();

				//process all the nodes in the same level at once
				for(int i=0; i<count; i++){
					int top=bfs_q.poll();
					degree[top]--;
					//add same generation nodes to res as it might be the last round going on and we might have to return this last generation of nodes
					res.add(top);
					//check indegree of neigbrs
					if(neighbr.containsKey(top)){
						for(int col=0;col<neighbr.get(top).size();col++){
							System.out.println("neigh="+neighbr.get(top).get(col)+" degree="+degree[neighbr.get(top).get(col)]);

							degree[neighbr.get(top).get(col)]--;
							//if 1 add to queue
							if(degree[neighbr.get(top).get(col)]==1){
								System.out.println("adding ="+neighbr.get(top).get(col));
								System.out.println("q size ="+bfs_q.size());
								bfs_q.add(neighbr.get(top).get(col));
							}

						}
					}
				}

			}



			return res;
		}
	}
}

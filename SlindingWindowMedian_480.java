package twoHeaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SlindingWindowMedian_480 {
	public double[] medianSlidingWindow(int[] nums, int k) {
		//A max-heap lo to store the smaller half of the numbers
		//A min-heap hi to store the larger half of the numbers
		PriorityQueue<Integer> minHeap =  new PriorityQueue<>();//contains all larger numbers such that it has always lowest among the largest at the top of minheap
		PriorityQueue<Integer>	maxHeap = new PriorityQueue<>(Comparator.reverseOrder());//contains smaller numbrs such that it has larger amonng all smallest elements at the top
		//hashtable to store all invalid numbers
		Map<Integer,Integer> invalidNumsMap=new HashMap<>();
		//assuming maxheap always has one more element than minheap
		int balance=0;
		double[] median_result=new double[nums.length-k+1];
		//first time insert k elements
		for(int j=0;j<k;j++){
			//insert eleemnts
			if(maxHeap.size()==0 || nums[j]<=maxHeap.peek()){
				//it has to go to maxheap as maxheap has lower half elements
				maxHeap.offer(nums[j]);
				//balance=balance+1
				balance++;
			}
			else{
				//add to minheap as its greater than max of maxheap elements
				minHeap.offer(nums[j]);
				//balacnce=balance-1
				balance--;
			}  
		}
		//System.out.println("starting balancing->"+maxHeap+":"+minHeap+":"+balance);

		
		//balance heaps
		
		if(maxHeap.size()-minHeap.size()<1){
			//maxheap size<minheap size so move elements from minheap to maxheap
			while(minHeap.size()>0 && maxHeap.size()-minHeap.size()<1){
				maxHeap.offer(minHeap.poll());
				balance++;
			}
		}
		if(maxHeap.size()-minHeap.size()>1){
			//maxheap size>minheap size so move elements from maxheap to minheap
			while(maxHeap.size()>0 && maxHeap.size()-minHeap.size()>1){
				minHeap.offer(maxHeap.poll());
				balance--;
			}
		}
		
		
		// System.out.println("starting balacning2->"+maxHeap+":"+minHeap+":"+balance);
		double f=findMedian(maxHeap,minHeap,k);
		median_result[0]=f;
		//System.out.println(f);
		//balanceHeap(maxHeap ,minHeap, balance );
		int t=1;
		for(int windowEnd=k;windowEnd<nums.length;windowEnd++){
			int outgoing_index=windowEnd-k;
			int incoming_index=windowEnd;
			//balance=0;
			//System.out.println("balance"+":"+balance);




			//insert eleemnts
			if( nums[incoming_index]<=maxHeap.peek()){
				//it has to go to macheap as maxheap has lower half elements
				maxHeap.offer(nums[incoming_index]);
				balance++;
			}
			else{
				//add to minheap as its greater than max of maxheap elements
				minHeap.offer(nums[incoming_index]);
				//balacnce=balance-1
				balance--;
			}

			
			
			
			//remove outgoing element
			if(nums[outgoing_index]<=maxHeap.peek()){
				//then outgoing number is from maxheap, so number of valid elements in maxheap is reduced, so decrement balance 
				maxHeap.remove(nums[outgoing_index]);
				balance--;
			}
			else{
				minHeap.remove(nums[outgoing_index]);
				balance++;
			}
			//System.out.println(median_result[0]+":"+median_result[1]);
			// System.out.println("befoer balacning->"+maxHeap+":"+minHeap+":"+balance);
			// balanceHeap(maxHeap ,minHeap, balance );
			
			
			//balance heaps
			
			if(maxHeap.size()-minHeap.size()<1){
				//maxheap size<minheap size so move elements from minheap to maxheap
				while(minHeap.size()>0 && maxHeap.size()-minHeap.size()<1){
					maxHeap.offer(minHeap.poll());
					balance++;
				}
			}
			if(maxHeap.size()-minHeap.size()>1){
				//maxheap size>minheap size so move elements from maxheap to minheap
				while(maxHeap.size()>0 && maxHeap.size()-minHeap.size()>1){
					minHeap.offer(maxHeap.poll());
					balance--;
				}
			}




			//get median and add to array
			f=findMedian(maxHeap,minHeap,k);
			//System.out.println("curr median="+f);
			median_result[t]=f; 
			t++;
		}

		return median_result;
	}

	double findMedian(PriorityQueue<Integer> maxHeap ,PriorityQueue<Integer>	minHeap,int k){
		if( maxHeap.size()==0 && minHeap.size()==0){
			return (double)-1;
		}

		else if(k%2==1){
			//System.out.println("from minheap.."+minHeap.peek());
			return maxHeap.peek();
		}
		else {
			//if same number of elemets then
			return ((double)minHeap.peek()+(double)maxHeap.peek())/2.0;
		}
	}


	//	     public double[] medianSlidingWindow_lazyremoval(int[] nums, int k) {
	//	       //A max-heap lo to store the smaller half of the numbers
	//	 		//A min-heap hi to store the larger half of the numbers
	//	 		PriorityQueue<Integer> minHeap =  new PriorityQueue<>();//contains all lareger numbers such that it has always lowest among the largest at the top of minheap
	//	 		PriorityQueue<Integer>	maxHeap = new PriorityQueue<>(Comparator.reverseOrder());//contains smaller numbrs such that it has larger amonng all smallest elements at the top
	//	         //hashtable to store all invalid numbers
	//	         Map<Integer,Integer> invalidNumsMap=new HashMap<>();
	//	         //assuming maxheap always has one more element than minheap
	//	         int balance=0;
	//	         double[] median_result=new double[nums.length-k+1];
	//	         //first time insert k elements
	//	         for(int j=0;j<k;j++){
	//	                 //insert eleemnts
	//	                 if(maxHeap.size()==0 || nums[j]<=maxHeap.peek()){
	//	                     //it has to go to macheap as maxheap has lower half elements
	//	                     maxHeap.offer(nums[j]);
	//	                      //balance=balance+1
	//	                     balance++;
	//	                 }
	//	                 else{
	//	                     //add to minheap as its greater than max of maxheap elements
	//	                     minHeap.offer(nums[j]);
	//	                     //balacnce=balance-1
	//	                     balance--;
	//	                 }  
	//	             }
	//	         double f=findMedian(maxHeap,minHeap,k);
	//	         median_result[0]=f;
	//	         //balanceHeap(maxHeap ,minHeap, balance );
	//	         int t=1;
	//	         for(int windowEnd=k;windowEnd<nums.length;windowEnd++){
	//	             int outgoing_index=windowEnd-k;
	//	             int incoming_index=windowEnd;
	//	             //balance=0;
	//	             System.out.println("balance"+":"+balance);



	//	             //remove outgoing element
	//	             //add it to hashmap
	//	             System.out.println("outgoing="+nums[outgoing_index]);
	//	             if(invalidNumsMap.containsKey(nums[outgoing_index])){
	//	                 int c=invalidNumsMap.get(nums[outgoing_index]);
	//	                 invalidNumsMap.put(nums[outgoing_index],c++);
	//	             }
	//	             else{
	//	                invalidNumsMap.put(nums[outgoing_index],1); 
	//	             }
	//	             // /Once an invalid element reaches either of the heap tops, we remove them and decrement their counts in the hash_table table.

	//	             if(nums[outgoing_index]<=maxHeap.peek()){
	//	                 //then outgoing number is from maxheap, so number of valid elements in maxheap is reduced, so decrement balnce 
	//	                 balance--;
	//	             }
	//	             else{
	//	                 balance++;
	//	             }


	//	             //insert eleemnts
	//	             if( nums[incoming_index]<=maxHeap.peek()){
	//	                 //it has to go to macheap as maxheap has lower half elements
	//	                 maxHeap.offer(nums[incoming_index]);
	//	                 balance++;
	//	             }
	//	             else{
	//	                 //add to minheap as its greater than max of maxheap elements
	//	                 minHeap.offer(nums[incoming_index]);
	//	                 //balacnce=balance-1
	//	                 balance--;
	//	             }
	//	             //System.out.println(median_result[0]+":"+median_result[1]);
	//	              System.out.println("befoer balacning->"+maxHeap+":"+minHeap+":"+balance);
	//	            // balanceHeap(maxHeap ,minHeap, balance );
	//	              if(balance<0){
	//	                 //maxheap size<minheap size so move elements from minheap to maxheap
	//	                 //while(minHeap.size()>0 && balance!=0){
	//	                    maxHeap.offer(minHeap.poll());
	//	                     balance++;
	//	                 //}
	//	             }
	//	              if(balance>0){
	//	                 //maxheap size>minheap size so move elements from maxheap to minheap
	//	                  //while(maxHeap.size()>0 && balance!=0){
	//	                     minHeap.offer(maxHeap.poll());
	//	                      balance--;
	//	                  //}
	//	             }


	//	              System.out.println(maxHeap+":"+minHeap+":"+balance);
	//	             //if outgoing number is at top of the maxheap/minheap, so that it might contribute to answer, then remove it from heap, as now its already at the top and removal will take constant time
	//	             //remove from hashtable also
	//	             System.out.println("maxheap peek="+maxHeap.peek());
	//	             while(maxHeap.size()>0 && invalidNumsMap.containsKey(maxHeap.peek())){
	//	                 int x=maxHeap.poll();
	//	                 int c=invalidNumsMap.get(x);
	//	                 c--;
	//	                 if(c>0){
	//	                     invalidNumsMap.put(x,c);
	//	                 }
	//	                 else{
	//	                     invalidNumsMap.remove(x);
	//	                 }

	//	             }
	//	              System.out.println("minheap peek="+minHeap.peek());
	//	             while(minHeap.size()>0 && invalidNumsMap.containsKey(minHeap.peek())){
	//	                 int x=minHeap.poll();
	//	                 int c=invalidNumsMap.get(x);
	//	                 c--;
	//	                 if(c>0){
	//	                     invalidNumsMap.put(x,c);
	//	                 }
	//	                 else{
	//	                     invalidNumsMap.remove(x);
	//	                 }
	//	             }

	//	       //get median and add to array
	//	            f=findMedian(maxHeap,minHeap,k);
	//	             System.out.println("curr median="+f);
	//	             median_result[t]=f; 
	//	             t++;
	//	         }

	//	      return median_result;
	//	     }

	
}

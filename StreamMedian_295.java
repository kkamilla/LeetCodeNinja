package twoHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StreamMedian_295 {
	class MedianFinder {

		/** initialize your data structure here. */
		//A max-heap lo to store the smaller half of the numbers
		//A min-heap hi to store the larger half of the numbers
		PriorityQueue<Integer> minHeap = null;
		PriorityQueue<Integer> maxHeap = null;
		public MedianFinder() {
			//constructor
			
			minHeap = new PriorityQueue<>();//contains all larger numbers such that it has always lowest among the largest at the top of minheap
			maxHeap = new PriorityQueue<>(Comparator.reverseOrder());//contains smaller numbers such that it has larger among all smallest elements at the top

		}

		public void addNum(int num) {
			double currMedian=findMedian();
			if(currMedian == (double)-1){
				//if this is the first number , make it the currMedian and then add it to heap
				currMedian=num; 
			}


			//add to heap
			if(currMedian<num){

				//adding larger numbers to minheap
				minHeap.offer(num);
			}
			else {
				//if less or equal also we r adding to minheap

				//adding smaller numbers to maxheap
				maxHeap.offer(num); 
			}


			//balance the heaps
			//minheap should always has same or one more than max heap
			if(minHeap.size()<maxHeap.size()){
				// System.out.println("balancing..");
				minHeap.offer(maxHeap.poll());
			}
			else if (minHeap.size()-maxHeap.size()>1){
				// System.out.println("balancing max..");
				maxHeap.offer(minHeap.poll());
			}
		}

		public double findMedian() {

			if( maxHeap.size()==0 && minHeap.size()==0){
				return (double)-1;
			}

			else if(minHeap.size() > maxHeap.size()){
				//System.out.println("from minheap.."+minHeap.peek());
				return minHeap.peek();
			}
			else {
				//if same number of elemets then
				return (minHeap.peek()+maxHeap.peek())/2.0;
			}
		}
	}

	/**
	 * Your MedianFinder object will be instantiated and called as such:
	 * MedianFinder obj = new MedianFinder();
	 * obj.addNum(num);
	 * double param_2 = obj.findMedian();
	 */
}

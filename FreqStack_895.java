package topK_Elements;

import java.util.*;

public class FreqStack_895 {
	class FreqStack {
	    class Obj{
	        int element;
	        int freq;
	        int insertTime;//as we need to keep track of last insert orders so that when element os popped then we know we will have another obj with its own insertOrder and count if there are multiple instances of the same element inserted in the stack
	        // @Override
	        //     public boolean equals(Object o) {
	        //         if (this == o) return true;
	        //         if (o == null || getClass() != o.getClass()) return false;
	        //         Obj e = (Obj) o;
	        //         return Integer.compare(e.element, element) == 0;
	        // }
	        Obj(int e,int f,int i){
	            element=e;
	            freq=f;
	            insertTime=i;
	        }
	        
	    }
	    PriorityQueue<Obj> maxHeap;
	    Map<Integer,Integer> freqMap;
	    int insertTime;
	    public FreqStack() {
	        insertTime=0;
	        freqMap=new HashMap<>();
	        maxHeap=new PriorityQueue<>(new Comparator<Obj>(){
	            public int compare(Obj o1,Obj o2){
	                //first sort by freq
	                if(o1.freq>o2.freq){
	                    return -1;
	                }
	                //if same then sort by insert order
	                if(o1.freq==o2.freq){
	                    if(o1.insertTime>o2.insertTime){
	                        return -1;
	                    }
	                    else{
	                        return 1;
	                    }
	                }
	                else{
	                    //o1.freq<o2.freq
	                    return 1;
	                }
	            }
	        });
	        
	        
	    }
	    
	    public void push(int x) {
	        //push it to maxHeap
	        if(!freqMap.containsKey(x)){
	            freqMap.put(x,1);
	            maxHeap.offer(new Obj(x,1,insertTime++));
	        }
	         else{
	             int f=freqMap.get(x);
	             f++;
	             freqMap.put(x,f);
	             maxHeap.offer(new Obj(x,f,insertTime++));
	           }
	        
	    }
	    
	    public int pop() {
	        Obj top=maxHeap.poll();
	        int f=freqMap.get(top.element);
	         f--;
	         freqMap.put(top.element,f);
	        return top.element;
	    }
	}

	/**
	 * Your FreqStack object will be instantiated and called as such:
	 * FreqStack obj = new FreqStack();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 */
}

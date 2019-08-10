package topK_Elements;

import java.util.*;

public class ReorganizeStrDist_767 {
	class Solution {
	    class Obj{
	        int freq;
	        char cval;
	        Obj(int f,char c){
	            freq=f;
	            cval=c;
	        }
	    }
	    public String reorganizeString(String S) {
	        //make a max heap out of elements freq
	        int[] countArr=new int[26];
	        char[] charArr=S.toCharArray();
	        for(char c:charArr){
	            countArr[c-'a']++;
	        }
	        
	        //build a maxHeap of freq of elmenets 
	        PriorityQueue<Obj> maxHeap=new PriorityQueue<>(new Comparator<Obj>(){
	            public int compare(Obj o1,Obj o2){
	                if(o1.freq>o2.freq){
	                    return -1;
	                }
	                else{
	                    return 1;
	                }
	            }
	        });
	        
	        for(int i=0;i<countArr.length;i++){
	            //add to maxHeap
	            if(countArr[i]>0){
	                 maxHeap.offer(new Obj(countArr[i],(char)('a'+i)));
	            }
	           
	        }
	        
	        //if count of max element is more than N+1/2 then we cannot rarrange
	        
	         if(maxHeap.peek().freq>(S.length()+1)/2){
	            return "";
	        }
	        //get highest freq element and add it to string
	        StringBuilder output=new StringBuilder();
	        int n=0;
	        char[] outCharArray=new char[S.length()];
	        while(maxHeap.size()>=2){
	            //getting top 2 will ensure that we pick always distinct elements from queue and add to output
	            Obj top1=maxHeap.poll();
	             Obj top2=maxHeap.poll();
	            outCharArray[n]=top1.cval;
	            System.out.println(top1.cval);
	            n++;
	            outCharArray[n]=top2.cval;
	             System.out.println(top2.cval);
	            n++;
	            //add it back to heap if its not 0
	            if(top1.freq-1>0){
	                 maxHeap.offer(new Obj(top1.freq-1,top1.cval));
	            }
	            if(top2.freq-1>0){
	                 maxHeap.offer(new Obj(top2.freq-1,top2.cval));
	            }
	            System.out.println(maxHeap.size());
	        }
	        if(maxHeap.size()>0){
	            Obj top1=maxHeap.poll();
	           outCharArray[n]=top1.cval;
	            n++; 
	        }
	        return String.valueOf(outCharArray);
	    }
	}
}

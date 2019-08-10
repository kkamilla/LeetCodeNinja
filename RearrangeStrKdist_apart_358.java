package topK_Elements;

import java.util.*;

public class RearrangeStrKdist_apart_358 {
	class Obj{
		int freq;
		char cval;
		int next_index;
		Obj(int f,char c,int i){
			freq=f;
			cval=c;
			next_index=i;
		}
		//     @Override
		//        public boolean equals(Object o) {
		//            if (this == o) return true;
		//            if (o == null || getClass() != o.getClass()) return false;
		//            Obj e = (Obj) o;
		//            return Character.compare(e.cval, cval) == 0 ;
		//        }
	}

	public String rearrangeString(String s, int k) {

		//count occurance of the element
		int[] countArr=new int[26];
		char[] charArr=s.toCharArray();
		for(char c:charArr){
			countArr[c-'a']++;
		}

		//build a minheap of next possible index of the char and then maxHeap of freq if indexs are the same
		PriorityQueue<Obj> min_maxHeap=new PriorityQueue<>(new Comparator<Obj>(){
			public int compare(Obj o1,Obj o2){
				if(o1.next_index<o2.next_index){
					return -1;
				}
				if(o1.next_index==o2.next_index){
					if(o1.freq>o2.freq){
						return -1;
					}
					else{
						return 1;
					}

				}
				else{
					return 1;
				}
			}
		});
		//last index map for each char
		Map<Character, Integer> lastIndexMap=new HashMap<>();
		for(int i=0;i<countArr.length;i++){
			//add to maxHeap of first char with count>0 that we find
			if(countArr[i]>0)  {
				min_maxHeap.offer(new Obj(countArr[i],(char)('a'+i),0));

			}

		}

		//if count of max element is more than N+1/2 then we cannot rarrange

		if(min_maxHeap.peek().freq>(s.length()+1)/2 && k>1){
			return "";
		}
		//get highest freq element and add it to string
		StringBuilder output=new StringBuilder();
		int n=0;
		char[] outCharArray=new char[s.length()];


		while(min_maxHeap.size()>0){
			//we are going to loop thru heap and see if index of Obj is less than currIndex, then replace it with same element and freq but index=currIndex and add it back to heap so that if we compare it with a higher freq element with maybe index=currIndex already, we want to pick the element with more freq should be picked and added to str as max_freq_nextIndex<=currIndex

			Obj top1=min_maxHeap.poll();
			//if n<nextindex then we cannot put the element
			if(top1.next_index>=s.length()){
				//not possible to create such a str with k distnce apart as index+k>len of str
				return "";
			}

			//check if its <n
			while(top1.next_index<n){
				//min_maxHeap.remove(new Obj(-1,ob.cval,-1));
				// System.out.println("top1.cval="+top1.cval+" top1 index="+top1.next_index+" n="+n);
				min_maxHeap.offer(new Obj(top1.freq,top1.cval,n));
				top1=min_maxHeap.poll();
				//System.out.println("after top1.cval="+top1.cval+" top1 index="+top1.next_index+" n="+n);
			}


			outCharArray[n]=top1.cval;
			//System.out.println(top1.cval);


			//add it back to heap if its not 0
			top1.freq--;
			if(top1.freq>0){
				//System.out.println("remianing top1.cval="+top1.cval+" top1.freq="+top1.freq+" n="+(n+k));
				min_maxHeap.offer(new Obj(top1.freq,top1.cval,n+k));
			}
			n++;
			//System.out.println(min_maxHeap.size()+":"+String.valueOf(outCharArray));
		}

		//now heap size==0


		if(min_maxHeap.size()>0){
			Obj top1=min_maxHeap.poll();
			outCharArray[n]=top1.cval;
			n++; 
		}
		return String.valueOf(outCharArray);


	}

}

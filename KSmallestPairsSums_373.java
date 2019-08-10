package topK_Elements;


import java.util.*;

public class KSmallestPairsSums_373 {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> output=new ArrayList<>();
        if(nums1.length==0 || nums2.length==0){
            return output;
        }
        PriorityQueue<Obj> minHeap=new PriorityQueue<>(new Comparator<Obj>(){
            public int compare(Obj o1,Obj o2){
                if(o1.sum<o2.sum){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        });
        //add first item from each array to heap
        minHeap.offer(new Obj(0,0,nums1[0]+nums2[0]));
        while(k>0 && minHeap.size()!=0){
            //remove from heap and add to output
           Obj top= minHeap.poll();
            List<Integer> list=new ArrayList<Integer>();
            list.add(nums1[top.nums1_index]);
            list.add(nums2[top.nums2_index]);
            output.add(list);
            k--;
            //add next values in the num2 index row for the same value of num1 index that we got from top
            if(top.nums2_index+1<nums2.length){
                //add next possible candidate, the immediate next pair formed with same value of nums1 array eleemnt as top
                minHeap.offer(new Obj(top.nums1_index,top.nums2_index+1,nums1[top.nums1_index]+nums2[top.nums2_index+1]));
            }
            
            //add next possible candidate, the immediate next pair formed with 0th value of nums2 array eleemnt and next value in nums1 array
            if(top.nums2_index==0 && top.nums1_index+1<nums1.length){
                 
                //imagine num1 as rows of a matrix and nums2 as columns of a matrix
                //then first we priocess the first row -->nums1[0] & nums2[0 to len] bbut we add only 1 element at a time
                //then we add first column for nums2[0] and next row of nums1[top+1] as next candidate
                minHeap.offer(new Obj(top.nums1_index+1,0,nums1[top.nums1_index+1]+nums2[0]));
            }
            
            //next round when loop begins again, it can compare these 2 candidates that we just addded and get the min of these 2 sums and add to output
            
        }
        
        return output;
        
    }
	class Obj{
        int nums1_index; 
        int nums2_index;
        int sum;
        public Obj(int i, int j, int val){
            this.nums1_index = i;
            this.nums2_index = j;
            this.sum = val;
        }
    }
}

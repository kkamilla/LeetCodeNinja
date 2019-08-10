package topK_Elements;

import java.util.Random;

public class KthLargestElement_215 {
	class Solution {
	    public int findKthLargest(int[] nums, int k) {
	        int kthSmallest=nums.length-k;
	        return findKthLargest(nums,  kthSmallest,0,nums.length-1); 
	        
	    }
	    
	    public int findKthLargest(int[] nums, int k,int start,int end) {
	        //partition around pivot
	        Random rand=new Random();
	        //to generate a random number between start and end index
	        //minimum + rn.nextInt(maxValue - minvalue + 1)
	        int pivotIndex=start+rand.nextInt(end-start+1);
	        int finalPos=partition(nums, start, end, pivotIndex);
	        
	        if(k==finalPos){
	            return nums[finalPos];
	        }
	        else if(k>finalPos){
	            //only partition right half
	        	//If that would be a quicksort algorithm, one would proceed recursively to use 
	        	//quicksort for the both parts that would result in O(NlogN) time complexity. 
	        	//Here there is no need to deal with both parts since now one knows in which part to search 
	        	//for N - kth smallest element, and that reduces average time complexity to O(N).
	            return findKthLargest(nums,k, finalPos+1, end);
	        }
	        else{
	             return findKthLargest(nums,k, start,finalPos-1);
	        }
	        
	    }
	    void swap(int from,int to,int[] arr){
	        int temp=arr[from];
	        arr[from]=arr[to];
	        arr[to]=temp;
	        return;
	    }
	    int partition(int[] arr,int start,int end,int pivotIndex){
	        //partition around pivotIndex
	        //move pivot element to end
	        swap(end,pivotIndex,arr);
	        int finalPos=start;
	        for(int i=start;i<end;i++){
	            if(arr[i]<arr[end]){
	                //swap it with finalPos
	                swap(finalPos,i,arr);
	                finalPos++;
	                
	            }
	            else{
	                //don't do anything so that finalPos is pointing to the greater element here and we can later swap with a smaller lement if we find one, else we just swap it with the end element which is our pivot Index element
	                
	            }
	        }
	        
	        //swap
	        swap(end,finalPos,arr);
	        return finalPos;
	        
	    }
	}
}

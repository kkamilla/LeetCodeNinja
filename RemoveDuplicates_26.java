package twoPointer;

public class RemoveDuplicates_26 {
	/*
	 * Since the array is already sorted, we can keep two pointers i and j, where i is the slow-runner while j is the fast-runner. 
	 * As long as nums[i] == nums[j], we increment j to skip the duplicate.

When we encounter nums[j] not same as nums[i], the duplicate run has ended so we must copy its value to nums[i + 1].  
i is then incremented and we repeat the same process again until j reaches the end of array.
	 * 
	 * */
	    public int removeDuplicates(int[] nums) {
	        //pointerToOverwrite
	        if(nums.length==0 ){
	            return 0;
	        }
	        if(nums.length==1 ){
	            return 1;
	        }
	        int duplicateIndex=0;
	       // int start=0;
	        for(int next=1;next<nums.length;next++){
	            //when both are not same we copy over to duplicateindex and move it ahead, else we move next index ahead and go forward in next index in for loop until both indexs values are not same
	            if(nums[next]!=nums[duplicateIndex]){
	                //as duplicate index contains previous elemnt which was same, we need to copy the next index element to duplicate index+1 
	                duplicateIndex=duplicateIndex+1;
	                //copy next to start+1
	                nums[duplicateIndex]=nums[next];
	            }    
	        }
	        
	        //total lenght of new array to be returned
	            return duplicateIndex+1;
	    }
	    public int removeDuplicates_while(int[] nums) {
	        //pointerToOverwrite
	        if(nums.length==0 ){
	            return 0;
	        }
	        if(nums.length==1 ){
	            return 1;
	        }
	        int duplicateIndex=0;
	       // int start=0;
	        int next=1;
	        while(next<nums.length){
	            //when both are not same we copy over to duplicateindex and move it ahead, else we move next index ahead and go forward in next index in for loop until both indexs values are not same
	            if(nums[next]!=nums[duplicateIndex]){
	                //as duplicate index contains previous elemnt which was same, we need to copy the next index element to duplicate index+1 
	                duplicateIndex=duplicateIndex+1;
	                //copy next to start+1
	                nums[duplicateIndex]=nums[next];
	                next++;
	            }
	            else {
	            	next++;
	            }
	            
	        }
	        //totoal lenght of new array to be returned
	            return duplicateIndex+1;
	    }
	
}

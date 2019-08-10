package binarysearch_modified;

import java.util.Arrays;

public class KthSmallestDiffPair_719 {
	public int smallestDistancePair(int[] nums, int k) {
        //sort the array so that we can find the max difffernce and min difference possible between elements
        Arrays.sort(nums);
        int minPossibleDiff=0;
        int maxPossibleDiff=nums[nums.length-1]-nums[0];
        while(minPossibleDiff<maxPossibleDiff){
            int midDiff=(minPossibleDiff+maxPossibleDiff)/2;
            //find number of elements in array starting from left=0 which have a diff <=midDiff, so that we can eliminate one half of the array
            int left=0,count=0;
            for(int right=0;right<nums.length;right++){
                //check if the diff is >midDiff, if so move left forward until we find a point where diff<=midDiff
                while(nums[right]-nums[left]>midDiff){
                    left++;//these are numbers that we need to skip to get a diff<=middiff
                }
                count+=right-left;//number of pairs whose diff is less rthan or equal to mid
            }
            //count = number of pairs with distance <= mi
            if(count>=k){
                maxPossibleDiff=midDiff;
            }
            else{
                minPossibleDiff=midDiff+1;
            }
        }
        // `lo` ends up being an actual distance in the input, because
         //the binary search mechanism waits until the exact lo/hi combo where
        //2nd to last `mid` did not produce enough results (k or more), but
       // the last `mid` did.
        return minPossibleDiff;
    }
}

package recursion_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutaionDuplicates_swapping {
	class Solution {
		public List<List<Integer>> permuteUnique(int[] nums) {
			//fix current position eleemnt and  passon the next index as thee start pf the array of elements whose positin you have not fixed yet
			//after my child returns from recursive call , it restores the array as it was given to it without messing up the order, so that i know which element has not got a chance to be at positon current and i give that element next chance by fixing it as pos=current and passing on the rest to my child call
			// Arrays.sort(nums);  

			List<List<Integer>> res=new ArrayList<>();
			permuteRecur(nums,0,res);
			return res;

		}
		boolean shouldSwap(int str[], int start, int curr) { 
			for (int i = start; i < curr; i++) { 
				if (str[i] == str[curr]) { 
					return false; 
				} 
			} 
			return true; 
		}
		void permuteRecur(int[] nums,int startIndex,List<List<Integer>> res){
			if(startIndex==nums.length){
				//copy content of the array to a list and add it to res
				List<Integer> temp=new ArrayList<>();
				for(int s:nums){
					temp.add(s);
				}
				res.add(temp);
			}
			//try all eleents by fixng each at pos=strart by swap
			for(int i=startIndex;i<nums.length;i++){
				//swap startindex with i index
				//before swapping we check if we have already processed some element between startIndex to i-1 which
				//would have produced the same set of permuations as the element at index i, so we don't want o bring
				//ith element to startIndex position as this will yeild same sets of permuatiaon as this element which is same as ith element.
				if(shouldSwap(nums,startIndex,i)){

					//if(i>0 && nums[startIndex]!=nums[i]){
					swap(startIndex,i,nums);
					//call assistanrt after element at startindex is fixed
					permuteRecur(nums, startIndex+1, res);

					//undo the swap as we have to return the array as it is we got from our parent
					swap(startIndex,i,nums);

				}
			}
		}

		void swap(int i,int j,int[]nums){
			int temp=nums[i];
			nums[i]=nums[j];
			nums[j]=temp;
		}
	}

}

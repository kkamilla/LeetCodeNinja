package binarysearch_modified;

import java.util.Random;

public class PickRandomWeighted_528 {
	class Solution {
		int[] prefixSum;
		Random rand;
		int sum=0;
		public Solution(int[] w) {
			rand=new Random();
			//create this array with weights 


			//find prefix sum for all values in w[i]
			prefixSum=new int[w.length];
			for(int i=0;i<w.length;i++){
				sum+=w[i];
				prefixSum[i]=sum;
			}
			//works but time limit exceeded for 2 test cases, 55/57 tests passed
			// pickArray=new int[sum];
			// int index=0;
			// for(int i=0;i<w.length;i++){
			//     //put index i in pickArray as many times as value in w[i]
			//     for(int k=index;k<index+w[i];k++){
			//         pickArray[k]=i;
			//     }
			//     index=index+w[i];
			// }

		}

		public int pickIndex() {

			int picked_random=rand.nextInt(sum);
			//whatever index was picked, try to find out the owner of that region by binary search and prefix sum array as there will be as many prefix sums as the index of elements in weight array
			//To my understanding, I think the core trick of this solution is to "translate and map" the individual weight of each index to a certain "region" in [0, tot) where sizes of mapped region are actually proportional to weight of each index.
			//For example, suppose the given input is [1, 3, 1, 5], by using the idea of prefix sum, we will "map" weights to [1, 4, 6, 10], where [0, 1) region belongs to index 0, [1,4) region belong to 1 ... etc. As we can see, the size of region that each index get is proportional to its weight. Then we only need to randomly generate a value in range [0, 10) and use binary search to determine which region it falls upon so that we can tell that the "owner" of that region is the index we want to return.
			int left=0;
			int right=prefixSum.length-1;
			while(left!=right){
				int mid=(left+right)/2;
				if(picked_random>=prefixSum[mid]){
					left=mid+1;
				}
				else{
					//if picked_random<prefix[mid]
					
					right=mid;// if picked_random<prefix[mid] then mid might be the index 
					//that we are looking for, so we cannot set right to mid-1, but we need to set it to mid , so that we still have mid as one of the possible indexes

				}
			}
			return left;
		}
	}

	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(w);
	 * int param_1 = obj.pickIndex();
	 */
}

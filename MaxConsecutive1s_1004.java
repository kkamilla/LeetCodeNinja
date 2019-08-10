package grokking_2slidingwindow;

public class MaxConsecutive1s_1004 {
	public int longestOnes(int[] A, int K) {
        int windowStart=0;
        //11100
        int[] countArray=new int[2];
        
        int max_length=0;
        
        for(int windowEnd=0;windowEnd<A.length;windowEnd++){
            if(A[windowEnd]==1){
               countArray[1]++; 
            }
            else{
                countArray[0]++;
            }
            while(countArray[0]>K){
                //if number of 0s collected>K then we slide the window to remove 0's
                if(A[windowStart]==0){
                    countArray[0]--;
                    windowStart++;
                }
                else{
                    //if it is one in windowStart then ove it until windowstart points to 0
                    while(A[windowStart]!=0){
                        countArray[1]--; 
                        windowStart++;
                    }
                }
            }
            //when countArray[0]==k
            max_length=Math.max(max_length,windowEnd-windowStart+1);
        }
        
        return max_length;
    }
}

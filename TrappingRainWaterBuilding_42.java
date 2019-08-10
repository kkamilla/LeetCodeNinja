package twoPointer;

public class TrappingRainWaterBuilding_42 {
	class Solution {
	    public int trap(int[] height) {
	        if(height.length==0){
	            return 0;
	        }
	         //find max height until index i , not including i from left
	        int[] maxLeft=new int[height.length];
	        int maxL=-1;
	        int maxIndex=-1;
	        maxLeft[0]=-1;//as there is no building to left of first building
	        for(int left=0;left<height.length-1;left++){
	            if(maxL<height[left]){
	                //we fill left+1 index as we are keeping track of max building height until left index only not left+1
	                 maxLeft[left+1]=left;
	                maxIndex=left;
	                maxL=height[left];
	                }
	            else{
	                maxLeft[left+1]=maxIndex;
	            }
	           System.out.print(maxLeft[left]);
	        }
	        System.out.println(", left done");
	        int[] maxRight=new int[height.length];
	        int maxR=-1;
	        int maxIndexR=-1;
	        maxRight[height.length-1]=-1;//as there is no building to right of last building
	        for(int right=height.length-1;right>0;right--){
	            if(maxR<height[right]){
	                maxRight[right-1]=right;
	                maxIndexR=right;
	                maxR=height[right];
	            }
	            else{
	                maxRight[right-1]=maxIndexR;
	            }
	            System.out.print(maxRight[right]);
	        }
	        
	       System.out.println(", reverse right done");
	        int maxWater=0;
	         
	        for(int i=0;i<height.length;i++){
	            int h_min=Math.min(maxRight[i]==-1?0:height[maxRight[i]],maxLeft[i]==-1?0:height[maxLeft[i]]);
	             System.out.println("i="+i);
	            System.out.println("h_min="+h_min);
	            int currWater=0;
	            if(h_min<height[i]){
	                currWater=0;
	            }
	            else{
	                currWater=h_min-height[i];
	                System.out.println("height[i]="+height[i]);
	                System.out.println(currWater);
	            }
	            maxWater+=currWater;
	            System.out.println("max="+maxWater);
	        }
	        return maxWater;
	    }
	}
}

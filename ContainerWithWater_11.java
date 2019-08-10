package twoPointer;

public class ContainerWithWater_11 {
public int maxArea(int[] height) {
        
        int max=-1;
        int left=0;
        int right=height.length-1;
        
        while(left<right){
            int area=Math.min(height[left],height[right])*(right-left);
            if(max<area){
                 max=area;
                }
            if(height[left]<height[right]){
                //search for bigger height forward to increase the area
                left++;
            }
            else {
                //search for bigger hright towrads left to increase the area
                right--;
            }
           
        }
        
        return max;
    }
}

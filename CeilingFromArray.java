package binarysearch_modified;

public class CeilingFromArray {
	public static int ceilSearch(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int ceil_index=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
            	ceil_index=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ceil_index;
    }
	
	public static void main (String[] args) 
    { 
       int arr[] = {1, 2, 8, 10, 10, 12, 19}; 
       int n = arr.length; 
       int x = 20; 
       int index = ceilSearch(arr, x); 
       if(index == -1) 
         System.out.println("Ceiling of "+x+" doesn't exist in array"); 
       else 
         System.out.println("ceiling of "+x+" is "+arr[index]); 
    } 
}

package twoPointer;

public class BadVersion {
	//my solution
	public int firstBadVersion_logN(int n) {
	       return firstBadVersion_rec(0,n);
	    }
	    
	 int firstBadVersion_rec(int start,int end){
	        int min=-1;
	        while(start<=end){
	            //to avoid overflow errrors, do
	            int mid=(start)+(end-start)/2;
	          if(isBadVersion(mid) && isBadVersion(mid-1) ){
	                min=mid-1;
	                //go left
	                end=mid-1;
	            }
	            else if(isBadVersion(mid) && !isBadVersion(mid-1)){
	                min=mid;
	                break;
	            }
	            else{
	                //go right
	                start=mid+1;
	            }
	        }
	        return min;
	        
	    }
	

	
	
	public int firstBadVersion(int n) {
	    int left = 1;
	    int right = n;
	    while (left < right) {
	        int mid = left + (right - left) / 2;
	        if (isBadVersion(mid)) {
	            right = mid;
	        } else {
	            left = mid + 1;
	        }
	    }
	    return left;
	}
	
}

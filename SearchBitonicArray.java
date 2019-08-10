package binarysearch_modified;

public class SearchBitonicArray {
	
	//find the index of the largest number in array,until which the array is increasing and  after which the array is decreasing
	static int findBitonicPoint(int arr[], int left, int right) { 
		int mid=(left+right)/2;
		if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) {
			return mid;
		}
		else {
			//if mid-1<mid<mid+1, then go right
			if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1]) {
				
				return findBitonicPoint( arr,  mid,  right);
				
			}
			//if mid-1
			else if(arr[mid]<arr[mid-1] && arr[mid]>arr[mid+1]) {
				return findBitonicPoint( arr,  left,  mid);
			}
		}
		return -1;
	}
	
	static int ascendingBinarySearch(int arr[], int low,  int high, int key) { 
        while (low <= high) { 
            int mid = low + (high - low) / 2; 
            if (arr[mid] == key) { 
                return mid; 
            } 
            if (arr[mid] > key) { 
                high = mid - 1; 
            } else { 
                low = mid + 1; 
            } 
        } 
        return -1; 
    }
	
	
	static int decendingBinarySearch(int arr[], int low,  int high, int key) { 
        while (low <= high) { 
            int mid = low + (high - low) / 2; 
            if (arr[mid] == key) { 
                return mid; 
            } 
            if (arr[mid] < key) { 
                high = mid - 1; 
            } else { 
                low = mid + 1; 
            } 
        } 
        return -1; 
    }
	
	
	
	static int searchBitonic(int arr[], int key, int bitonic_index) {
		if(key==arr[bitonic_index]) {
			return bitonic_index;
		}
		else {
			//check if key>bitonic_index eleent then it does not exist
			if(key>arr[bitonic_index]) {
				return -1;
			}
			else {
				
				//it can be left
				
				int x=ascendingBinarySearch(arr,  0,   bitonic_index-1,  key) ;
				//it can be right side
				int y=decendingBinarySearch(arr,  bitonic_index+1,   arr.length,  key);
				if(x!=-1) {
					return x;
				}
				else {
					return y;
				}
			}
		}
	}
	
	
	public static void main(String args[]) { 
        int arr[] = {-8, 1, 2, 3, 4, 5, -2, -3}; 
        int key = -2; 
        int n, l, r; 
        n = arr.length; 
        l = 0; 
        r = n - 1; 
        int index; 
        index = findBitonicPoint(arr, l, r); 
  
        int x = searchBitonic(arr, key, index); 
  
        if (x == -1) { 
            System.out.println("Element Not Found"); 
        } else { 
            System.out.println("Element Found at index " + x); 
        } 
  
    }
}

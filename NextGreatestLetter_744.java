package binarysearch_modified;

public class NextGreatestLetter_744 {
	public char nextGreatestLetter(char[] letters, char target) {
        int left=0;
        int right=letters.length-1;
        char ceil=letters[0];
        while(left<=right){
            int mid=(left+right)/2;
            if(letters[mid]==target ){
                if(mid+1<=letters.length-1 && letters[mid+1]>target){
                    //we found the next largest char
                    return letters[mid+1];
                }
                else if(mid+1<=letters.length-1 && letters[mid+1]==target){
                    //we need to keep searching as target is repeating [e,e,e,e,e,e,n,n,n]
                    left=mid+1;;
                }
                else {
                	//round to position 0
                    return letters[(mid+1)%letters.length];
                }
                
            }
            else if(letters[mid]>target){
            	ceil=letters[mid];
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ceil;
    }
}

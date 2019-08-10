package dp_palindromicSubsequence;

public class MinDeletionsPalindrom_680 {
	
	//greedy approch-O(N)
public boolean validPalindrome(String s) {
        
        for(int start=0;start<s.length()/2;start++){
          int end=s.length()-1-start;
            if(s.charAt(start)!=s.charAt(end)){
                //try skipping ith char
               boolean x= skip(start+1,end,s);
                
                //try skipping jth char
               boolean y= skip(start,end-1,s);
                return x||y;
            }
          
      }
        //all start ,end are same then we reach here
        return true;
    }
    
    boolean skip(int i,int j,String s){
        String compStr=s.substring(i,j+1);
        //if any more chars are not same from i to j then we retrun false, as we entered this function with 1 mismatch already
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

package slowFastPointers;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {
	class Solution {
	    int getSquareSum(int n){
	        int sum=0;
	        while(n>0){
	                int digit=n%10;
	                sum+=digit*digit;
	                n=n/10;
	                //System.out.println(sum);
	        
	            }
	        return sum;
	    }
	    
	    public boolean isHappy(int n) {
	        int digit=0;
	        int sum=0;
	       int slow=0;
	        int fast=0;
	        
	        slow=n;
	        fast=n;
	        //do it once and then go to while loop
	        do{
	           slow= getSquareSum(slow);
	            fast=getSquareSum(getSquareSum(fast));
	            
	        }while(slow!=fast);
	        //if after while loop, sum=1
	        if(slow==1){
	            return true;
	        }
	        return false;
	    }
	    public boolean isHappy_extraSpace(int n) {
	        int digit=0;
	        int sum=0;
	        int given_num=n;
	        int step=0;
	        Set<Integer> seen=new HashSet<>();
	        seen.add(n);
	        //seen.add returns true only if its not 
	        while(sum!=1 ){
	            while(n>0){
	                digit=n%10;
	                sum+=digit*digit;
	                n=n/10;
	                System.out.println(sum);
	        
	            }
	            if(sum!=1 && !seen.contains(sum)){
	                seen.add(sum);
	                n=sum;
	                //reset sum
	                System.out.println("reset="+sum);
	                sum=0;
	            }
	            if(sum!=1 && seen.contains(sum)){
	                break;//cycle here as same sum is coming again and again
	            }
	            
	            if(sum==1){
	                break;
	            }
	           
	        }
	        //if after while loop, sum=1
	        if(sum==1){
	            return true;
	        }
	        return false;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

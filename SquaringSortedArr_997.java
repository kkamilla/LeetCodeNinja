package twoPointer;

public class SquaringSortedArr_997 {
	class Solution {
	    public int[] sortedSquares(int[] A) {
	        int negetiveIndexEnd=0;
	        int positiveIndex=0;
	        while(negetiveIndexEnd<A.length && A[negetiveIndexEnd]<0){
	            negetiveIndexEnd++;
	            
	        }
	        positiveIndex=negetiveIndexEnd;
	        negetiveIndexEnd--;
	        int[] res=new int[A.length];
	        int k=0;
	        while(negetiveIndexEnd>=0 && positiveIndex<A.length){
	            if(A[negetiveIndexEnd]*A[negetiveIndexEnd]>A[positiveIndex]*A[positiveIndex]){
	                res[k]=A[positiveIndex]*A[positiveIndex];
	                positiveIndex++;
	                k++;
	            }
	            else{
	                res[k]=A[negetiveIndexEnd]*A[negetiveIndexEnd];
	                negetiveIndexEnd--;
	                k++;
	            }
	        }
	        while(negetiveIndexEnd>=0){
	            res[k]=A[negetiveIndexEnd]*A[negetiveIndexEnd];
	                negetiveIndexEnd--;
	                k++;
	        }
	        while(positiveIndex<A.length){
	            res[k]=A[positiveIndex]*A[positiveIndex];
	                positiveIndex++;
	                k++;
	        }
	        return res;
	    }
	}
}

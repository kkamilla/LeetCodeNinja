package calculators;

import java.util.Stack;
/*
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces 
 * . The integer division should truncate toward zero.
 * 
 * */
public class calculator2_227 {
	class Solution {
	    public int calculate(String s) {
	        Stack<Integer> numberStack=new Stack<>();
	        int num=0;
	        char sign='+';
	        for(int i=0;i<s.length();i++){
	             System.out.println("s.charAt(i)="+s.charAt(i));
	            if(i<s.length() && ' '==s.charAt(i)){
	                continue;
	            }
	            while(i<s.length() && Character.isDigit(s.charAt(i))){
	                num=num*10+(s.charAt(i)-'0');
	                i++;//go to the next i as number is going on and has not ended yet
	            }
	            
	             //this part has to be executed even when we  have reached the end of the string
	            
	            if(sign=='+'){
	                numberStack.push(num);
	            }
	             if(sign=='-'){
	                numberStack.push(-num);
	            }
	             if(sign=='*'){
	                //pop from stack and multiply with num content and push on stack
	                int op1=numberStack.pop();
	                System.out.println("op1="+op1);
	                numberStack.push(op1*num);
	            }
	             if(sign=='/'){
	                //pop from stack and multiply with num content and push on stack
	                 int op2=numberStack.pop();
	                System.out.println("op2="+op2);
	                numberStack.push(op2/num);
	            }
	                //assign the current sign to be used for next round if we have not reached the end of the string
	             //at end of each loop this has to run so that we assign the ith position opeartor to sign after 
	             //we are done with while loop to get the number
	            if(i<s.length() ){
	               System.out.println("insie s.charAt(i)="+s.charAt(i));
	                sign=s.charAt(i);
	                num=0;  
	            }
	         
	        }
	        
	        //at the end stack will only have numbers with +ve or -ve signs in front of them, as all * and / has been evaluated and pushed on stack
	        
	        int res=0;
	        while(!numberStack.isEmpty()){
	            int op1=numberStack.pop();
	                    System.out.println("res op1="+op1);
	            res+=op1;
	        }
	        return res;
	        
	        
	    }
	}
}

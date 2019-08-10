package calculators;

import java.util.Stack;
/*
 * The expression string may contain open ( and closing parentheses ), 
 * the  + or  -, non-negative integers and empty spaces .
 * 
 * 
 * */
public class calculator1_224 {
	class Solution {
	    public int calculate(String s) {
	        int len = s.length();
	        int sign = 1;
	        int result = 0;
	        //put the last evaluated numebr to stack
		    Stack<Integer> stack = new Stack<Integer>();
		    for (int i = 0; i < len; i++) {
			    if (Character.isDigit(s.charAt(i))) {
				    int sum = s.charAt(i) - '0';
	                //while its still a number , take all chars so that u get the whole number
	                while(i+1<len && Character.isDigit(s.charAt(i+1))){
	                    sum=sum*10+s.charAt(i+1) - '0';
	                    i++;
	                }
	            //add to result from prevoius loop value
	            result+=sum*sign;
	            }
	            else if(s.charAt(i) =='+'){
	                sign=1;
	            }
	            else if(s.charAt(i) =='-'){
	                sign=-1;
	            }
	            else if(s.charAt(i) =='('){
	               //push result ontp stack
	                stack.push(result);
	                stack.push(sign);
	                //reset these for next loop continuing
	                result=0;
	                sign=1;
	            }
	            else if(s.charAt(i) ==')'){
	                //get last number and sign from stack which was pushed at start of the bracket
	                int sign_fromStack=stack.pop();
	                int last_numfromStack=stack.pop();
	                result=result*sign_fromStack+last_numfromStack;
	                //no need to put it on stack as its closing bracket, so next char number can be added to result directly
	            }
	        }
	        return result;
	    }
	}
}

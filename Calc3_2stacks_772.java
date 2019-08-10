package calculators;

public class Calc3_2stacks_772 {
	//one test case failing
	// exp=   1-(-7)
	class Solution {
	    public int calculate(String s) {
	         if(s == null || s.length() == 0) return 0;
	        Stack<Character> opStack = new Stack<>();
	        Stack<Integer> numStack=new Stack<>();
	        Map<Character,Integer> priority=new HashMap<>();
	        priority.put('+',1);
	        priority.put('-',1);
	        priority.put('*',2);
	        priority.put('/',2);
	        priority.put('(',0);
	        priority.put(')',0);
	       
	        
	        int num=0;
	 
	        for(int i=0;i<s.length();i++){
	             System.out.println("s.charAt(i)="+s.charAt(i));
	           
	             if(Character.isDigit(s.charAt(i))){
	                num=0;
	                while(i<s.length() && Character.isDigit(s.charAt(i))){
	                    num=num*10+(s.charAt(i)-'0');
	                    i++;//go to the next i as number is going on and has not ended yet
	                }
	                System.out.println("num="+num);
	                numStack.push(num); 
	                //now the next i has not been evalauted, so i-- so that ithe char gets evalauted
	                i--;
	            }
	            
	            
	            //this is for character other than numbers
	            
	           else  if(s.charAt(i)=='+'||s.charAt(i)=='-' ||s.charAt(i)=='*' ||s.charAt(i)=='/'){
	                //check if operator stack has higher or equal priority opeartor on top, if so calculate those and push back on stack, until we find an operator of lower priority  on stack to curr operator,a nd then we push surrebt operator on the op stack
	                while(!opStack.isEmpty() && priority.get(opStack.peek())>=priority.get(s.charAt(i))){
	                    if(numStack.size()>=2){
	                       int val=getValue(numStack.pop(),numStack.pop(),opStack.pop());
	                        System.out.println("priority val="+val); 
	                        numStack.push(val);
	                    }
	                    else{
	                        //this is for uninary opeartors like -7+(8*9)
	                       int val=getValue(numStack.pop(),0,opStack.pop());
	                        System.out.println("uni val="+val); 
	                        numStack.push(val);
	                    }
	                     
	                    
	                }
	                //at the end push currenrt lower priopty opeartor on sstack
	                opStack.push(s.charAt(i));
	            }
	            else if( s.charAt(i)=='(' ){
	                 opStack.push(s.charAt(i));
	            }
	           else  if( s.charAt(i)==')'){
	                while(opStack.peek()!='('){
	                    if(numStack.size()>=2){
	                       int val=getValue(numStack.pop(),numStack.pop(),opStack.pop());
	                        System.out.println("priority val="+val); 
	                        numStack.push(val);
	                    }
	                    else{
	                        //this is for uninary opeartors like -7+(8*9)
	                       int val=getValue(numStack.pop(),0,opStack.pop());
	                        System.out.println("unary val="+val); 
	                        numStack.push(val);
	                    }
	                }
	                
	                //now its (, so pop from operator stack
	                opStack.pop();
	            }
	             else if(' '==s.charAt(i)){
	                continue;
	            }
	           
	         }  
	        
	        
	        
	        while(!opStack.isEmpty()){
	            if(numStack.size()>=2){
	                
	                       int val=getValue(numStack.pop(),numStack.pop(),opStack.pop());
	                        System.out.println("priority val="+val); 
	                        numStack.push(val);
	                    }
	                    else{
	                        //this is for uninary opeartors like -7+(8*9)
	                       int val=getValue(numStack.pop(),0,opStack.pop());
	                        System.out.println("priority val="+val); 
	                        numStack.push(val);
	                    }
	        }
	        return numStack.pop();
	    
	    }
	    
	    int getValue(int second_num,int first_num,char sign){
	        System.out.println("first_num="+first_num);
	        System.out.println("2nd="+second_num);
	        int result=0;
	        if(sign=='+'){
	            return first_num+second_num;
	        }
	         if(sign=='-'){
	             return first_num-second_num;
	        }
	         if(sign=='*'){ 
	            return first_num*second_num;

	        }
	         if(sign=='/'){
	             return first_num/second_num;
	        }
	       return 0;  
	    }
	}
}

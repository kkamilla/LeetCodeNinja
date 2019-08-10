package recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

public class AddOperatorExpression_282 {
	class Solution {
		public List<String> addOperators(String num, int target) {
			List<String> res =new ArrayList<>();
			List<String> currExp =new ArrayList<>();
			addOperators( num,  target, 0, currExp,0, 0,res);
			return res;
		}

		public void addOperators(String num, int target,long expValue,List<String> currExp, int currIndex,long prevOperand,List<String> res)
		{

			if(expValue==target && currIndex==num.length()){
				System.out.println(currExp);
				StringBuilder sb = new StringBuilder();
				for(String k:currExp){
					sb.append(k); 
				}
				res.add(sb.toString());
				return;
			}


			if( currIndex==num.length()){

				return;
			}

			else{
				//try all options
				//create numbers of size 1 ,2,3,....until len of given string
				for(int end=currIndex;end<num.length();end++){
					// Extending the current operand by one digit

					String currNum=num.substring(currIndex,end+1);
					System.out.println(currNum);
					//to avoid any 0's in the front of the number formed
					if(currNum.length()>1 && currNum.substring(0,1).equals("0")){
						break;
					}

					//add a noop , no operator, just extending the currNum
					if(currExp.size()==0){
						currExp.add(currNum);
						addOperators( num,  target, Long.parseLong(currNum), currExp,  end+1,Long.parseLong(currNum),res);
						currExp.remove(currExp.size()-1);
					}

					//add opeartors only after the first number is added to currExp, not like:["+1","*1","*1+2*3"]
					if(currExp.size()>0){
						//add a + opeartor
						currExp.add("+");
						currExp.add(currNum);
						addOperators( num,  target, expValue+ Long.parseLong(currNum), currExp,  end+1,  Long.parseLong(currNum),res);
						currExp.remove(currExp.size()-1);
						currExp.remove(currExp.size()-1);



						//add a - opeartor
						currExp.add("-");
						currExp.add(currNum);
						addOperators( num,  target, expValue- Long.parseLong(currNum), currExp,  end+1, -Long.parseLong(currNum),res);
						currExp.remove(currExp.size()-1);
						currExp.remove(currExp.size()-1);



						//add a * opeartor
						currExp.add("*");
						currExp.add(currNum);
						addOperators( num,  target, expValue-prevOperand+prevOperand*Long.parseLong(currNum), currExp,  end+1,prevOperand*Long.parseLong(currNum),res);
						currExp.remove(currExp.size()-1);
						currExp.remove(currExp.size()-1);
					}


				}

			}

		}


		//using string as currExp so that a new copy of string is made everytime and we don't need to explicity 
		//add a remove elements from the currExp as its passed by value and not by reference as List<String> in the above method 
		public void addOperators(String num, int target,long expValue,String currExp, int currIndex,long prevOperand,List<String> res)
		{

			if(expValue==target && currIndex==num.length()){
				System.out.println(currExp);
				res.add(currExp);
				return;
			}
			if( currIndex==num.length()){

				return;
			}

			else{
				//try all options
				//create numebrs of size 1 ,2,3,....until len of given string
				for(int end=currIndex;end<num.length();end++){
					// Extending the current operand by one digit

					String currNum=num.substring(currIndex,end+1);
					System.out.println(currNum);
					//to avoid any 0's in the front of the number formed
					if(currNum.length()>1 && currNum.substring(0,1).equals("0")){
						break;
					}

					//add a noop , no operator, just extending the currNum
					if(currExp.length()==0){
						// currExp.add(currNum);
						addOperators( num,  target, Long.parseLong(currNum), currNum,  end+1,Long.parseLong(currNum),res);
						//currExp.remove(currExp.size()-1);
					}

					//add opeartors only after the first number is added to expression, not like:["+1+2+3","+1*2*3","*1+2*3"]
					if(currExp.length()>0){
						//add a + opeartor

						addOperators( num,  target, expValue+ Long.parseLong(currNum), currExp+"+"+currNum,  end+1,  Long.parseLong(currNum),res);




						//add a - opeartor

						addOperators( num,  target, expValue- Long.parseLong(currNum), currExp+"-"+currNum,  end+1, -Long.parseLong(currNum),res);



						//add a * opeartor

						addOperators( num,  target, expValue-prevOperand+prevOperand*Long.parseLong(currNum), currExp+"*"+currNum,  end+1,prevOperand*Long.parseLong(currNum),res);

					}


				}

			}

		}
	}
}

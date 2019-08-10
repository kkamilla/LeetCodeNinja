package calculators;

import java.util.Stack;

public class Calc3_recursive_772 {
	class Solution {
	    public int calculate(String s) {
	        int num = 0, res = 0, i=0;
	        char sign = '+';
	        Stack<Integer> st = new Stack();
	        while(i<=s.length()){
	            // <= rather than = so as not to skip the last number
	            char ch = i==s.length()? '+': s.charAt(i);
	            i ++;
	            if(ch == ' ') continue;
	            if(ch<='9'&&ch>='0'){
	                num = 10*num+(ch-'0');
	            }else{
	                if(ch=='('){
	                    // once detect the ( find the matched ) and recursive result as num
	                    int left = 1;
	                    int end = i;
	                    while(left!=0){
	                        if(s.charAt(end)=='(') left++;
	                        if(s.charAt(end)==')') left--;
	                        end ++;
	                    }
	                    num = calculate(s.substring(i, end-1));
	                    // do not forget to push the i forward and skip the substring part
	                    i = end;
	                }else{
	                    // once you meet the sign, operate the number based on the previous sign
	                    if(sign=='+'){
	                        st.push(num);
	                    }
	                    if(sign=='-'){
	                        st.push(-num);
	                    }
	                    if(sign =='*'){
	                        int top = st.pop();
	                        st.push(top*num);
	                    }
	                    if(sign =='/'){
	                        int top = st.pop();
	                        st.push(top/num);
	                    }
	                    num = 0;
	                    sign = ch;
	                }
	            }
	        }
	        // cumulate all sub result
	        while(!st.empty()){
	            res += st.pop();
	        }
	        return res;
	    }
	}
}

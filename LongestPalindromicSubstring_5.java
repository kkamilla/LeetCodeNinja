package dp_palindromicSubsequence;

public class LongestPalindromicSubstring_5 {
//	Intuitively, we list all the substrings, pick those palindromic, and get the longest one. However, that causes TLE for we reach the same situations (input substrings) many times.
//
//	To optimize, we decompose the problem as follows
//
//	state variable:
//	start index and end index of a substring can identify a state, which influences our decision
//	so state variable is state(s, e) indicates whether str[s, e] is palindromic
//	goal state:
//	max(e - s + 1) that makes state(s, e) = true
//	state transition:
//	Let's observe example base cases
//
//	for s = e, "a" is palindromic,
//	for s + 1 = e, "aa" is palindromic (if str[s] = str[e])
//	for s + 2 = e, "aba" is palindromic (if str[s] = str[e] and "b" is palindromic)
//	for s + 3 = e, "abba" is palindromic (if str[s] = str[e] and "bb" is palindromic)
//	we realize that
//
//	for s + dist = e, str[s, e] is palindromic if str[s] == str[e] and str[s + 1, e - 1] is palindromic
//	state transition equation:
//
//	state(s, e) is true:
//	for s = e, 
//	for s + 1 = e,  if str[s] == str[e]
//	for s + 2 <= e, if str[s] == str[e] && state(s + 1, e - 1) is true
//	note:
//	state(s + 1, e - 1) should be calculated before state(s, e). That is, s is decreasing during the bottop-up dp implementation, while the dist between s and e is increasing, that's why
//
//	        for (int s = len - 1; s >= 0; s--) {
//	            for (int dist = 1; dist < len - i; dist++) {
//	We keep track of longestPalindromeStart, longestPalindromeLength for the final output.

	public String longestPalindrome_Order_n2(String s){
        if(s.length()==0){
           return "";
       }
       int maxLength=1;
       int startIndex=0;
        for(int i=1;i<s.length();i++){
          //find all the palidroms with i as the center and expanding around i, we get count
          //this will find odd length palindroms starting at i
          
          int left=i-1;
          int right=i+1;
          while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
              if(maxLength<right-left+1){
                  maxLength=right-left+1;
                  startIndex=left;
              }
              left--;
              right++;
          }
          
          //now expand with space after i as ceneter , and form even length palindroms with that as center
          left=i-1;
          right=i;
          while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
              if(maxLength<right-left+1){
                  maxLength=right-left+1;
                  startIndex=left;
              }
              left--;
              right++;
          }
          
          
      }
       return s.substring(startIndex,maxLength+startIndex);
   }
   
	
	
	
	public String longestPalindrome_dp(String s) {
        if(s.length()==0){
            return "";
        }
        boolean[][] dp=new boolean[s.length()][s.length()];
        
       int palindromStart=-1;
        int maxLength=0;
        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
            palindromStart=i;
            maxLength=1;
        }
        //fill len=2 substrings
        for(int i=0;i<s.length()-1;i++){
            int j=i+1;
            if(s.charAt(i)==s.charAt(j)){
                dp[i][j]=true;
                palindromStart=i;
                maxLength=2;
            }  
        }
        
        //fill len=3 to s.length() substrings
        for(int len=2;len<s.length();len++){
            for(int i=0;i<s.length()-len;i++){
                int j=i+len;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    palindromStart=i;
                    dp[i][j]=dp[i+1][j-1];
                    //as maxlength denotes end of the substring, so we need to increment by 1 to get string until len 
                    //as last char is excluded from substring()
                    maxLength=len+1;
                }  
            }
        }
        
        return s.substring(palindromStart,palindromStart+maxLength);
    }
	
	//O(n2) time and constant space solution
    public String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int len1=expandAround(s,i,i);
            //for even length substrings 
            int len2=expandAround(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
       return s.substring(start,end+1); 
    }
    
    int expandAround(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
    
    
  //here we don't use recrusion as worts case time is O(n2) for all substrigs and o(n) for checing palindrm or not
    //recursion is used when there are expotential possiblities and we need to explore everything 
//     public String longestPalindrome_rec(String s) {
//         if(s.length()==0){
//             return "";
//         }
//         Map<String,String> memo=new HashMap<>();
//         return longestPalindrome_rec( s, 0, s.length()-1,memo);
//     }
    
//     public String longestPalindrome_rec(String s,int start,int end,Map<String,String> memo) {
//         if(memo.containsKey(start+":"+end)){
// 	             return memo.get(start+":"+end);
// 	         }
//         if(start==end){
//             return s.substring(start,end+1);
//         }
//         if(start+1==end){
//             if(s.charAt(start)==s.charAt(end)){
//                 return s.substring(start,end+1);
//             }
           
//         }
//         String s1="",s2="",s3="",sf="";
//         if(s.charAt(start)==s.charAt(end)){
//             if(longestPalindrome_rec( s, start+1, end-1,memo).length()<end-start+1-2){
//                 s1= longestPalindrome_rec( s, start+1, end-1,memo);
//                 }
//             else{
//                 s1= s.charAt(start)+longestPalindrome_rec( s, start+1, end-1,memo)+s.charAt(end);
//             }
            
//         }
    
            
//         s3= longestPalindrome_rec( s, start+1, end,memo);

//         s2= longestPalindrome_rec( s, start, end-1,memo);
//         if(s3.length()>s2.length()){
//             sf=s3;
//         }
//         else{
//             sf=s2;
//         }
//         memo.put(start+":"+end,s1.length()>sf.length()?s1:sf);
//         return s1.length()>sf.length()?s1:sf;
//     }
}

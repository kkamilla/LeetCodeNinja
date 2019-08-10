package grokking_2slidingwindow;

public class MinWindowSubstring_76 {
	public String minWindow(String s, String t) {
        
        if(s.length()<t.length()){
            return "";
        }
      
        int[] s_count=new int[128];
        int[] t_count=new int[128]; 
       
        for(int i=0;i<t.length();i++){
            t_count[t.charAt(i)]++; 
        }
        int windowStart=0;
        int min_length=Integer.MAX_VALUE; 
        String res="";
    int needChars=t.length();
    int count=0;
        for(int windowEnd=0;windowEnd<s.length();windowEnd++){
            s_count[s.charAt(windowEnd)]++;
            //keep expanding the window until u cover all chars in text
            
            if(t_count[s.charAt(windowEnd)]>0 && s_count[s.charAt(windowEnd)]<=t_count[s.charAt(windowEnd)]){
                //this is a needed character in s
                count++;
            }
            //once i cover all the chars in text
            //slide the window start forwrd to see if we still cover all chars in text
            if(count==needChars){
                while(windowStart<s.length() && s_count[s.charAt(windowStart)]>t_count[s.charAt(windowStart)] || t_count[s.charAt(windowStart)]==0){
                   //slide forwrd as we want the minimum window
                    if(s_count[s.charAt(windowStart)]>t_count[s.charAt(windowStart)]){
                        s_count[s.charAt(windowStart)]--; 
                    }
                     windowStart++;
                
                }
                    //once out of while loop , it means that now the window size if min
                if(windowStart<=windowEnd && min_length>windowEnd-windowStart+1){
                    min_length=windowEnd-windowStart+1;
                    res=s.substring(windowStart,windowEnd+1);
                }
                
            }  
        }
    
            
        return res;
    }
}

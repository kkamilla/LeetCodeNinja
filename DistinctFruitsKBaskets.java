package grokking_2slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class DistinctFruitsKBaskets {
	public int totalFruit(int[] tree) {
        //here k=2 as we can collect 2 distinct fruits only
        Map<Integer, Integer> distinctFruits=new HashMap<>();
        int windowStart=0;
        int maxFruits=0;
        for(int windowEnd=0;windowEnd<tree.length;windowEnd++){
            if(distinctFruits.containsKey(tree[windowEnd])){
                int count=distinctFruits.get(tree[windowEnd]);
                count++;
                distinctFruits.put(tree[windowEnd],count);
            }
            else{
                distinctFruits.put(tree[windowEnd],1);
            }
            while(distinctFruits.size()>2){
                //remove fruits from distinct count map until its ==2
                 int count=distinctFruits.get(tree[windowStart]);
                count--;
                if(count>0){
                    distinctFruits.put(tree[windowStart],count); 
                }
               else{
                    distinctFruits.remove(tree[windowStart]);
               }
                windowStart++;
                
            }
            int sum=0;
            for (int f : distinctFruits.values()) {
                sum += f;
            }
            maxFruits=Math.max(maxFruits,sum);
        }
        return maxFruits;
    }
}

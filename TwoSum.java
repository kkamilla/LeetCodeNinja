package twoPointer;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndex_map=new HashMap<>();
        for(int index=0;index<nums.length;index++){
            int complement=target-nums[index];
            if(numIndex_map.containsKey(complement)){
            	//get index of complement and return
                return new int[]{numIndex_map.get(complement),index};
            }
            numIndex_map.put(nums[index],index);
        }
        return new int[2];
    }
}

package hash;

import java.util.HashMap;
import java.util.Map;

public class lc01 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hm=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int j=target-nums[i];
            if (hm.containsKey(j)&&i!=hm.get(j)){
                return new int []{i,hm.get(j)};
            }
        }

        return null;
    }
}

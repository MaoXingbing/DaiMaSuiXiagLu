package hash;

import java.util.HashMap;
import java.util.Map;

public class lc454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> abmap=new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (!abmap.containsKey(nums1[i]+nums2[j])){
                    abmap.put(nums1[i]+nums2[j],1);
                }else{
                    Integer integer = abmap.get(nums1[i] + nums2[j]);
                    integer++;
                    abmap.put(nums1[i] + nums2[j],integer);
                }
            }
        }
        int count=0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if (abmap.containsKey(-nums3[i] - nums4[j])){
                    count+=abmap.get(-nums3[i] - nums4[j]);
                }
            }
        }

        return count;
    }
}

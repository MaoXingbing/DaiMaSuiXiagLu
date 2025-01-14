package hash;

import java.util.HashSet;

public class lc349 {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> hs=new HashSet<>();
        for (int i : nums1) {
            for (int i1 : nums2) {
                if (i==i1){
                    hs.add(i);
                }
            }
        }

        int [] res=new int[hs.size()];
        int index=0;
        for (Integer h : hs) {
           res[index++]=h;
        }
        return  res;

    }
}

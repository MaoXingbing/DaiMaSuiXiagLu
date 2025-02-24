package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                return list;
            }

            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int left=i+1;
            int right= nums.length-1;

            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if (sum>0){
                    right--;
                }else if (sum<0){
                    left++;
                }else{
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //执行去重逻辑
                    while (left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    while (left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    right--;
                    left++;
                }

            }
        }
        return list;
    }
}

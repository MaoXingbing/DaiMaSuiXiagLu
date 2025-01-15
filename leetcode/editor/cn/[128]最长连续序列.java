//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 2245 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        //使用set数据结构 自动去重
        Set<Integer> set=new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int maxlen=0;
        for (Integer num : set) {
            //只有当 num - 1 不在集合中时，num 才是连续序列的起点
            if (!set.contains(num-1)){
                int cunrrentNum=num;
                int len=1;
                // 检查连续序列的长度
                while (set.contains(cunrrentNum + 1)) {
                    cunrrentNum+=1;
                    len+=1;
                }
                maxlen=Math.max(maxlen,len);

            }
        }
        return maxlen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

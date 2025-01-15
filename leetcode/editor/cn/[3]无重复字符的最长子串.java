//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10382 👎 0


import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 计算给定字符串中最长无重复字符的子串的长度
     * 通过维护一个滑动窗口，使用HashSet来记录窗口内字符的唯一性
     * 遍历字符串，扩展窗口右边界，遇到重复字符则停止扩展，更新最大长度并清理窗口以开始下一次遍历
     *
     * @param s 输入的字符串
     * @return 最长无重复字符子串的长度
     */
    public int lengthOfLongestSubstring(String s) {
//        // 使用HashSet记录每个字符是否出现过
//        HashSet<String> str = new HashSet<>();
//        //记录最大值
//        int max = 0;
//        //定义窗口的左右边界
//        int left = 0;
//        int right = 0;
//        //遍历字符串 直到右边界到达字符串末尾
//        while (right < s.length()) {
//            //判断set中是否出现当前字符
//            //若不在 则添加到set中
//            if (!str.contains(s.charAt(right))){
//                str.add(String.valueOf(s.charAt(right)));
//                right++;
//                //更新最大长度
//                max=Math.max(max,str.size());
//            }else {
//                //若存在相同的字符 将左边界向左滑动 为了移除相同的字符 所以不一定只移动一次
//                str.remove(String.valueOf(s.charAt(left)));
//                left++;
//            }
//        }
//
//        return max;
//    }
        Map<Character, Integer> hp=new HashMap<>();
        int max=0;
        int left=0;
        for (int i = 0; i < s.length(); i++) {
            if (hp.containsKey(s.charAt(i))){
                // 若出现重复字符，则将左边界移动到重复字符的下一个位置，并移除重复字符
                left=Math.max(left,hp.get(s.charAt(i))+1);
            }
            hp.put(s.charAt(i),i);
            max=Math.max(max,i-left+1);
        }
        return max;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

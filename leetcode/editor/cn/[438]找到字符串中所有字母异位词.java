//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1531 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        // 初始化一个HashMap来存储字符串p中每个字符的出现次数
        Map<Character, Integer> php = new HashMap<>();
        // 遍历字符串p，统计每个字符的出现次数
        for (int i = 0; i < p.length(); i++) {
            php.put(p.charAt(i), php.getOrDefault(p.charAt(i), 0) + 1);
        }

        // 初始化一个列表用于存储匹配的起始索引
        List<Integer> ans = new ArrayList<>();
        // 初始化一个HashMap来存储当前考察的子串中每个字符的出现次数
        Map<Character, Integer> scount = new HashMap<>();
        // 初始化左右指针，用于滑动窗口的左右边界
        int left = 0;
        int right = 0;
        // 存储字符串p的长度，用于后续比较子串长度
        int plen = p.length();

        // 开始滑动窗口遍历字符串s
        while (right < s.length()) {
            // 获取当前右指针指向的字符，并将其加入到scount中
            char c = s.charAt(right);
            scount.put(c, scount.getOrDefault(c, 0) + 1);

            // 当窗口大小等于字符串p的长度时，进行比较
            if (right - left + 1 == plen) {
                // 如果当前窗口中的字符出现次数与字符串p中的一致，则找到了一个匹配的子串
                if (php.equals(scount)) {
                    ans.add(left);
                }
                // 移动左指针，为下一次比较做准备
                char leftchar = s.charAt(left);
                scount.put(leftchar, scount.get(leftchar) - 1);
                // 如果左指针字符的出现次数减为0，则从scount中移除该字符
                if (scount.get(leftchar) == 0) {
                    scount.remove(leftchar);
                }
                left++;
            }
            // 移动右指针，扩大窗口
            right++;
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

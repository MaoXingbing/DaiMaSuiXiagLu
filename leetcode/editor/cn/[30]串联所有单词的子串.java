//给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。 
//
// s 中的 串联子串 是指一个包含 words 中所有字符串以任意顺序排列连接起来的子串。 
//
// 
// 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，
//"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。 
// 
//
// 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
//子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
//子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
//输出顺序无关紧要。返回 [9,0] 也是可以的。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
//解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
//s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
//所以我们返回一个空数组。
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
//解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
//子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
//子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
//子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 和 s 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1158 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        //数组的长度
        int m = words.length;
        //每个元素的长度
        int w = words[0].length();
        Map<String, Integer> hp = new HashMap();
        //将数组中的字符串元素添加到map中 次数为value
        for (int i = 0; i < words.length; i++) {
            hp.put(words[i], hp.getOrDefault(words[i], 0) + 1);
        }
        //保存结果的集合
        List<Integer> ans = new ArrayList<>();
        //枚举s中的每个字符作为起点 依次往后去取得长度为m*w的子串sub
        for (int i = 0; i + m * w <= n; i++) {
            //存储滑动窗口中的单词
            Map<String, Integer> cur = new HashMap<>();
            //定义滑动窗口  窗口的左右索引
            String sub = s.substring(i, i + m * w);
            //按照元素的长度切割滑动窗口
            for (int j = 0; j < sub.length(); j += w) {
                //切割
                String tem = sub.substring(j, j + w);
                //判断hp中是否存在 若不存在 直接结束
                //若存在 添加进cur 随后与hp进行比较
                if (!hp.containsKey(tem)) {
                    break;
                }
                cur.put(tem, cur.getOrDefault(tem, 0) + 1);
            }
            //一个完整的滑动窗口中的内容已经被添加到cur中 接着与map进行比较
            //若一致 将起始索引i添加到集合中
            if (hp.equals(cur)) {
                ans.add(i);
            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

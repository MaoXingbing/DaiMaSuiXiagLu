//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String,List<String>> map=new HashMap<String, List<String>>();
//        for (String str : strs) {
//            //对比每个str的一致性
//            char[] c=str.toCharArray();
//            //将每个str都按照字母顺序排列 排列好的str也是一个key
//            Arrays.sort(c);
//            String newstr=new String(c);
//            //判断是否存在新的键 不存在为空就建立新的
//            if (!map.containsKey(newstr)){
//                List<String> list=new ArrayList<String>();
//                list.add(str);
//                map.put(newstr,list);
//            }else { //存在就存进去
//                map.get(newstr).add(str);
//            }
//        }
//        return new ArrayList<List<String>>(map.values());
        Map<String,List<String>> hp=new HashMap<>();
        for (String str : strs) {
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String newstr=new String(chars);
            if (!hp.containsKey(newstr)){
                List<String> list=new ArrayList<>();
                list.add(str);
                hp.put(newstr,list);
            }else {
                hp.get(newstr).add(str);
            }
        }

        return new ArrayList<List<String>>(hp.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

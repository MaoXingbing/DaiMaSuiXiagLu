package hash;

import java.util.HashMap;
import java.util.Map;

public class lc383 {
    public boolean canConstruct(String ransomNote, String magazine) {

        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char ran = ransomNote.charAt(i);
            map.put(ran, map.getOrDefault(ran, 0) + 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) <= 0) {
                    continue;
                } else {
                    map.put(c, map.get(c) - 1);
                }
            }
        }

        for (int count : map.values()) {
            if (count > 0) {
                return false;
            }
        }

        return true;
    }
}

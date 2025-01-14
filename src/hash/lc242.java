package hash;

public class lc242 {
    public boolean isAnagram(String s, String t) {
        int [] record=new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i)-'a']--;
        }

        for (int i = 0; i < record.length; i++) {
            if (record[i]!=0){
                return  false;
            }
        }

        return true;
    }
}

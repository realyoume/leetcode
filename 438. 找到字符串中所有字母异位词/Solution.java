import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        findAnagrams("cbaebabacd"
               , "abc");
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int m = s.length(),n = p .length();

        if(m < n){
            return new ArrayList<Integer>();
        }

        int[] counter = new int[26];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
           counter[p.charAt(i) - 'a']--;
           counter[s.charAt(i) - 'a']++;
        }

        int diff = 0;

        for (int i = 0; i < 26; ++i) {
            if (counter[i] != 0){
                diff++;
            }
        }

        if (diff == 0){
            ans.add(0);
        }

        for (int i = 0; i + n < m; ++i) {
            if (counter[s.charAt(i)-'a'] == 1){
                diff--;
            } else if (counter[s.charAt(i) - 'a'] == 0) {
                diff++;
            }
            counter[s.charAt(i)-'a']--;

            if (counter[s.charAt(i+n)-'a'] == -1){
                diff--;
            } else if (counter[s.charAt(i+n) - 'a'] == 0) {
                diff++;
            }
            counter[s.charAt(i+n)-'a']++;

            if (diff == 0){
                ans.add(i+1);
            }
        }

        return ans;
    }
}
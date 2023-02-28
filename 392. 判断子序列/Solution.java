import java.nio.charset.StandardCharsets;

class Solution {
//    public boolean isSubsequence(String s, String t) {
//        if (s.equals("")){
//            return true;
//        }
//
//        int Slen = s.length();
//        int Tlen = t.length();
//
//        int ps = 0, pt = 0;
//
//        while (pt < Tlen){
//            if (s.charAt(ps) == t.charAt(pt)){
//                ps++;
//                if (ps == Slen){
//                    return true;
//                }
//            }
//            pt++;
//        }
//
//        return false;
//    }

    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] after = new int[m+1][26];

        for (int i = 0; i < 26; ++i) {
            after[m][i] = m;
        }

        for (int i = m-1 ; i >= 0; i--) {
            for (int j = 0; j < 26; ++j) {
                if (t.charAt(i) == j + 'a'){
                    after[i][j] = i;
                }else {
                    after[i][j] = after[i+1][j];
                }
            }
        }

        int p = 0;
        for (int i = 0; i < n; ++i) {
            if (after[p][s.charAt(i) - 'a'] == m){
                return false;
            }

            p = after[p][s.charAt(i) - 'a'] + 1;
        }

        return true;
    }
}
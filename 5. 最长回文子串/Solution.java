import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
        回文串
        从中心开始生长，中心有可能是1个，也可能是一对相同的，遍历所有位置的两种情况
        生长时判断是否满足条件，满足条件且长度大于已有答案则替代
        边界条件特判

     */
    public String longestPalindrome(String s) {
        int len = s.length();
        String ans = "";

        for (int i = 0; i < len - 1; ++i) {
            String s1 = expand(s, i , i);
            String s2 = expand(s, i, i + 1);

            if(ans.length() < s1.length()){
                ans = s1;
            }
            if(ans.length() < s2.length()){
                ans = s2;
            }
        }

        return ans.equals("") ? s.substring(0,1) : ans;
    }

    public String expand(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return s.substring(left + 1 ,right);
    }

}
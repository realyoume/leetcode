import sun.util.resources.cldr.et.TimeZoneNames_et;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    Set<String> set = new HashSet<>();


    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        int r = 0, l = 0;

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '('){
                l++;
            }else if (s.charAt(i) == ')'){
                if (l > 0){
                    l--;
                }else {
                    r++;
                }
            }
        }

        helper(s, 0, l, r);

        return new ArrayList<>(set);
    }

    public   void helper(String s, int start, int l, int r){
        if (l == 0 && r == 0 ){
            if (isValid(s)){
                set.add(s);
            }
            return;
        }



        int n = s.length();
        for (int i = start; i < n; ++i) {
            if (i != start && s.charAt(i) == s.charAt(i-1)){
                // 连续两个相同的括号，去除的效果一样，剪枝去掉
                continue;
            }

            if (l + r > s.length() - i){
                return;
            }

            if (s.charAt(i) == '(' && l > 0){
                helper(s.substring(0, i) + s.substring(i + 1), i, l-1, r);
            } else if (s.charAt(i) == ')' && r > 0) {
                helper(s.substring(0, i) + s.substring(i + 1), i, l, r - 1);
            }
        }
    }

    public  boolean isValid(String s){
        int n = s.length();
        int total = 0;

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '('){
                total++;
            } else if (s.charAt(i) == ')') {
                total--;
                if (total < 0){
                    return false;
                }
            }
        }
        return total == 0;
    }

}
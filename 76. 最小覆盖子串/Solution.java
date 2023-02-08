import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC"
                ,"ABC"));
    }
    public static String minWindow(String s, String t) {
        Map<Character, Integer> floor = new HashMap<>();

        char[] chars1 = t.toCharArray();
        for (char c : chars1) {
            floor.put(c, floor.getOrDefault(c, 0) - 1);
        }

        String rs = s + "0";

        int l = 0;
        int r = 0;

        while (r <= s.length()){
            if(! valid(floor)){
                if (r == s.length()){
                    break;
                }
                if (floor.containsKey(s.charAt(r))){
                    floor.put(s.charAt(r), floor.get(s.charAt(r)) + 1);
                }
                ++r;
            }else {

                String temp = s.substring(l, r);

                if (temp.length() < rs.length()){
                    rs = temp;
                }

                if (floor.containsKey(s.charAt(l))){
                    floor.put(s.charAt(l), floor.get(s.charAt(l)) - 1);
                }
                ++l;
            }
        }

        if (rs.length() > s.length()){
            return "";
        }else {
            return rs;
        }
    }

    public  static  boolean valid(Map<Character, Integer> floor){
        for (Integer value : floor.values()) {
            if (value < 0){
                return false;
            }
        }
        return true;
    }
}

/*
76. 最小覆盖子串
这是一道滑动窗口的题目，想了其他的方法，最后写出来和答案差不多
故名思意，滑动窗口就是在上面滑动，用两个指针指向头尾，当我们找满足条件的串时，把右指针向右滑动，尽可能满足条件，
满足条件后，我们将左指针向右滑动，尽可能找到最短的串，左指针移动时，可能出现不满足条件的情况，这时我们又可以移动右指针，直到右指针来到末尾
这道题用了一个hashmap记录字符的多少，判断是否满足条件，我们只要记录匹配串的字符，其他的不用管
在一个字符串中找满足条件的字串，都可以考虑滑动窗口的方式
 */
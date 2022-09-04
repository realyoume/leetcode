import java.util.*;

// class Solution {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> ans = new ArrayList<>();
//        boolean flag;
//
//        for (String str : strs) {
//            flag = false;
//            for (List<String> list : ans) {
//                if(match(str,list.get(0))){
//                    list.add(str);
//                    flag = true;
//                    break;
//                }
//            }
//
//            if (!flag){
//                List<String> temp = new ArrayList<>();
//                temp.add(str);
//                ans.add(temp);
//            }
//        }
//
//        return ans;
//    }
//
//    public boolean match(String s1, String s2){
//        if(s1.length() != s2.length()){
//            return false;
//        }
//        char[] chars1 = s1.toCharArray();
//        char[] chars2 = s2.toCharArray();
//
//        Arrays.sort(chars1);
//        Arrays.sort(chars2);
//
//        for (int i = 0; i < chars1.length; ++i){
//            if (chars1[i] != chars2[i]){
//                return false;
//            }
//        }
//
//        return true;
//    }


// }

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

/*
    自己写的比较笨重
    相似单词的共同点是构成它们的字母相同
    于是先排序得到统一的标志，作为哈希表的key，以找到相同的加入
    数组自带的排序，哈希表的key，都提高了效率
 */

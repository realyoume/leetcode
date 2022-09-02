import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        backtrack(ans, n, n, new String(""));

        return ans;
    }

    public void backtrack(List<String> ans, int left, int right, String str){
        if(left == 0 && right == 0){
            ans.add(str);
            return;
        }

        if (left == right){
            backtrack(ans, left, right-1, ")"+str);
        }else if(left > right){
            if(right > 0){
                backtrack(ans, left, right-1, ")"+str);
            }
            backtrack(ans, left-1, right, "("+str);
        }

    }
}

/*
    用回溯法来遍历所有可能的结果
    在遍历的过程加以判断，把不对的分支都杀死，最后得到正确的结果都加入到结果集中
    注意到如果已有的字符中左括号多余右括号，那么就肯定是错误的，
    所以只保留剩余中左括号多样右括号的条件，同时相等时，只能先加右括号，
 */
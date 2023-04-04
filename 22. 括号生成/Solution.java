import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrace(ans, new StringBuilder(), n, 0, 0);
        return ans;
    }

    public void backtrace(List<String> ans,StringBuilder str, int max, int open, int close){
        if (str.length() == 2 * max){
            ans.add(str.toString());
        }

        if (open < max){
            // 可以添加左括号
            str.append("(");
            backtrace(ans, str, max, open+1, close);
            str.deleteCharAt(str.length()-1);
        }

        if (close < open){
            str.append(")");
            backtrace(ans, str, max, open, close+1);
            str.deleteCharAt(str.length()-1);
        }
    }
}
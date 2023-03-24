import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        isValid("([)]");
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<Character>();

        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
                stack.offerFirst(chars[i]);
            }
            else if(chars[i] == ')'){
                if(!stack.isEmpty() && stack.peekFirst() == '('){
                    stack.pollFirst();
                }else  {
                    return false;
                }
            }
            else if(chars[i] == ']'){
                if(!stack.isEmpty() && stack.peekFirst() == '['){
                    stack.pollFirst();
                }else  {
                    return false;
                }
            }
            else if(chars[i] == '}'){
                if(!stack.isEmpty() && stack.peekFirst() == '{'){
                    stack.pollFirst();
                }else  {
                    return false;
                }
            }
        }

        if(!stack.isEmpty() ){
            return false;
        }

        return true;
    }
}
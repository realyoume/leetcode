import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,1,1,1,1};
        int[] arr2 = new int[]{1,0,1};
        addNegabinary(arr1, arr2);
    }


    public static int[] addNegabinary(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;

        LinkedList<Integer> ans = new LinkedList<>();

        int c = 0;
        int index = 0;

        while (index < len1 || index < len2){
            int val1 = index < len1 ? arr1[len1 - 1 - index] : 0;
            int val2 = index < len2 ? arr2[len2 - 1 - index] : 0;

            int sum = c + val1 + val2;
            c = 0;

            if (sum >= 2){
                sum -= 2;
                c = -1;
            }else if (sum == -1){
                sum = 1;
                c = 1;
            }

            ans.offerFirst(sum);
            index++;
        }

        if (c == -1){
            ans.offerFirst(1);
            ans.offerFirst(1);
        }

        while (ans.peekFirst() == 0 && ans.size() > 1){
            ans.pollFirst();
        }

        int[] ret = new int[ans.size()];
        for (int i = 0; i < ans.size(); ++i) {
            ret[i] = ans.get(i);
        }

        return ret;
    }
}

import java.util.LinkedList;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        LinkedList<int[]> list = new LinkedList<>();

        int[] ans = new int[size];
        ans[size-1] = 0;
        list.offerFirst(new int[]{temperatures[size-1], size-1});

        for (int i = size-2 ; i >= 0 ; --i) {
            while (list.size() != 0){
                if (temperatures[i] >= list.peekFirst()[0]){
                    list.pollFirst();
                }else {
                    break;
                }
            }

            if (list.size() == 0){
                ans[i] = 0;
            }else {
                ans[i] = list.peekFirst()[1] - i;
            }

            list.addFirst(new int[]{temperatures[i], i});
        }

        return ans;
    }
}
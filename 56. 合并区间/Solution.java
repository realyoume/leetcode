import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1];
            if( ans.size() == 0 || l > ans.get(ans.size()-1)[1]){
                ans.add(new int[]{l,r});
            }else {
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], r);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}

/*
    这道题自己没想出来好的办法
    用到了两个少见的方法，一个是自定义的排序，用二维数组的前一项来排序，调用了系统的接口，这样大大简化了运算
    第二个是arraylist向数组转化时用了模板来确定
 */
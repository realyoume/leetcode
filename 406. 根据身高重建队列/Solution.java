import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        reconstructQueue(new int[][]{{9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}});
    }
    public  static int[][] reconstructQueue(int[][] people) {
        int n = people.length;

        int[][] ans = new int[n][2];

        for (int i = 0; i < n; ++i) {
            ans[i][0] = -1;
        }

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else {
                    return o2[1] - o1[1];
                }

            }
        });

        for (int i = 0; i < n; ++i) {
            int[] pair = people[i];

            int before = pair[1];
            int begin = 0;
            while (begin < n){
                if (ans[begin][0] == -1){
                    if (before == 0){
                        ans[begin] = people[i];
                        break;
                    }

                    before--;
                }
                begin++;
            }
        }

        return ans;
    }
}
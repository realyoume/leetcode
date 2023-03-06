import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();
        UnionFind unionFind = new UnionFind(2*size);

        Map<String, Integer> strMap = new HashMap<>(2 * size);

        int id = 0;
        int index = 0;
        for (List<String> equation : equations) {
            String str1 = equation.get(0);
            String str2 = equation.get(1);

            if (!strMap.containsKey(str1)){
                strMap.put(str1, id++);
            }

            if (!strMap.containsKey(str2)){
                strMap.put(str2, id++);
            }

            unionFind.union(strMap.get(str1), strMap.get(str2), values[index++]);
        }

        size = queries.size();
        double[] ans = new double[size];
        int ansIndex = 0;
        for (List<String> query : queries) {
            String str1 = query.get(0);
            String str2 = query.get(1);

            ans[ansIndex++] = unionFind.isConnected(strMap.get(str1), strMap.get(str2));
        }

        return ans;
    }

    class UnionFind{
        // 记录父元素
        private int[] parent;

        // 记录相对父元素的大小
        private double[] weight;


        UnionFind(int size){
            parent = new int[size];
            weight = new double[size];
            for (int i = 0; i < size; ++i) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int id1, int id2, double value){
            int parent1 = find(id1);
            int parent2 = find(id2);

            if (parent1 == parent2){
                return;
            }

            parent[parent1] = parent2;
            weight[parent1] = value * weight[id2] / weight[id1];
        }

        public int find(int id){
            if (parent[id] != id){
                int oldParent = parent[id];
                parent[id] = find(parent[id]);
                weight[id] *= weight[oldParent];
            }

            return parent[id];
        }

        public double isConnected(Integer id1, Integer id2){
            if (id1 == null || id2 == null){
                return  -1.0d;
            }

            int parent1 = find(id1);
            int parent2 = find(id2);

            if (parent1 != parent2){
                return -1.0d;
            }

            return weight[id1] / weight[id2];
        }
    }


}

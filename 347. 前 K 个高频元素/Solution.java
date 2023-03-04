import java.util.*;

// class Solution {
    // 我的解法
//    public int[] topKFrequent(int[] nums, int k) {
//        int n = nums.length;
//
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for(int i = 0; i < n; i++){
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//            // System.out.println(nums[i] + " " + map.get(nums[i]));
//        }
//
//        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
//
//        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });
//
//        // for(int i = 0; i < list.size(); i++){
//        //     System.out.print(list.get(i).getValue() + " ");
//        // }
//
//        int[] ans = new int[k];
//
//        for(int i = 0; i < k; i++){
//            ans[i] = list.get(i).getKey();
//        }
//
//        return ans;
//    }

//}

class Solution {
    // 基于堆排序找到最大的k个值
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        // 数组中第一个是元素值，第二个是元素出现次数
        PriorityQueue<int[]> maxK = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> integerIntegerEntry : counter.entrySet()) {
            int value = integerIntegerEntry.getKey(), count = integerIntegerEntry.getValue();

            if (maxK.size() == k){
                if (maxK.peek()[1] < count){
                    maxK.poll();
                    maxK.offer(new int[]{value, count});
                }
            }else {
                maxK.offer(new int[]{value, count});
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = maxK.poll()[0];
        }

        return ans;
    }
}
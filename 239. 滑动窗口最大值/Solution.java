import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution {
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        int[] ans = new int[n-k+1];
//
//        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
//            }
//        });
//
//        for (int i = 0; i < k; ++i) {
//            queue.offer(new int[]{nums[i], i});
//        }
//
//        ans[0] = queue.peek()[0];
//
//        for (int i = k; i < n; ++i) {
//            queue.offer(new int[]{nums[i], i});
//
//            while (queue.peek()[1] <= i - k){
//                queue.poll();
//            }
//
//            ans[i-k+1] = queue.peek()[0];
//        }
//
//        return ans;
//    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] ans = new int[n-k+1];

        Deque<int[]> deque = new LinkedList<>();

        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && deque.peekLast()[0] < nums[i]){
                deque.pollLast();
            }

            deque.offerLast(new int []{nums[i], i});
        }
        ans[0] = deque.peekFirst()[0];

        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && deque.peekLast()[0] < nums[i]){
                deque.pollLast();
            }

            deque.offerLast(new int[]{nums[i], i});

            while ( deque.peekFirst()[1] <= i - k ){
                deque.pollFirst();
            }

            ans[i-k+1] = deque.peekFirst()[0];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ints = maxSlidingWindow(new int[]{1, 5, 10, -5, 1, 10, -57}, 2);

        for (int i = 0; i < ints.length; ++i) {
            System.out.print(ints[i] + " ");
        }
    }
}
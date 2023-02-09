import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

//    public static void main(String[] args) {
//        int[] a = {2,1,5,6,2,3};
//        System.out.println(largestRectangleArea(a));
//    }
public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int[] left = new int[n];
    int[] right = new int[n];

    Deque<Integer> mono_stack = new ArrayDeque<Integer>();
    for (int i = 0; i < n; ++i) {
        while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
            mono_stack.pop();
        }
        left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
        mono_stack.push(i);
    }

    mono_stack.clear();
    for (int i = n - 1; i >= 0; --i) {
        while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
            mono_stack.pop();
        }
        right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
        mono_stack.push(i);
    }

    int ans = 0;
    for (int i = 0; i < n; ++i) {
        ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
    }
    return ans;
}


//    public int largest(int[] heights, int l, int r){
//        if (r < l){
//            return 0;
//        }
//
//        int ans = 0;
//        int min = l;
//
//        for (int i = l; i <= r; ++i) {
//            if (heights[i] < heights[min]){
//                min = i;
//            }
//        }
//
//        ans = Math.max(heights[min]*(r-l+1), Math.max(largest(heights, l, min-1), largest(heights, min+1, r)));
//
//        return ans;
//    }
}

/*
84. 柱状图中最大的矩形
求最大矩阵，可以枚举高或宽
这里选择的是枚举高，选择一根柱子，如果以它为高，就说明他是一定区域内最矮的一根，我们将其向两边扩展，直到发现比它还矮的就停下来
先考虑在一边找到矮的，就是往数组前面看，我们发现其实一些比较是不必要的，如果你比b矮，那么比b高的a也就不用看了，所以我们维护一个单调栈来记录你要比较的对象
也就是剔除了一部分元素后剩下的，作为后来者，如果你比栈的元素矮，你也可以将他们踢出去，边界是-1，可以认为无限高
 */
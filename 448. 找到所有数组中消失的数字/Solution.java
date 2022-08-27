import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 0 自己写的 复杂度比较高
//        List<Integer> ans = new ArrayList<>();
//
//        int len = nums.length;
//
//        Arrays.sort(nums);
//
//        int count = 1;
//        for (int i = 0; i < len; ++i){
//            if(nums[i]  == count){
//                ++count;
//            }else if(nums[i] > count){
//                ans.add(count);
//                ++count;
//                --i;
//            }
//        }
//
//        for (int i = count; i <= len; ++i){
//            ans.add(i);
//        }
//
//        return ans ;

        // 1 标准答案
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;

    }
}

/*
    利用数组本身来记录该数字是否存在
    0-(n-1)   --->    1-n
    遍历数组，出现一个数m,那么我们就让数组(m-1)%n 处加上n（数组长度），
    如果该位置的数大于n，说明该数存在，我们读取时模n来消除影响
    最后遍历，如果小于等于n，那么就加入不存在中
 */
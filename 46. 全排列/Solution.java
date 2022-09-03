import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrace(nums, ans, nums.length, new ArrayList<>());
        return ans;
    }

    public void backtrace(int[] nums, List<List<Integer>> ans, int count, List<Integer> combination){
        if(count == 0){
            ans.add(new ArrayList<>(combination)); // 这里特别注意，不要加进去引用
            return;
        }

        for (int num : nums) {
            if(!combination.contains(num)){
                combination.add(num);
                backtrace(nums, ans, count-1, combination);
                combination.remove(combination.size()-1);
            }
        }
    }

}

/*
    又是回溯法，直接写了出来，然后没有通过，原因是在答案中一直加一个引用，应该新创一个拷贝
    然后就通过了，时间复杂度高一些，因为在判断元素是否已经添加时，我用了arraylist的contain方法，而答案自己维护了数组
    标准答案要逻辑复杂一些，但性能高一些
    2022年9月3日16点36分
 */
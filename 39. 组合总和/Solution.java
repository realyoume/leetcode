import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(candidates, 0, target ,new ArrayList<>());
        return ans;
    }

    public void backtrace(int [] candidates,int begin, int target, List<Integer> combination){
        if(target == 0){
            ans.add(new ArrayList<>(combination));
        }else {
            for (int i = begin; i < candidates.length; ++i) {
                if(candidates[i] > target){
                    break;
                }

                combination.add(candidates[i]);
                backtrace(candidates, i,target-candidates[i],combination);
                combination.remove(combination.size()-1);
            }
        }
    }

//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> ans = new ArrayList<List<Integer>>();
//        List<Integer> combine = new ArrayList<Integer>();
//        dfs(candidates, target, ans, combine, 0);
//        return ans;
//    }
//
//    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
//        if (idx == candidates.length) {
//            return;
//        }
//        if (target == 0) {
//            ans.add(new ArrayList<Integer>(combine));
//            return;
//        }
//        // 直接跳过
//        dfs(candidates, target, ans, combine, idx + 1);
//        // 选择当前数
//        if (target - candidates[idx] >= 0) {
//            combine.add(candidates[idx]);
//            dfs(candidates, target - candidates[idx], ans, combine, idx);
//            combine.remove(combine.size() - 1);
//        }
//    }
}

/*
    回溯法，自己的思路还是有的，不过写出来后复杂度很高，剪枝操作后好一些
    标准答案也是回溯法，但是走的过程不一样，一下子就差距很大
    本来在思考差距到底在哪里，后来看到一个一样思路的复杂度却很低
    结果发现是因为我用了Stack，改用ArrayList之后直接起飞
    还是不太了解这些具体的差距在哪里
 */
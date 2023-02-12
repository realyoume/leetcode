class Solution {
    public static void main(String[] args) {
        searchRange(new int[]{1}, 1);
    }
    public static int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        if (r == -1){
            return new int[]{-1, -1};
        }


        while (l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] < target){
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            }else {
                l = mid;
                r = mid;
                break;
            }
        }

        if (l > r){
            return new int[]{-1, -1};
        }

        while (l-1 >=0 && nums[l-1] == target){
            --l;
        }

        while (r+1 < nums.length && nums[r+1] == target){
            ++r;
        }

        return new int[]{l, r};
    }
}

/*
经典的二分查找，要点是有单调的数组，要求的速度是log n
这道题查一个区间，其实只是多了一步，可以找到后向左右扩展
也可以先找第一个大于等于的和第一个大于的，也能找到区间，
 */
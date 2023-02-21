class Solution {
    public static void main(String[] args) {
        lengthOfLIS(new int[]{4,10,4,3,8,9});
    }
    public  static int lengthOfLIS(int[] nums) {
        int size = nums.length;
        if (size == 0 || size == 1){
            return size;
        }

        int[] base = new int[size+1];

        base[1] = nums[0];
        int len = 1;

        for (int i = 1; i < size; ++i) {
            int target = nums[i];
            if (target > base[len]){
                len++;
                base[len] = target;
            }else {
                int l = 1, r = len;
                int ans = len;

                while (l <= r){
                    int mid = (l + r) >> 1;
                    if (base[mid] >= target){
                        ans = mid;
                        r = mid - 1;
                    }else {
                        l = mid + 1;
                    }
                }

                base[ans] = target;
            }
        }

        return len;
    }
}
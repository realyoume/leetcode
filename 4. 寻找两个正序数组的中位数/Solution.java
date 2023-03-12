class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    // 找到两个有序数组中第k小的值
    public  double getKthElement(int[] nums1, int[] nums2, int k){
        int m = nums1.length;
        int n = nums2.length;

        int index1 = 0, index2 = 0;

        while (true){
            if (index1 == m){
                return nums2[index2 + k - 1];
            }
            if (index2 == n){
                return nums1[index1 + k - 1];
            }

            if (k == 1){
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;

            int newIndex1 = Math.min(index1 + half, m) - 1;
            int newIndex2 = Math.min(index2 + half, n) - 1;

            if (nums1[newIndex1] <= nums2[newIndex2]){
                // 排除num1中newIndex1前的元素
                k -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            }else {
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }
    }
}

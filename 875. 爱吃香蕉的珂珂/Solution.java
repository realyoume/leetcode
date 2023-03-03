class Solution {
    public static void main(String[] args) {
        minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];

        for (int i = 0; i < piles.length; ++i) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }

        int ans = max;
        int l = 1, r = max;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (timeCost(piles, mid) <= h) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public static long timeCost(int[] piles, int speed) {
        long ans = 0;
        for (int i = 0; i < piles.length; ++i) {

            ans += piles[i] / speed;
            ans += piles[i] % speed == 0 ? 0 : 1;

        }
        return ans;
    }
}
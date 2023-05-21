import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        storeWater(new int[]{9,0,1}, new int[]{0,2,2});
    }

    public static int storeWater(int[] bucket, int[] vat) {
        int maxk = Arrays.stream(vat).max().getAsInt();

        if (maxk == 0){
            return 0;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i < maxk && i <= result; ++i) {
            int count = i;

            for (int j = 0; j < vat.length; ++j) {
                int temp = Math.max(0, (vat[j] + i - 1) / i - bucket[j]);
                count += temp;
            }

            result = Math.min(result, count);
        }

        return result;
    }
}
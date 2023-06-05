class Solution {
    public double[] sampleStats(int[] count) {
        int left = 0, right = count.length - 1;

        while (count[left] == 0){
            left++;
        }
        double min = left;

        while (count[right] == 0){
            right--;
        }
        double max = right;

        long sum = 0;
        long num = 0;

        for (int i = 0; i < count.length; ++i) {
            sum += (long) i * count[i];
            num += count[i];
        }

        double mean = (double) sum / num;

        int mode = 0;
        for (int i = 0; i < count.length; ++i) {
            if (count[i] > count[mode]){
                mode = i;
            }
        }

        double medium = 0;
        if (num % 2 == 0){
            medium = ((double) findK(count, num/2) + (double) findK(count, num/2 + 1)) / 2;
        }else {
            medium = (double) findK(count, num/2 + 1);
        }

        return new double[]{min, max, mean,  medium, (double)mode};
    }

    public int findK(int[] count, long k){
        for (int i = 0; i < count.length; ++i) {
            k -= count[i];
            if (k <= 0){
                return i;
            }
        }
        return -1;
    }
}


class Solution {
    public static void main(String[] args) {
        addBinary("10","11");
    }

    public static String addBinary(String a, String b) {
        char[] a_ = new StringBuilder(a).reverse().toString().toCharArray();
        char[] b_ = new StringBuilder(b).reverse().toString().toCharArray();

        int aLen = a.length();
        int bLen = b.length();

        StringBuilder ans = new StringBuilder();

        int c = 0;
        int max = Math.max(aLen, bLen);
        for (int i = 0; i < max; ++i) {
            int m = i < aLen ? a_[i] - '0' : 0;
            int n = i < bLen ? b_[i] - '0' : 0;

            int sum = m + n + c;
            c = 0;
            if (sum >= 2){
                sum -= 2;
                c = 1;
            }
            ans.append(sum);
        }

        if (c == 1){
            ans.append("1");
        }

        return ans.reverse().toString();
    }
}
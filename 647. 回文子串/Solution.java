class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();

        int ans = 0;
        for(double i = 0; i < len; i = i + 0.5){
            int left = (int)Math.floor(i);
            int right = (int)Math.ceil(i);

            while (left >= 0 && right < len && chars[left] == chars[right]){
                ans++;
                left--;
                right++;
            }
        }

        return ans;
    }
}
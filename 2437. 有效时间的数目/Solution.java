class Solution {

    public static void main(String[] args) {
        countTime("0?:0?");
    }
    public static int countTime(String time) {
        boolean[] wenhao = new boolean[5];

        for (int i = 0; i < 5; ++i) {
            wenhao[i] = time.charAt(i) == '?';
        }

        int ans = 1;

        if (wenhao[0] && wenhao[1]){
            ans *= 24;
        }else if (wenhao[1]){
            if (time.charAt(0) == '2'){
                ans *= 4;
            }else {
                ans *= 10;
            }
        }else if (wenhao[0]){
             if (time.charAt(1) > '3'){
                 ans *= 2;
             }else {
                 ans *= 3;
             }
        }

        if (wenhao[3] && wenhao[4]){
            ans *= 60;
        }else if (wenhao[3]){
            ans *= 6;
        }else if (wenhao[4]){
            ans *= 10;
        }

        return ans;
    }
}
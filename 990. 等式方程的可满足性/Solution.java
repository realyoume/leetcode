class Solution {
    public static void main(String[] args) {
        equationsPossible(new String[]{"a==b","b!=c","c==a"});
    }

    public static boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];

        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }

        for(String str : equations){
            if(str.charAt(1) == '='){
                int symbol1 = str.charAt(0) - 'a';
                int symbol2 = str.charAt(3) - 'a';

                parent[find(parent, symbol2)] = find(parent, symbol1);


            }
        }

        for(String str : equations){
            if(str.charAt(1) == '!'){
                int symbol1 = str.charAt(0) - 'a';
                int symbol2 = str.charAt(3) - 'a';
                if(find(parent, symbol1) == find(parent, symbol2)){
                    return false;
                }
            }
        }

        return true;
    }

    public  static int find(int[] parent, int symbol){
        while(parent[symbol] != symbol){
            parent[symbol] = parent[parent[symbol]];
            symbol = parent[symbol];
        }

        return parent[symbol];
    }
}
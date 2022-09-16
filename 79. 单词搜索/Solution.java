class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(backtrace(board,word,0,i,j,m,n)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean backtrace(char[][] board, String word, int index, int x, int y, int m, int n){
        if(x < 0 || x >= m || y < 0 || y >= n){
            return false;
        }

        if(board[x][y] != word.charAt(index)){
            return false;
        }

        if(index == word.length() - 1){
            return true;
        }

        char temp = board[x][y];
        board[x][y] = '0';
        if(
                backtrace(board,word,index+1,x+1,y,m,n) ||
                        backtrace(board,word,index+1,x-1,y,m,n) ||
                        backtrace(board,word,index+1,x,y+1,m,n) ||
                        backtrace(board,word,index+1,x,y-1,m,n)
        ){
            return true;
        }

        board[x][y] = temp;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        Solution solution = new Solution();
        solution.exist(board,"ABCB");
    }
}

/*
    还是写了很久，和答案一样是回溯法，但是在细节上有点不同
    答案维护了二维数组表示是否访问过，我直接修改了原数组，在回溯后再改回来
    还有边界条件的判断，答案是先判定，再回溯，我是在回溯中判定，个人认为我这样写要简单一些
 */
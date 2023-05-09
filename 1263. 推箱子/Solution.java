import java.util.LinkedList;

class Solution {
    static int m;

    static int n;

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'#','.','.','#','#','#','#','#'},{'#','.','.','T','#','.','.','#'},{'#','.','.','.','#','B','.','#'},{'#','.','.','.','.','.','.','#'},{'#','.','.','.','#','.','S','#'},{'#','.','.','#','#','#','#','#'}};
        System.out.println(minPushBox(grid));
    }

    public static int minPushBox(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int[][] steps = new int[m][n];

        int x = -1, y = -1;
        int Tx = -1, Ty = -1;
        int boxX = -1,boxY = -1;
        int personX = -1,personY = -1;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 'T'){
                    Tx = i;
                    Ty = j;
                    grid[i][j] = '.';
                }
                if (grid[i][j] == 'B'){
                    boxX = i;
                    boxY = j;
                    grid[i][j] = '.';
                }
                if (grid[i][j] == 'S'){
                    personX = i;
                    personY = j;
                    grid[i][j] = '.';
                }

            }
        }

        steps[Tx][Ty] = 1;
        LinkedList<int[]> move = new LinkedList<>();
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        move.offerLast(new int[]{personX, personY});

        boolean[][] reach = new boolean[m][n];
        reach[personX][personY] = true;
        while (!move.isEmpty()){
            int[] position = move.pollFirst();
            x = position[0];
            y = position[1];

            for (int[] direction : directions) {
                if (inBox(x+direction[0],y+direction[1]) && grid[x+direction[0]][y+direction[1]] == '.'){
                    grid[x+direction[0]][y+direction[1]] = '1';
                    reach[x+direction[0]][y+direction[1]] = true;
                    move.offerLast(new int[]{x+direction[0], y+direction[1]});
                }
            }
        }

        move.clear();

        move.offerLast(new int[]{Tx, Ty});

        while (!move.isEmpty()){
            int[] position = move.pollFirst();
            x = position[0];
            y = position[1];

            for (int[] direction : directions) {
                if (inBox(x+direction[0],y+direction[1]) && inBox( x+2*direction[0],y+2*direction[1])
                        && reach[x+direction[0]][y+direction[1]]
                        && reach[x+2*direction[0]][y+2*direction[1]]
                        && steps[x+direction[0]][y+direction[1]] == 0){

                    steps[x+direction[0]][y+direction[1]] = steps[x][y] + 1;
                    move.offerLast(new int[]{x+direction[0], y+direction[1]});
                }

                if (steps[boxX][boxY] != 0){
                    return steps[boxX][boxY] - 1;
                }
                
            }
        }

        return -1;
    }

    public static boolean inBox(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
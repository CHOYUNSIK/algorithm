package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step5 {

    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
    }

    static void dfs(int x, int y) {
        if(y == 9){
            dfs(x+1,0);
            return;
        }

        if(x == 9){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if(map[x][y] == 0){
            for (int i = 1; i <= 9; i++) {
                if(valueCheck(x,y,i)){
                    map[x][y] = i;
                    dfs(x,y+1);
                }
            }
            map[x][y] = 0;
            return;
        }

        dfs(x, y+1);
    }

    static boolean valueCheck (int x, int y, int v) {

        for (int i = 0; i < 9; i++) {
            if (map[x][i] == v) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (map[i][y] == v) {
                return false;
            }
        }

        int row = (x/3)*3;
        int col = (y/3)*3;

        for (int i = row; i < row+3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (map[i][j] == v) {
                    return false;
                }
            }
        }
        return true;
    }
}

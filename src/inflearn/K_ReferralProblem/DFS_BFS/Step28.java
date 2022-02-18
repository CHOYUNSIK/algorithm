package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step28 {

    static int n, m, h, result;
    static int[][] map;

    static boolean check = false;


    static int searchOrderNum() {
        int orderNum = 0;
        for (int i = 1; i < n; i++) {
            int num = 0;
            for (int j = 1; j <= h; j++) {
                if (map[j][i] == 1) {
                    num++;
                }
            }
            if (num % 2 == 1) orderNum++;
        }

        return orderNum;
    }

    static boolean check() {
        for (int i = 1; i <= n; i++) {
            int ny = i;
            int nx = 1;

            while (nx <= h) {
                if (map[nx][ny] == 1) ny++;
                else if (map[nx][ny] == 2) ny--;
                nx++;
            }
            if (i != ny) return false;
        }

        return true;
    }

    static void dfs(int x, int y, int num) {
        if (check) return;
        if (num == result) {
            if (check()) {
                check = true;
                System.out.println(result);
                return;
            }
        }
        for (int i = x; i <= h; i++) {
            for (int j = y; j < n; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    dfs(x + 1, y + 2, num + 1);
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
            y = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h + 1][n + 1];


        int x, y;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[x][y + 1] = 2;
        }

        if (searchOrderNum() > 3) {
            System.out.println(-1);
            return;
        }
        else {
            for (int i = 0; i <= 3; i++) {
                result = i;
                dfs(1, 1, 0);
                if (check) break;
            }
        }

        System.out.println(-1);

        /*for (int i = 0; i <= h; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }*/

    }
}

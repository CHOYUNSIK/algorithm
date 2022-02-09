package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step19 {

    static int[][] map;
    static int first;
    static int two;
    static int three;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, n);
        System.out.println(first);
        System.out.println(two);
        System.out.println(three);

    }

    static void dfs(int x, int y, int size) {
        if (check(x, y, size)) {
            if (map[x][y] == -1) {
                first++;
            } else if (map[x][y] == 0) {
                two++;
            } else {
                three++;
            }
            return;
        }

        int newSize = size / 3;

        dfs(x, y, newSize);
        dfs(x, y + newSize, newSize);
        dfs(x, y + 2 * newSize, newSize);

        dfs(x + newSize, y, newSize);
        dfs(x + newSize, y + newSize, newSize);
        dfs(x + newSize, y + 2 * newSize, newSize);

        dfs(x + 2 * newSize, y, newSize);
        dfs(x + 2 * newSize, y + newSize, newSize);
        dfs(x + 2 * newSize, y + 2 * newSize, newSize);

    }

    static boolean check(int x, int y, int size) {
        int color = map[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}

package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step23 {

    static int n, m, result = 0;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dfs(i,j)){
                    result++;
                }
            }
        }

        System.out.println(result);

    }

    static boolean dfs(int x, int y) {
        boolean result = false;

        if (x < 0 || x >= n || y < 0 || y >= m) {
            return true;
        }

        if(map[x][y] == 'T'){
            return true;
        }else if(map[x][y] == 'F'){
            return false;
        }

        if(visited[x][y]) return false;

        visited[x][y] = true;

        switch (map[x][y]) {
            case 'U':
                result = dfs(x - 1, y);
                break;
            case 'R':
                result = dfs(x, y + 1);
                break;
            case 'D':
                result = dfs(x + 1, y);
                break;
            case 'L':
                result = dfs(x, y - 1);
                break;
        }

        map[x][y] = result ? 'T' : 'F';

        return result;
    }
}
